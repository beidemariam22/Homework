package Class;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ReadText {
    private static final Logger LOGGER= LogManager.getLogger(ReadText.class);
    public void ReadFile() throws IOException {

        try {
            // Read text from file
            String text = FileUtils.readFileToString(new File("C:\\Users\\HP\\IdeaProjects\\Homework\\src\\main\\resources\\input"));

            // Calculate number of unique words
            List<String> words = Arrays.asList(StringUtils.split(text));
            Set<String> uniqueWords = new HashSet<>(words);
            int count = uniqueWords.size();
            // Write result to file
            FileUtils.writeStringToFile(new File("output.txt"), String.valueOf(count));
            LOGGER.info("Total words: " + words.size());
            LOGGER.info("Unique words: " + uniqueWords.size());
            LOGGER.info("Count: " + count);
        } catch (FileNotFoundException e) {
            LOGGER.info("The file does not exist.");
        } catch (IOException e) {
            LOGGER.error("Failed to read/write file: " + e.getMessage());
        }
    }
}
