package com.github.sebhoss.denove.model.lesson;

import java.util.Set;

import com.github.sebhoss.denove.model.word.Word;

/**
 * <h1>Overview</h1>
 * <p>
 * A lesson holds a set of {@linkplain Word words} as well as informations about those words and how to iterate them.
 * </p>
 * 
 * <h1>Warnings</h1>
 * <p>
 * 
 * </p>
 * 
 * <h1>Examples</h1>
 * <p>
 * 
 * </p>
 * 
 * @see Word
 */
public interface Lesson {

    /**
     * Gets all {@linkplain Word words} in this {@linkplain Lesson lesson}.
     * 
     * @return An unmodifiable set of all words in this lesson.
     */
    public Set<Word> getWords();

}
