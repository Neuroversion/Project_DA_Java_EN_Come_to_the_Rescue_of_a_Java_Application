package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Write in result.out file
 *
 * @author Ridouan
 */
public class WriteSymptomOccurrenceToFile implements ISymptomWriter {

    private String filename;

    public WriteSymptomOccurrenceToFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeSymptomsOccurrences(Map<String, Integer> occurrence) {
        if (filename != null) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

                for (Entry<String, Integer> line : occurrence.entrySet()) {
                    
                    // Extract symptoms keys and values and write them into a file
                    writer.append(line.getKey() + "=" + line.getValue() + ";");
                    writer.newLine();
                }

            } catch (IOException e) {
                System.err.println("Error, file cannot be writed");
                e.printStackTrace();
            }

        }

    }

}
