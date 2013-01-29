package org.denove.core.localizedtext;

/**
 * DOC: Write documentation for type 'LocalizedText'!
 */
public interface LocalizedText extends Comparable<LocalizedText> {

    /**
     * Gets the localized text.
     * 
     * @return The localized text.
     */
    String getText();

    /**
     * Gets the correct phonetic spelling of this {@linkplain LocalizedText localized text}.
     * 
     * @return The phonetic spelling of this localized text.
     */
    String getPhoneticSpelling();

}
