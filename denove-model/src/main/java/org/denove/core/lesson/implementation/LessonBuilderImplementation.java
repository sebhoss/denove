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

    private final Builder<Word> words;

    /**
     * Constructor for a new {@link LessonBuilder}.
     */
    public LessonBuilderImplementation() {
        this.words = ImmutableSet.<Word> builder();
    }

    @Override
    public Lesson get() {
        Preconditions.checkState(this.words != null);

        return new LessonImplementation(this.words.build());
    }

    @Override
    public LessonBuilder word(final Word word) {
    	this.words.add(word);

        return this;
    }

    @Override
    public LessonBuilder words(final Collection<Word> wordsToAdd) {
    	this.words.addAll(wordsToAdd);
    	
        return this;
    }

}
