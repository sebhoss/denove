package org.denove.core.lesson.implementation;

import java.util.Collections;
import java.util.Set;

import org.denove.core.lesson.Lesson;
import org.denove.core.word.Word;

import com.google.common.base.Preconditions;

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
        this.words = Preconditions.checkNotNull(words);

        assert this.words != null : "Words may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public Set<Word> getWords() {
        return Collections.unmodifiableSet(this.words);
    }

}
