package org.denove.core.lesson;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link Lesson} interface and its underlying implementation.
 * 
 */
public final class LessonTest {

    private Lesson lesson;

    /**
     * Prepares a single translation which should be used by all tests in this class.
     */
    @Before
    public final void setUp() {
        this.lesson = Lessons.prepareLesson().get();
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#getWords()}.
     */
    @Test
    public void testGetWords() {
        assertThat(this.lesson.getWords(), notNullValue());
    }

}
