package com.github.sebhoss.denove.model.localizedtext;

import com.github.sebhoss.denove.model.localizedtext.implementation.LocalizedTextBuilderImplementation;

/**
 * DOC: Write documentation for type 'LocalizedTexts'!
 * 
 * @see LocalizedText
 */
public final class LocalizedTexts {

    /**
     * Prepares a new {@link LocalizedText localized test} by creating a {@link LocalizedTextBuilder localized text
     * builder}.
     * 
     * @return A new LocalizedTextBuilder to build a new localized text.
     */
    public static LocalizedTextBuilder prepareLocalizedText() {
        return new LocalizedTextBuilderImplementation();
    }

    private LocalizedTexts() {
        // Do nothing..
    }

}
