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

    private final Builder<Locale, Translation> translationBuilder;

    /**
     * Constructor for a new {@link WordBuilderImplementation}.
     */
    public WordBuilderImplementation() {
        translationBuilder = ImmutableMap.<Locale, Translation> builder();
    }

    @Override
    public Word get() {
        Preconditions.checkState(translationBuilder != null);
        final ImmutableMap<Locale, Translation> translations = translationBuilder.build();
        Preconditions.checkState(translations.size() > 1);

        return new WordImplementation(translations);
    }

    @Override
    public WordBuilder translation(final Locale locale, final Translation translation) {
        Preconditions.checkNotNull(locale);
        Preconditions.checkNotNull(translation);
        translationBuilder.put(locale, translation);

        return this;
    }

    @Override
    public WordBuilder translations(final Map<Locale, Translation> translationsToAdd) {
        Preconditions.checkNotNull(translationsToAdd);
        translationBuilder.putAll(translationsToAdd);

        return this;
    }

}
