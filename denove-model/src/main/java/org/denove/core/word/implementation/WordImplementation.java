package org.denove.core.word.implementation;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.denove.core.word.GrammarType;
import org.denove.core.word.Word;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

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
        grammarType = Preconditions.checkNotNull(type);
        this.translations = Preconditions.checkNotNull(translations);
    }

    @Override
    public Set<Locale> getAvailableLanguages() {
        return ImmutableSet.copyOf(translations.keySet());
    }

    @Override
    public int compareTo(final Word obj) {
        int result = 0;

        result += grammarType.compareTo(obj.getGrammarType());

        for (final Locale locale : translations.keySet()) {
            if (obj.getTranslations().containsKey(locale)) {
                result += getTranslation(locale).compareTo(obj.getTranslation(locale));
            }
        }

        return result;
    }

    @Override
    public LocalizedText getText(final Locale locale) {
        return translations.get(locale).getLocalizedText();
    }

    @Override
    public Example getExample(final Locale locale) {
        return translations.get(locale).getExample();
    }

    @Override
    public Map<Locale, Translation> getTranslations() {
        return Collections.unmodifiableMap(translations);
    }

    @Override
    public GrammarType getGrammarType() {
        return grammarType;
    }

    @Override
    public DateTime getCreated() {
        DateTime earliest = null;

        for (final Translation translation : translations.values()) {
            if (earliest == null || translation.getCreationDate().isBefore(earliest)) {
                earliest = translation.getCreationDate();
            }
        }

        return earliest;
    }

    @Override
    public DateTime getLastQuestioned() {
        DateTime latest = null;

        for (final Translation translation : translations.values()) {
            if (latest == null || translation.getLastQuestionedDate().isBefore(latest)) {
                latest = translation.getLastQuestionedDate();
            }
        }

        return latest;
    }

    @Override
    public Translation getTranslation(final Locale locale) {
        return translations.get(locale);
    }

}
