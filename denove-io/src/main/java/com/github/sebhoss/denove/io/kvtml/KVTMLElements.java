package com.github.sebhoss.denove.io.kvtml;

import com.github.sebhoss.denove.io.common.XMLElement;

/**
 * Enumeration of elements found inside a KVTML version 1 file.
 * 
 * @see KVTMLReader
 */
@SuppressWarnings("nls")
public enum KVTMLElements implements XMLElement {

    /** An entry is usually inside a lesson and contains the original word and its translation. */
    ENTRY("e"),

    /** The original word of an entry. */
    ORIGINAL("o"),

    /** The translation of an entry. */
    TRANSLATION("t"),

    /** The pronunciation of an original word or a translation. */
    PRONUNCIATION("p"),

    /** The language code of an original word or a translation. */
    LANGUAGE("l"),

    /** The example of an original word or a translation. */
    EXAMPLE("x"),

    /** The usage label of an original word or a translation. Used together with an example. */
    USAGE_LABEL("u"),

    /** The last questioned date of a translation in the form 'from;to'. */
    DATE("d");

    private final String identifier;

    private KVTMLElements(final String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

}
