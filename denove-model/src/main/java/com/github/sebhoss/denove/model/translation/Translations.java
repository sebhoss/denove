package com.github.sebhoss.denove.model.translation;

import com.github.sebhoss.denove.model.translation.implementation.TranslationBuilderImplementation;

/**
 * <p>
 * Translation facade which creates {@linkplain TranslationBuilder translation builders} for everyones use.
 * </p>
 * 
 * @see Translation
 */
public final class Translations {

    /**
     * <p>
     * Prepares a new {@linkplain Translation translation} by creating a {@linkplain TranslationBuilder translation
     * builder}.
     * </p>
     * 
     * @return A new TranslationBuilder to build a new translation.
     */
    public static TranslationBuilder prepareTranslation() {
        return new TranslationBuilderImplementation();
    }

    private Translations() {
        // Do nothing..
    }

}
