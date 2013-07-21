package org.denove.core.word;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.denove.core.translation.Translation;
import org.junit.Test;

/**
 * Test cases for the {@link WordBuilder} interface and its underlying implementation.
 */
@SuppressWarnings("static-method")
public final class WordBuilderTest {

    /**
     * Test method for {@link WordBuilder#translation(Locale, Translation)}.
     */
    @Test
    public void testTranslation() {
        // given
        final Translation trans = mock(Translation.class);
        final WordBuilder builder = Words.prepareWord().grammarType(GrammarType.ADJECTIVE);

        // when
        final Word word = builder.translation(Locale.getDefault(), trans).get();

        // then
        assertThat(word.getTranslations().values(), hasItem(trans));
    }

    /**
     * Ensures that the {@link WordBuilder#translation(Locale, Translation) translation(Locale, Translation)} method
     * does not accept duplicates.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTranslationDoesNotAcceptDuplicates() {
        // given
        final Translation trans = mock(Translation.class);
        final WordBuilder builder = Words.prepareWord().grammarType(GrammarType.ADJECTIVE);

        // when
        final Word word = builder.translation(Locale.getDefault(), trans).translation(Locale.getDefault(), trans).get();

        // then
        assertThat(word.getTranslations().values(), hasItem(trans));
        assertThat(Integer.valueOf(word.getTranslations().size()), is(Integer.valueOf(1)));
    }

    /**
     * Ensures that the {@link WordBuilder#translation(Locale, Translation) translation(Locale, Translation)} method
     * does not accept <code>null</code> as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void testTranslationDoesNotAcceptNull() {
        Words.prepareWord().translation(Locale.getDefault(), null);
    }

    /**
     * Test method for {@link WordBuilder#translations(Map)}.
     */
    @Test
    public void testTranslations() {
        // given
        final Translation trans = mock(Translation.class);
        final Map<Locale, Translation> translations = new TreeMap<>();
        translations.put(Locale.getDefault(), trans);

        // when
        final Word word = Words.prepareWord().translations(translations).grammarType(GrammarType.UNKNOWN).get();

        // then
        assertThat(word.getTranslations().values(), hasItem(trans));
    }

    /**
     * Ensures that the {@link WordBuilder#translations(Map) translations(Collection)} method does not accept
     * <code>null</code> as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void testTranslationsDoesNotAcceptNull() {
        Words.prepareWord().translations(null);
    }

    /**
     * Test method for {@link WordBuilder#grammarType(GrammarType)}.
     */
    @Test
    public void testGrammarType() {
        // given
        final WordBuilder builder = Words.prepareWord().translation(Locale.getDefault(), mock(Translation.class));

        // when
        final Word word = builder.grammarType(GrammarType.ADJECTIVE).get();

        // then
        assertThat(word.getGrammarType(), is(equalTo(GrammarType.ADJECTIVE)));
    }

    /**
     * Ensures that the {@link WordBuilder#grammarType(GrammarType) grammarType(GrammarType)} method does not accept
     * <code>null</code> as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void testGrammarTypeDoesNotAcceptNull() {
        Words.prepareWord().grammarType(null);
    }

}
