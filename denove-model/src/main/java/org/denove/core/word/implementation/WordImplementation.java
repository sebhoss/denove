package org.denove.core.word.implementation;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.denove.core.word.Word;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * Implementation of the {@link Word} interface.
 */
public final class WordImplementation implements Word {

    private final ImmutableMap<Locale, Translation> translations;

    /**
     * Constructor for a new Word implementation.
     * 
     * @param translations
     *            The translations enclosed by this word (<b>may not be <code>null</code></b>).
     */
    public WordImplementation(final ImmutableMap<Locale, Translation> translations) {
        this.translations = Preconditions.checkNotNull(translations);
    }

    @Override
    public Set<Locale> getAvailableLanguages() {
        return ImmutableSet.copyOf(translations.keySet());
    }

    @Override
    public int compareTo(final Word obj) {
        int result = 0;

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
        return translations;
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
