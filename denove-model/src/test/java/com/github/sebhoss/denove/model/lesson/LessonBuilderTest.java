package com.github.sebhoss.denove.model.lesson;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.github.sebhoss.denove.model.word.Word;

/**
 * Test cases for the {@link LessonBuilder} interface and its underlying implementation.
 */
@SuppressWarnings("static-method")
public final class LessonBuilderTest {

    /**
     * Test method for {@link LessonBuilder#word(Word)}.
     */
    @Test
    public void shouldHaveGivenWord() {
        // given
        final Word word = mock(Word.class);
        final LessonBuilder builder = Lessons.prepareLesson();

        // when
        final Lesson lesson = builder.word(word).get();

        // then
        assertThat(lesson.getWords(), hasItem(word));
    }

    /**
     * Ensures that the {@link LessonBuilder#word(Word) word(Word)} method does not accept <code>null</code> as valid
     * input.
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerOnNull() {
        Lessons.prepareLesson().word(null);
    }

    /**
     * Ensures that the {@link LessonBuilder#word(Word) word(Word)} method does not add duplicates.
     */
    @Test
    public void shouldDiscardDuplicate() {
        // given
        final Word word = mock(Word.class);
        final LessonBuilder builder = Lessons.prepareLesson().word(word);

        // when
        final Lesson lesson = builder.word(word).get();

        // then
        assertThat(Integer.valueOf(lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * Test method for {@link LessonBuilder#words(Collection)}.
     */
    @Test
    public void shouldHaveGivenWords() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<>();
        words.add(word);
        final LessonBuilder builder = Lessons.prepareLesson();

        // when
        final Lesson lesson = builder.word(word).get();

        // then
        assertThat(lesson.getWords(), hasItem(word));
    }

    /**
     * Ensures that the {@link LessonBuilder#words(Collection) words(Collection)} method does not add duplicates.
     */
    @Test
    public void shouldDiscardDuplicates() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<>();
        words.add(word);
        final LessonBuilder builder = Lessons.prepareLesson();

        // when
        final Lesson lesson = builder.word(word).words(words).get();

        // then
        assertThat(lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(lesson.getWords().size()), is(Integer.valueOf(1)));
    }

}
