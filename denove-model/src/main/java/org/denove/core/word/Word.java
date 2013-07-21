package org.denove.core.word;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.joda.time.DateTime;

/**
 * Holds a single word with as much {@linkplain Translation translations} as one may want.
 * 
 * @see Translation
 */
public interface Word extends Comparable<Word> {

    /**
     * Gets an immutable set of available {@linkplain Locale locales} in this word.
     * 
     * @return A set of all available locales.
     */
    Set<Locale> getAvailableLanguages();

    /**
     * Gets the {@linkplain Translation translation} of this word in a given {@linkplain Locale locale}.
     * 
     * @param locale
     *            The wanted locale (<b>may not be <code>null</code></b>).
     * @return The translation for that locale.
     */
    Translation getTranslation(Locale locale);

    /**
     * Gets the localized text for this word in a given locale.
     * 
     * @param locale
     *            The language to use (<b>may not be <code>null</code></b>).
     * @return The localized text of this word in the given locale.
     */
    LocalizedText getText(Locale locale);

    /**
     * Gets the localized example sentence for this word in a given locale.
     * 
     * @param locale
     *            The language to use (<b>may not be <code>null</code></b>).
     * @return The example for this word in the given locale.
     */
    Example getExample(Locale locale);

    /**
     * Returns an immutable map of the available {@linkplain Translation translations} for this word.
     * 
     * @return All translations inside this word.
     */
    Map<Locale, Translation> getTranslations();

    /**
     * Returns the date this word was created. More strictly speaking: It returns the earliest date one of its enclosed
     * {@linkplain Translation translations} was created.
     * 
     * @return The date this word was created on.
     */
    DateTime getCreated();

    /**
     * Returns the date this word was questioned for the last time. More strictly speaking: It returns the date one of
     * its enclosed {@linkplain Translation translations} was questioned for the last time.
     * 
     * @return The date this word was questioned for the last time.
     */
    DateTime getLastQuestioned();

}
