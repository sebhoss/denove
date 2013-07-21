package com.github.sebhoss.denove.model.localizedtext;

import com.google.common.base.Supplier;

/**
 * DOC: Write documentation for type 'LocalizedTextBuilder'!
 * 
 * @see LocalizedText
 */
public interface LocalizedTextBuilder extends Supplier<LocalizedText> {

    /**
     * DOC: Write documentation for method text!
     * 
     * @param text
     *            The localized text itself (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    LocalizedTextBuilder text(String text);

    /**
     * DOC: Write documentation for method phoneticSpelling!
     * 
     * @param spelling
     *            The correct phonetic spelling of the localized text (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    LocalizedTextBuilder phoneticSpelling(String spelling);

}
