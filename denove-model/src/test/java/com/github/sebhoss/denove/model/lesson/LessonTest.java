package com.github.sebhoss.denove.model.lesson;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.github.sebhoss.denove.model.word.Word;

/**
 * Test cases for the {@link Lesson} interface and its underlying implementation.
 * 
 */
public final class LessonTest {

    private Lesson lesson;
    private Word   word;

    /**
     * Prepares a single translation which should be used by all tests in this class.
     */
    @Before
    public final void setUp() {
        word = mock(Word.class);
        lesson = Lessons.prepareLesson().word(word).get();
    }

    /**
     * Test method for {@link com.github.sebhoss.denove.model.lesson.Lesson#getWords()}.
     */
    @Test
    public void testGetWords() {
        assertThat(lesson.getWords(), notNullValue());
    }

}
