package org.denove.core.word.implementation;

import java.util.Locale;
import java.util.Map;

import org.denove.core.translation.Translation;
import org.denove.core.word.GrammarType;
import org.denove.core.word.Word;
import org.denove.core.word.WordBuilder;

import com.google.common.base.Preconditions;

/**
 * Implementation of the {@link WordBuilder} interface.
 */
public final class WordBuilderImplementation implements WordBuilder {

    private GrammarType                    grammarType;

    private final Map<Locale, Translation> translations;

    /**
     * Constructor for a new {@link WordBuilderImplementation}.
     * 
     * @param translations
     *            The translations intended for the new word (<b>may not be <code>null</code></b>).
     */
    public WordBuilderImplementation(final Map<Locale, Translation> translations) {
        this.translations = Preconditions.checkNotNull(translations);

        assert this.translations != null : "Translations may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public Word get() {
        Preconditions.checkState(grammarType != null);
        Preconditions.checkState(translations != null);

        return new WordImplementation(grammarType, translations);
    }

    @Override
    public WordBuilder translation(final Locale locale, final Translation translation) {
        Preconditions.checkNotNull(locale);
        Preconditions.checkNotNull(translation);

        if (!translations.values().contains(translation)) {
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

    @Override
    public WordBuilder grammarType(final GrammarType type) {
        grammarType = Preconditions.checkNotNull(type);

        return this;
    }

}
