package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read symptom.txt file
 *
 * @author Ridouan
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<String>();

        /** Reader with file path and exceptions handling */

        if (filepath != null) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.err.println("Error, file cannot be loaded");
                e.printStackTrace();
            }
        }

        return result;
    }

}
