package org.denove.core.word;

import java.util.Locale;
import java.util.Map;

import org.denove.core.translation.Translation;

/**
 * A WordBuilder is used to construct {@link Word} objects.
 * 
 * @see Word
 */
public interface WordBuilder extends Supplier<Word> {

    /**
     * <p>
     * Adds a single {@linkplain Translation translation} to the new {@linkplain Word word}.
     * </p>
     * 
     * <p>
     * Does not accept duplicate translations.
     * </p>
     * 
     * @param locale
     *            The locale of the translation to add (<b>may not be <code>null</code></b>).
     * @param translation
     *            The translation to add (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    WordBuilder translation(Locale locale, Translation translation);

    /**
     * <p>
     * Adds a map of {@linkplain Translation translations} to the new {@linkplain Word word}.
     * </p>
     * 
     * <p>
     * Does not accept duplicate translations.
     * </p>
     * 
     * @param translations
     *            The translations to add (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    WordBuilder translations(Map<Locale, Translation> translations);

    /**
     * Sets the {@link GrammarType grammar type} of the new {@linkplain Word word}.
     * 
     * @param type
     *            The grammar type of the new word (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    WordBuilder grammarType(GrammarType type);

}
