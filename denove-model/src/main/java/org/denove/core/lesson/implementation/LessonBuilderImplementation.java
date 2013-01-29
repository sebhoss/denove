package org.denove.core.lesson.implementation;

import java.util.Collection;
import java.util.Set;

import org.denove.core.lesson.Lesson;
import org.denove.core.lesson.LessonBuilder;
import org.denove.core.word.Word;

/**
 * Implementation of the {@link LessonBuilder} interface.
 */
public final class LessonBuilderImplementation implements LessonBuilder {

    private final Set<Word> words;

    /**
     * Constructor for a new {@link LessonBuilder}.
     * 
     * @param words
     *            The words for the new lesson (<b>may not be <code>null</code></b>).
     */
    public LessonBuilderImplementation(final Set<Word> words) {
        this.words = checkNotNull(words);

        assert this.words != null : "Words may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public Lesson get() {
        checkState(this.words != null);

        return new LessonImplementation(this.words);
    }

    @Override
    public LessonBuilder word(final Word word) {
        join(this.words).enforce(DefaultPredicate.<Word> get()).with(word);

        return this;
    }

    @Override
    public LessonBuilder words(final Collection<Word> wordsToAdd) {
        join(this.words).enforce(DefaultPredicate.<Word> get()).with(wordsToAdd);

        return this;
    }

}
