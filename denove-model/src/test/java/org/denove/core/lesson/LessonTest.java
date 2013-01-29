/* Project: core
 * Package: org.denove.core.lesson
 * File   : LessonTest.java
 * Created: Sep 14, 2009 - 7:18:14 PM
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
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.denove.core.word.Word;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link Lesson} interface and its underlying implementation.
 *
 * @author 	Sebastian Hoß (mail@shoss.de)
 * @version	1.0.0
 * @since	1.0.0
 */
public final class LessonTest {

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                            ATTRIBUTES                                           *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /** The lesson which acts as the test object. */
    private Lesson lesson;

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              SETUP                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /**
     * Prepares a single translation which should be used by all tests in this class.
     */
    @Before
    public final void setUp() {
        this.lesson = Lessons.prepareLesson().get();
    }

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              TESTS                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#addWord(org.denove.core.word.Word)}.
     */
    @Test
    public void testAddWord() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
    }

    /**
     * <p>Test method for {@link Lesson#addWord(Word)}.</p>
     * 
     * <p>Ensures that you can't add the same word twice.</p>
     */
    @Test
    public void testAddWordDoesNotAcceptDuplicates() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);
        this.lesson.addWord(word);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * <p>Test method for {@link Lesson#addWord(Word)}.</p>
     * 
     * <p>Ensures that you can't add <code>null</code>.</p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddWordDoesNotAcceptNull() {
        this.lesson.addWord(null);
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#removeWord(org.denove.core.word.Word)}.
     */
    @Test
    public void testRemoveWord() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);
        this.lesson.removeWord(word);

        // then
        assertThat(this.lesson.getWords(), not(hasItem(word)));
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#addAllWords(java.util.Collection)}.
     */
    @Test
    public void testAddAllWords() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<Word>();
        words.add(word);

        // when
        this.lesson.addAllWords(words);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * <p>Test method for {@link Lesson#addAllWords(Collection)}.</p>
     * 
     * <p>Ensures that you can't add duplicates.</p>
     */
    @Test
    public void testAddAllWordsDoesNotAcceptDuplicates() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<Word>();
        words.add(word);

        // when
        this.lesson.addWord(word);
        this.lesson.addAllWords(words);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#clearWords()}.
     */
    @Test
    public void testClearWords() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);
        this.lesson.clearWords();

        // then
        assertThat(this.lesson.getWords(), not(hasItem(word)));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(equalTo(Integer.valueOf(0))));
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#getWords()}.
     */
    @Test
    public void testGetWords() {
        assertThat(this.lesson.getWords(), is(notNullValue()));
    }

} // End class LessonTest
