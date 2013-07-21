package com.github.sebhoss.denove.model.localizedtext;

import com.github.sebhoss.denove.model.localizedtext.implementation.LocalizedTextBuilderImplementation;

/**
 * DOC: Write documentation for type 'LocalizedTexts'!
 * 
 * @see LocalizedText
 */
public final class LocalizedTexts {

    /**
     * DOC: Write documentation for method prepareLocalizedText!
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
