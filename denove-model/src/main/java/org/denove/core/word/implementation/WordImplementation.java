package org.denove.core.word.implementation;

import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.denove.core.word.GrammarType;
import org.denove.core.word.Word;

/**
 * Implementation of the {@link Word} interface.
 */
public final class WordImplementation implements Word {

    private final Map<Locale, Translation> translations;

    private final GrammarType              grammarType;

    /**
     * Constructor for a new Word implementation.
     * 
     * @param type
     *            The grammar type of this word (<b>may not be <code>null</code></b>).
     * @param translations
     *            The translations enclosed by this word (<b>may not be <code>null</code></b>).
     */
    public WordImplementation(final GrammarType type, final Map<Locale, Translation> translations) {
        this.grammarType = checkNotNull(type);
        this.translations = checkNotNull(translations);
    }

    @Override
    public Set<Locale> getAvailableLanguages() {
        return ImmutableSet.copyOf(this.translations.keySet());
    }

    @Override
    public int compareTo(final Word obj) {
        int result = 0;

        result += this.grammarType.compareTo(obj.getGrammarType());

        for (final Locale locale : this.translations.keySet()) {
            if (obj.getTranslations().containsKey(locale)) {
                result += this.getTranslation(locale).compareTo(obj.getTranslation(locale));
            }
        }

        return result;
    }

    @Override
    public LocalizedText getText(final Locale locale) {
        return this.translations.get(locale).getLocalizedText();
    }

    @Override
    public Example getExample(final Locale locale) {
        return this.translations.get(locale).getExample();
    }

    @Override
    public Map<Locale, Translation> getTranslations() {
        return Collections.unmodifiableMap(this.translations);
    }

    @Override
    public GrammarType getGrammarType() {
        return this.grammarType;
    }

    @Override
    public DateTime getCreated() {
        Date earliest = new Date();

        for (final Translation translation : this.translations.values()) {
            if (translation.getCreationDate().before(earliest)) {
                earliest = translation.getCreationDate();
            }
        }

        return new Date(earliest.getTime());
    }

    @Override
    public DateTime getLastQuestioned() {
        Date latest = new Date();

        for (final Translation translation : this.translations.values()) {
            if (translation.getLastQuestionedDate().before(latest)) {
                latest = translation.getLastQuestionedDate();
            }
        }

        return new Date(latest.getTime());
    }

    @Override
    public Translation getTranslation(final Locale locale) {
        return this.translations.get(locale);
    }

}
