package org.denove.core.localizedtext.implementation;

import org.denove.core.localizedtext.LocalizedText;

import com.google.common.base.Preconditions;

/**
 * DOC: Write documentation for type 'LocalizedTextImplementation'!
 */
public final class LocalizedTextImplementation implements LocalizedText {

    private final String localizedText;

    private final String phoneticSpelling;

    /**
     * DOC: Write documentation for the LocalizedTextImplementation constructor!
     * 
     * @param text
     *            The localized text itself (<b>may not be <code>null</code></b>).
     * @param spelling
     *            The correct phonetic spelling (<b>may not be <code>null</code></b>).
     */
    public LocalizedTextImplementation(final String text, final String spelling) {
        this.localizedText = Preconditions.checkNotNull(text);
        this.phoneticSpelling = Preconditions.checkNotNull(spelling);
    }

    @Override
    public int compareTo(final LocalizedText obj) {
        return this.localizedText.compareTo(obj.getText()) + this.phoneticSpelling.compareTo(obj.getPhoneticSpelling());
    }

    @Override
    public String getText() {
        return this.localizedText;
    }

    @Override
    public String getPhoneticSpelling() {
        return this.phoneticSpelling;
    }

}
