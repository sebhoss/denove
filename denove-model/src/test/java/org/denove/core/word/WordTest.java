/* Project: core
 * Package: org.denove.core.word
 * File   : WordTest.java
 * Created: Sep 12, 2009 - 2:19:19 PM
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
package org.denove.core.word;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Locale;

import org.denove.core.translation.Translation;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link Word} interface and its underlying implementation.
 *
 * @author 	Sebastian Hoß (mail@shoss.de)
 * @version	1.0.0
 * @since	1.0.0
 */
public final class WordTest {

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                            ATTRIBUTES                                           *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /** The word object under test. */
    private Word word;

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              SETUP                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /**
     * DOC: Write documentation for method setUp!
     *
     */
    @Before
    public void setUp() {
        this.word = Words.prepareWord().translation(Locale.getDefault(), mock(Translation.class)).grammarType(
                GrammarType.ADJECTIVE).get();
    }

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              TESTS                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /**
     * Test method for {@link Word#getAvailableLanguages()}.
     */
    @Test
    public void testGetAvailableLanguages() {
        assertThat(this.word.getAvailableLanguages(), is(notNullValue()));
        assertThat(Integer.valueOf(this.word.getAvailableLanguages().size()), is(equalTo(Integer.valueOf(1))));
    }

    /**
     * Test method for {@link Word#getTranslation(Locale)}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetTranslationDoesNotAcceptNull() {
        this.word.getTranslation(null);
    }

    /**
     * Test method for {@link Word#getTranslation(Locale)}.
     */
    @Test
    public void testGetTranslation() {
        // given
        final Translation trans = mock(Translation.class);

        // when
        final Word newWord = Words.prepareWord().grammarType(GrammarType.ADJECTIVE).translation(Locale.CANADA, trans)
                .get();

        assertThat(newWord.getTranslation(Locale.CANADA), is(trans));
    }

    /**
     * DOC: Write documentation for method testGetTranslationDoesNotAcceptFalseLocale!
     *
     */
    @Test(expected = NullPointerException.class)
    public void testGetTranslationDoesNotAcceptFalseLocale() {
        // given
        final Translation trans = mock(Translation.class);

        // when
        final Word newWord = Words.prepareWord().grammarType(GrammarType.ADJECTIVE).translation(Locale.CANADA, trans)
                .get();

        // then
        newWord.getText(Locale.CANADA_FRENCH);
    }

    /**
     * Test method for {@link Word#getText(Locale)}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetTextDoesNotAcceptNull() {
        this.word.getText(null);
    }

    /**
     * Test method for {@link Word#getExample(Locale)}.
     */
    @Test(expected = NullPointerException.class)
    public void testGetExample() {
        this.word.getExample(null);
    }

    /**
     * Test method for {@link Word#getTranslations()}.
     */
    @Test
    public void testGetTranslations() {
        assertThat(this.word.getTranslations(), is(notNullValue()));
        assertThat(Integer.valueOf(this.word.getTranslations().size()), is(equalTo(Integer.valueOf(1))));
    }

} // End class WordTest
