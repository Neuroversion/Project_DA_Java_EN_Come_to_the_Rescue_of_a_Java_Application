package com.hemebiotech.analytics;

import java.util.Map;

/**
 * WriteSymptomOccurrenceToFile Interface
 *
 * @author Ridouan
 */
public interface ISymptomWriter {
    /**
     * @param occurrence
     */
    void writeSymptomsOccurrences(Map<String, Integer> occurrence);


}
