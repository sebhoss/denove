package org.denove.core.localizedtext.implementation;

import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.localizedtext.LocalizedTextBuilder;

/**
 * DOC: Write documentation for type 'LocalizedTextBuilderImplementation'!
 */
public final class LocalizedTextBuilderImplementation implements LocalizedTextBuilder {

    private String localizedText;

    private String phoneticSpelling;

    @Override
    public LocalizedText get() {
        checkState(this.localizedText != null);
        checkState(this.phoneticSpelling != null);

        return new LocalizedTextImplementation(this.localizedText, this.phoneticSpelling);
    }

    @Override
    public LocalizedTextBuilder text(final String text) {
        this.localizedText = checkNotNull(text);

        return this;
    }

    @Override
    public LocalizedTextBuilder phoneticSpelling(final String spelling) {
        this.phoneticSpelling = checkNotNull(spelling);

        return this;
    }

}
