package org.denove.core.lesson;

import java.util.Collection;
import java.util.Set;

import org.denove.core.word.Word;

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
     * <p>
     * Adds a new {@linkplain Word word} to this {@linkplain Lesson lesson}.
     * </p>
     * 
     * <p>
     * Does not accept duplicate words.
     * </p>
     * 
     * @param word
     *            The word to add (<b>may not be <code>null</code></b>).
     * @return <code>true</code> if word could be added, <code>false</code> otherwise.
     */
    boolean addWord(Word word);

    /**
     * Removes a {@linkplain Word word} from this {@linkplain Lesson lesson}.
     * 
     * @param word
     *            The word to remove (<b>may not be <code>null</code></b>).
     * @return <code>true</code> if word could be removed, <code>false</code> otherwise.
     */
    boolean removeWord(Word word);

    /**
     * <p>
     * Adds a collection of {@linkplain Word words} to this {@linkplain Lesson lesson}.
     * </p>
     * 
     * <p>
     * Does not accept duplicate words.
     * </p>
     * 
     * @param words
     *            The words to add (<b>may not be <code>null</code></b>).
     * @return <code>true</code> if words could be added, <code>false</code> otherwise.
     */
    boolean addAllWords(Collection<Word> words);

    /**
     * Removes all {@linkplain Word words} from this {@linkplain Lesson lesson}.
     */
    void clearWords();

    /**
     * Gets all {@linkplain Word words} in this {@linkplain Lesson lesson}.
     * 
     * @return An unmodifiable set of all words in this lesson.
     */
    public Set<Word> getWords();

}
