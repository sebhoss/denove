package org.denove.core.lesson.implementation;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.denove.core.lesson.Lesson;
import org.denove.core.word.Word;

/**
 * Implementation of the {@link Lesson} interface.
 */
public final class LessonImplementation implements Lesson {

    private final Set<Word> words;

    /**
     * Creates a new lesson.
     * 
     * @param words
     *            The words for the new lesson (<b>may not be <code>null</code></b>).
     */
    public LessonImplementation(final Set<Word> words) {
        this.words = checkNotNull(words);

        assert this.words != null : "Words may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public boolean addAllWords(final Collection<Word> wordsToAdd) {
        return join(this.words).with(wordsToAdd);
    }

    @Override
    public boolean addWord(final Word word) {
        return join(this.words).enforce(DefaultPredicate.<Word> get()).with(word);
    }

    @Override
    public void clearWords() {
        this.words.clear();
    }

    @Override
    public boolean removeWord(final Word word) {
        return this.words.remove(checkNotNull(word));
    }

    @Override
    public Set<Word> getWords() {
        return Collections.unmodifiableSet(this.words);
    }

}
