package com.github.sebhoss.denove.model.word;

import java.util.Hashtable;
import java.util.Locale;

import com.github.sebhoss.denove.model.translation.Translation;
import com.github.sebhoss.denove.model.word.implementation.WordBuilderImplementation;

/**
 * Utility class which is used to create new {@linkplain Word words} by using a {@link WordBuilder}. Thus this class
 * eliminates the need for the "new" keyword.
 * 
 * @see Word
 */
public final class Words {

    /**
     * Prepares a new {@link Word} by returning a new {@link WordBuilder} which is used to construct the word.
     * 
     * @return A new WordBuilder.
     */
    public static WordBuilder prepareWord() {
        return new WordBuilderImplementation(new Hashtable<Locale, Translation>());
    }

    private Words() {
        // Do nothing..
    }

}
