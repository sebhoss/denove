/* Project: core
 * Package: org.denove.core.lesson
 * File   : LessonBuilderTest.java
 * Created: Sep 14, 2009 - 2:42:06 PM
 *
 *
 * Copyright 2009 Sebastian Hoß
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.denove.core.lesson;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.denove.core.word.Word;
import org.junit.Test;

/**
 * Test cases for the {@link LessonBuilder} interface and its underlying implementation.
 *
 * @author 	Sebastian Hoß (mail@shoss.de)
 * @version	1.0.0
 * @since	1.0.0
 */
public final class LessonBuilderTest {

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              TESTS                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

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
     * Ensures that the {@link LessonBuilder#word(Word) word(Word)} method does
     * not accept <code>null</code> as valid input.
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

} // End LessonBuilderTest
