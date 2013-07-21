package com.github.sebhoss.denove.model.word;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;

import com.github.sebhoss.denove.model.translation.Translation;

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
        final WordBuilder builder = Words.prepareWord();

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
        final WordBuilder builder = Words.prepareWord();

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
        final Map<Locale, Translation> translations = new HashMap<>();
        translations.put(Locale.getDefault(), trans);

        // when
        final Word word = Words.prepareWord().translations(translations).get();

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

}
