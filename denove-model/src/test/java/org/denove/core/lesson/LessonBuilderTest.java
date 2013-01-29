package org.denove.core.lesson;

import java.util.ArrayList;
import java.util.Collection;

import org.denove.core.word.Word;

/**
 * Test cases for the {@link LessonBuilder} interface and its underlying implementation.
 * 
 */
public final class LessonBuilderTest {

    /**
     * Test method for {@link LessonBuilder#word(Word)}.
     */
    @Test
    public void testWord() {
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
    @Test(expected = IllegalArgumentException.class)
    public void testWordDoesNotAcceptNull() {
        Lessons.prepareLesson().word(null);
    }

    /**
     * Ensures that the {@link LessonBuilder#word(Word) word(Word)} method does not add duplicates.
     */
    @Test
    public void testWordDoesNotAcceptDuplicates() {
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
    public void testWords() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<Word>();
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
    public void testWordsDoesNotAcceptDuplicates() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<Word>();
        words.add(word);
        final LessonBuilder builder = Lessons.prepareLesson();

        // when
        final Lesson lesson = builder.word(word).words(words).get();

        // then
        assertThat(lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(lesson.getWords().size()), is(Integer.valueOf(1)));
    }

}
