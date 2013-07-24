package com.github.sebhoss.denove.io.kvtml;

import com.github.sebhoss.denove.io.common.Element;

/**
 * Enumeration of elements found inside a KVTML version 1 file.
 * 
 * @see KVTMLReader
 */
@SuppressWarnings("nls")
public enum KVTMLElements implements Element {

    /** An entry is usually inside a lesson and contains the original word and its translation. */
    ENTRY("e"),

    /** The original word of an entry. */
    ORIGINAL("o"),

    /** The translation of an entry. */
    TRANSLATION("t"),

    /** The pronunciation of an original word or a translation. */
    PRONUNCIATION("p");

    private final String identifier;

    private KVTMLElements(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

}
