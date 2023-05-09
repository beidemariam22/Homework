package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadText {

    public void ReadFile() throws IOException {
    // Read text from file
    String text = FileUtils.readFileToString(new File("C:\\Users\\HP\\IdeaProjects\\Homework\\src\\main\\resources\\input"));

    // Calculate number of unique words
    List<String> words = Arrays.asList(StringUtils.split(text));
    Set<String> uniqueWords = new HashSet<>(words);
    int count = uniqueWords.size();
    // Write result to file
      FileUtils.writeStringToFile(new File("output.txt"), String.valueOf(count));
        System.out.println(words);
        System.out.println(uniqueWords);
        System.out.println(count);

    }

}
