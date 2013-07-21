package com.github.sebhoss.denove.model.word;

import static org.hamcrest.CoreMatchers.hasItem;
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
    public void shouldContainGivenTranslation() {
        // given
        final Translation translation = mock(Translation.class);
        final WordBuilder builder = Words.prepareWord();

        // when
        final Word word = builder.translation(Locale.getDefault(), translation).get();

        // then
        assertThat(word.getTranslations().values(), hasItem(translation));
    }

    /**
     * Ensures that the {@link WordBuilder#translation(Locale, Translation) translation(Locale, Translation)} method
     * does not accept duplicates.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptDuplicateTranslation() {
        // given
        final Translation translation = mock(Translation.class);

        // when
        final WordBuilder builder = Words.prepareWord().translation(Locale.getDefault(), translation)
                .translation(Locale.getDefault(), translation);

        // then
        builder.get();
    }

    /**
     * Ensures that the {@link WordBuilder#translation(Locale, Translation) translation(Locale, Translation)} method
     * does not accept a <code>null</code> {@link Translation} as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void shouldNotAcceptNullTranslation() {
        Words.prepareWord().translation(Locale.getDefault(), null);
    }

    /**
     * Test method for {@link WordBuilder#translations(Map)}.
     */
    @Test
    public void shouldContainGivenTranslations() {
        // given
        final Translation translation = mock(Translation.class);
        final Map<Locale, Translation> translations = new HashMap<>();
        translations.put(Locale.getDefault(), translation);

        // when
        final Word word = Words.prepareWord().translations(translations).get();

        // then
        assertThat(word.getTranslations().values(), hasItem(translation));
    }

    /**
     * Ensures that the {@link WordBuilder#translations(Map) translations(Map)} method does not accept <code>null</code>
     * as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void shouldNotAcceptNullTranslations() {
        Words.prepareWord().translations(null);
    }

    /**
     * Test method for {@link WordBuilder#translations(Map)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptDuplicateTranslations() {
        // given
        final Translation translation = mock(Translation.class);
        final Map<Locale, Translation> translations = new HashMap<>();
        translations.put(Locale.getDefault(), translation);

        // when
        final WordBuilder builder = Words.prepareWord().translation(Locale.getDefault(), translation)
                .translations(translations);

        // then
        builder.get();
    }

}
