package org.denove.core.word;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Locale;

import org.denove.core.translation.Translation;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link Word} interface and its underlying implementation.
 */
public final class WordTest {

    private Word word;

    /**
     * DOC: Write documentation for method setUp!
     * 
     */
    @Before
    public void setUp() {
        this.word = Words.prepareWord().translation(Locale.getDefault(), mock(Translation.class))
                .grammarType(GrammarType.ADJECTIVE).get();
    }

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

}
