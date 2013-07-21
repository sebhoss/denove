package org.denove.core.lesson.implementation;

import java.util.Collection;

import org.denove.core.lesson.Lesson;
import org.denove.core.lesson.LessonBuilder;
import org.denove.core.word.Word;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

/**
 * Implementation of the {@link LessonBuilder} interface.
 */
public final class LessonBuilderImplementation implements LessonBuilder {

    private final Builder<Word> wordsBuilder;

    /**
     * Constructor for a new {@link LessonBuilder}.
     */
    public LessonBuilderImplementation() {
        wordsBuilder = ImmutableSet.<Word> builder();
    }

    @Override
    public Lesson get() {
        Preconditions.checkState(wordsBuilder != null);
        final ImmutableSet<Word> words = wordsBuilder.build();
        Preconditions.checkState(words.size() > 0);

        return new LessonImplementation(words);
    }

    @Override
    public LessonBuilder word(final Word word) {
        wordsBuilder.add(word);

        return this;
    }

    @Override
    public LessonBuilder words(final Collection<Word> wordsToAdd) {
        wordsBuilder.addAll(wordsToAdd);

        return this;
    }

}
