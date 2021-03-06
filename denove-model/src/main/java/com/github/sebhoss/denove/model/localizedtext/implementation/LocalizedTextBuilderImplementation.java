package com.github.sebhoss.denove.model.localizedtext.implementation;

import com.github.sebhoss.denove.model.localizedtext.LocalizedText;
import com.github.sebhoss.denove.model.localizedtext.LocalizedTextBuilder;
import com.google.common.base.Preconditions;

/**
 * DOC: Write documentation for type 'LocalizedTextBuilderImplementation'!
 */
public final class LocalizedTextBuilderImplementation implements LocalizedTextBuilder {

    private String localizedText;

    private String phoneticSpelling;

    @Override
    public LocalizedText get() {
        Preconditions.checkState(localizedText != null);
        Preconditions.checkState(phoneticSpelling != null);

        return new LocalizedTextImplementation(localizedText, phoneticSpelling);
    }

    @Override
    public LocalizedTextBuilder text(final String text) {
        localizedText = Preconditions.checkNotNull(text);

        return this;
    }

    @Override
    public LocalizedTextBuilder phoneticSpelling(final String spelling) {
        phoneticSpelling = Preconditions.checkNotNull(spelling);

        return this;
    }

}
