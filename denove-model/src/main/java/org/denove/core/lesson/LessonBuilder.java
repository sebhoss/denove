package org.denove.core.lesson;

import java.util.Collection;

import org.denove.core.word.Word;

/**
 * A LessonBuilder is used to construct a new {@link Lesson}. For that it offers some sort of method-chaining and some
 * getters to the supplied objects.
 */
public interface LessonBuilder extends Supplier<Lesson> {

    /**
     * <p>
     * Adds a {@linkplain Word word} to the new {@linkplain Lesson lesson}.
     * </p>
     * 
     * <p>
     * Does not accept duplicate words.
     * </p>
     * 
     * @param word
     *            The new word for the lesson (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    LessonBuilder word(Word word);

    /**
     * <p>
     * Adds a collection of {@linkplain Word words} to the new {@linkplain Lesson lesson}.
     * </p>
     * 
     * <p>
     * Does not accept duplicate words.
     * </p>
     * 
     * @param words
     *            The collection of words for the new lesson (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    LessonBuilder words(Collection<Word> words);

}
