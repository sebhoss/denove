package com.github.sebhoss.denove.model.lesson.implementation;

import java.util.Collections;
import java.util.Set;

import com.github.sebhoss.denove.model.lesson.Lesson;
import com.github.sebhoss.denove.model.word.Word;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/**
 * Implementation of the {@link Lesson} interface.
 */
public final class LessonImplementation implements Lesson {

    private final ImmutableSet<Word> words;

    /**
     * Creates a new lesson.
     * 
     * @param words
     *            The words for the new lesson (<b>may not be <code>null</code></b>).
     */
    public LessonImplementation(final ImmutableSet<Word> words) {
        this.words = Preconditions.checkNotNull(words);

        assert this.words != null : "Words may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public Set<Word> getWords() {
        return Collections.unmodifiableSet(words);
    }

}
