package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.logging.log4j.core.util.Closer.close;
import static org.example.Aircraft.LOGGER;
import static sun.security.ssl.SSLLogger.info;

public class ReadText {

    public void ReadFile() throws IOException {
    // Read text from file
    String text = FileUtils.readFileToString(new File("C:\\Users\\HP\\IdeaProjects\\Homework\\src\\main\\resources\\input"));

    // Calculate number of unique words
        try {
            List<String> words = Arrays.asList(StringUtils.split(text));
            Set<String> uniqueWords = new HashSet<>(words);
            int count = uniqueWords.size();
            // Write result to file
            FileUtils.writeStringToFile(new File("output.txt"), String.valueOf(count));
            LOGGER.info("Total words" + words);
            LOGGER.info("Unique words" + uniqueWords);
            LOGGER.info(count);

        }catch(FileNotFoundException e){
            LOGGER.info("The file is not exist ");
        }

    }

}
