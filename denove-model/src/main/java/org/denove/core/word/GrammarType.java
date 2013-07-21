package org.denove.core.word;

/**
 * <p>
 * A list of all available grammar types in the Denove package.
 * </p>
 * 
 * <p>
 * Can and should be used in conjunction with the {@link Word} type.
 * </p>
 * 
 * @see Word
 */
public enum GrammarType {

    /** Constant for an adjective. */
    ADJECTIVE,

    /** Constant for a noun. */
    NOUN,

    /** Constant for a verb. */
    VERB,

    /** Constant for an adverb. */
    ADVERB,

    /** Constant for an interjection. */
    INTERJECTION,

    /** Constant for an unknown grammar type. */
    UNKNOWN;

}
