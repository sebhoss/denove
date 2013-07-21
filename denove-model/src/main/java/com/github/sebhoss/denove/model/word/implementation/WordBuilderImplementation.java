package com.github.sebhoss.denove.model.word.implementation;

import java.util.Locale;
import java.util.Map;

import com.github.sebhoss.denove.model.translation.Translation;
import com.github.sebhoss.denove.model.word.Word;
import com.github.sebhoss.denove.model.word.WordBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * Implementation of the {@link WordBuilder} interface.
 */
public final class WordBuilderImplementation implements WordBuilder {

    private final Builder<Locale, Translation> translations;

    /**
     * Constructor for a new {@link WordBuilderImplementation}.
     * 
     * @param translations
     *            The translations intended for the new word (<b>may not be <code>null</code></b>).
     */
    public WordBuilderImplementation(final Map<Locale, Translation> translations) {
        this.translations = ImmutableMap.<Locale, Translation> builder();

        assert this.translations != null : "Translations may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public Word get() {
        Preconditions.checkState(translations != null);

        return new WordImplementation(translations.build());
    }

    @Override
    public WordBuilder translation(final Locale locale, final Translation translation) {
        Preconditions.checkNotNull(locale);
        Preconditions.checkNotNull(translation);

        if (!translations.build().values().contains(translation)) {
            translations.put(locale, translation);

            return this;
        }

        throw new IllegalArgumentException("Can't add duplicate translations"); //$NON-NLS-1$
    }

    @Override
    public WordBuilder translations(final Map<Locale, Translation> trans) {
        translations.putAll(trans);

        // FIXME: Check for duplicate entries

        return this;
    }

}
