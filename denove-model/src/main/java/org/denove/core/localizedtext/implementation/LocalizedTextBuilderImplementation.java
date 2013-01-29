package org.denove.core.localizedtext.implementation;

import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.localizedtext.LocalizedTextBuilder;

import com.google.common.base.Preconditions;

/**
 * DOC: Write documentation for type 'LocalizedTextBuilderImplementation'!
 */
public final class LocalizedTextBuilderImplementation implements LocalizedTextBuilder {

    private String localizedText;

    private String phoneticSpelling;

    @Override
    public LocalizedText get() {
        Preconditions.checkState(this.localizedText != null);
        Preconditions.checkState(this.phoneticSpelling != null);

        return new LocalizedTextImplementation(this.localizedText, this.phoneticSpelling);
    }

    @Override
    public LocalizedTextBuilder text(final String text) {
        this.localizedText = Preconditions.checkNotNull(text);

        return this;
    }

    @Override
    public LocalizedTextBuilder phoneticSpelling(final String spelling) {
        this.phoneticSpelling = Preconditions.checkNotNull(spelling);

        return this;
    }

}
