package com.hemebiotech.analytics;

import java.util.*;

/**
 * Service which permit to compute statistics about symptoms.
 *
 * @author Ridouan
 */
public class AnalyticsCounter {
    /**
     * Compute analytics about symptoms in the results.out file.
     */
    public void computeAnalytics() {
        try {
            // Read symptom from file symptom.txt
            ISymptomReader reader = new ReadSymptomDataFromFile("symptom.txt");
            List<String> symptoms = reader.getSymptoms();
            /*
             * Count occurrences of each symptom using occurrence method below
             */
            Map<String, Integer> occurrencesMap = nbOccurrencesMap(symptoms);

            // Sort occurrences symptoms by alphabetical order.
            TreeMap<String, Integer> occurrencesMapSorted = sortOccurrenceMap(occurrencesMap);
            /*
             * Write the occurrence number of each symptom in the file "results.out"
             */
            ISymptomWriter symptomWriter = new WriteSymptomOccurrenceToFile("results.out");
            symptomWriter.writeSymptomsOccurrences(occurrencesMapSorted);
            
        } catch (Exception e) {
            System.err.println("Error, files cannot be counted");
            e.printStackTrace();
        }
    }

    private Map<String, Integer> nbOccurrencesMap(List<String> symptoms) {
        Set<String> uniqueSymptoms = new HashSet<>(symptoms);
        Map<String, Integer> myMap = new HashMap<>();
        for (String symptom : uniqueSymptoms) {
            int nbOccurrenceSymptom = Collections.frequency(symptoms, symptom);
            myMap.put(symptom, nbOccurrenceSymptom);
        }

        return myMap;
    }

    /*
     * Sort occurrences symptoms by alphabetical order.
     */
    private TreeMap<String, Integer> sortOccurrenceMap(Map<String, Integer> occurrenceMap) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.putAll(occurrenceMap);

        return treeMap;
    }
}

