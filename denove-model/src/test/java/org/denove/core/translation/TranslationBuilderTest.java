/* Project: core
 * Package: org.denove.core.translation
 * File   : TranslationBuilderTest.java
 * Created: Sep 9, 2009 - 4:36:01 PM
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
package org.denove.core.translation;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.junit.Test;

/**
 * Test cases for the {@link TranslationBuilder} interface and its underlying implementation.
 *
 * @author  Sebastian Hoß (mail@shoss.de)
 * @version 1.0.0
 * @since   1.0.0
 */
public final class TranslationBuilderTest {

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                             CONSTANTS                                           *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    private static final double SCORE      = 2D;
    private static final int    TRY_COUNT  = 5;
    private static final int    MISS_COUNT = 3;

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              TESTS                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

    /**
     * <p>Test method for {@link TranslationBuilder#text(LocalizedText)}.</p>
     * 
     * <p>Ensures that the given text will really be set.</p>
     */
    @Test
    public void testText() {
        // given
        final LocalizedText text = mock(LocalizedText.class);
        final TranslationBuilder builder = Translations.prepareTranslation().example(mock(Example.class)).creationDate(
                new Date()).lastQuestionedDate(new Date());

        // when
        final Translation translation = builder.text(text).get();

        // then
        assertThat(translation.getLocalizedText(), is(text));
    }

    /**
     * <p>Test method for {@link TranslationBuilder#text(LocalizedText)}.</p>
     * 
     * <p>Ensures that you can't set <code>null</code> as text.</p>
     */
    @Test(expected = NullPointerException.class)
    public void testTextDoesNotAcceptNull() {
        Translations.prepareTranslation().text(null);
    }

    /**
     * Test method for {@link TranslationBuilder#example(Example)}.
     */
    @Test
    public void testExample() {
        // given
        final Example example = mock(Example.class);
        final TranslationBuilder builder = Translations.prepareTranslation().text(mock(LocalizedText.class)).creationDate(
                new Date()).lastQuestionedDate(new Date());

        // when
        final Translation translation = builder.example(example).get();

        // then
        assertThat(translation.getExample(), is(example));
    }

    /**
     * Ensures that the {@link TranslationBuilder#example(Example)
     * example(String, String} method does not accept <code>null</code> as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void testExampleDoesNotAcceptNullSentence() {
        Translations.prepareTranslation().example(null);
    }

    /**
     * Test method for {@link TranslationBuilder#score(double)}.
     */
    @Test
    public void testScore() {
        // given
        final TranslationBuilder builder = Translations.prepareTranslation().text(mock(LocalizedText.class)).creationDate(
                new Date()).lastQuestionedDate(new Date()).example(mock(Example.class));

        // when
        final Translation translation = builder.score(SCORE).get();

        // then
        assertThat(Double.valueOf(translation.getScore()), is(equalTo(Double.valueOf(SCORE))));
    }

    /**
     * Ensures that the {@link TranslationBuilder#score(double) score(double)} method
     * does not accept negative numbers.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testScoreDoesNotAcceptNegatives() {
        Translations.prepareTranslation().score(-1D).get();
    }

    /**
     * Test method for {@link TranslationBuilder#tryCount(int)}.
     */
    @Test
    public void testTryCount() {
        // given
        final TranslationBuilder builder = Translations.prepareTranslation().text(mock(LocalizedText.class)).creationDate(
                new Date()).lastQuestionedDate(new Date()).example(mock(Example.class));

        // when
        final Translation translation = builder.tryCount(TRY_COUNT).get();

        // then
        assertThat(Integer.valueOf(translation.getTryCount()), is(equalTo(Integer.valueOf(TRY_COUNT))));
    }

    /**
     * Ensures that the {@link TranslationBuilder#tryCount(int) tryCount(int)} method
     * does not accept negative numbers.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTryCountDoesNotAcceptNegatives() {
        Translations.prepareTranslation().tryCount(-1).get();
    }

    /**
     * Test method for {@link TranslationBuilder#missCount(int)}.
     */
    @Test
    public void testMissCount() {
        // given
        final TranslationBuilder builder = Translations.prepareTranslation().text(mock(LocalizedText.class)).creationDate(
                new Date()).lastQuestionedDate(new Date()).example(mock(Example.class));

        // when
        final Translation translation = builder.missCount(MISS_COUNT).get();

        // then
        assertThat(Integer.valueOf(translation.getMissCount()), is(equalTo(Integer.valueOf(MISS_COUNT))));
    }

    /**
     * Ensures that the {@link TranslationBuilder#missCount(int) missCount(int)}
     * method does not accept negative numbers.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMissCountDoesNotAcceptNegatives() {
        Translations.prepareTranslation().missCount(-1).get();
    }

} // End class TranslationBuilderTest
