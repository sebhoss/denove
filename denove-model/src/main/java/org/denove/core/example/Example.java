package org.denove.core.example;

/**
 * DOC: Write documentation for type 'Example'!
 */
public interface Example extends Comparable<Example> {

    /**
     * Gets the enclosed example sentence.
     * 
     * @return The example sentence.
     */
    String getSentence();

    /**
     * Gets the correct form of a word inside the enclosed example sentence.
     * 
     * @return The correct form of the word.
     */
    String getCorrectForm();

}
