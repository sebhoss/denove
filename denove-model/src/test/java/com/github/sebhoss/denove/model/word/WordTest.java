package com.github.sebhoss.denove.model.word;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.github.sebhoss.denove.model.translation.Translation;

/**
 * Test cases for the {@link Word} interface and its underlying implementation.
 */
@SuppressWarnings("static-method")
public final class WordTest {

    private Word word;

    /**
     * DOC: Write documentation for method setUp!
     * 
     */
    @Before
    public void setUp() {
        word = Words.prepareWord().translation(Locale.getDefault(), mock(Translation.class)).get();
    }

    /**
     * Test method for {@link Word#getAvailableLanguages()}.
     */
    @Test
    public void shouldReturnAvailableLanguages() {
        assertThat(word.getAvailableLanguages(), is(notNullValue()));
        assertThat(Integer.valueOf(word.getAvailableLanguages().size()), is(equalTo(Integer.valueOf(1))));
    }

    /**
     * Test method for {@link Word#getTranslation(Locale)}.
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionForNullTranslation() {
        word.getTranslation(null);
    }

    /**
     * Test method for {@link Word#getTranslation(Locale)}.
     */
    @Test
    public void shouldReturnMatchingTranslation() {
        // given
        final Translation trans = mock(Translation.class);

        // when
        final Word newWord = Words.prepareWord().translation(Locale.CANADA, trans).get();

        // then
        assertThat(newWord.getTranslation(Locale.CANADA), is(trans));
    }

    /**
     * DOC: Write documentation for method testGetTranslationDoesNotAcceptFalseLocale!
     * 
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionOnUnknownLocale() {
        // given
        final Translation trans = mock(Translation.class);

        // when
        final Word newWord = Words.prepareWord().translation(Locale.CANADA, trans).get();

        // then
        newWord.getText(Locale.CANADA_FRENCH);
    }

    /**
     * Test method for {@link Word#getText(Locale)}.
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionForNullLocaleInText() {
        word.getText(null);
    }

    /**
     * Test method for {@link Word#getExample(Locale)}.
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionForNullLocaleInExample() {
        word.getExample(null);
    }

    /**
     * Test method for {@link Word#getTranslations()}.
     */
    @Test
    public void shouldReturnAvailableTranslations() {
        assertThat(word.getTranslations(), is(notNullValue()));
        assertThat(Integer.valueOf(word.getTranslations().size()), is(equalTo(Integer.valueOf(1))));
    }

}
