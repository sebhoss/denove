package org.denove.core.example.implementation;

import org.denove.core.example.Example;

/**
 * Implementation of the {@link Example} interface.
 */
public final class ExampleImplementation implements Example {

    /** Holds the example sentence. */
    private final String sentence;

    /** Holds the correct form of a word inside the example sentence. */
    private final String correctForm;

    /**
     * Creates a new example.
     * 
     * @param sentence
     *            The sentence to use (<b>may not be <code>null</code></b>).
     * @param correctForm
     *            The correct form in this sentence (<b>may not be <code>null</code></b>).
     */
    public ExampleImplementation(final String sentence, final String correctForm) {
        this.sentence = checkNotNull(sentence);
        this.correctForm = checkNotNull(correctForm);

        assert this.sentence != null : "Sentence may not be 'null'"; //$NON-NLS-1$
        assert this.correctForm != null : "Correct form may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public int compareTo(final Example obj) {
        return this.sentence.compareTo(obj.getSentence()) + this.correctForm.compareTo(obj.getCorrectForm());
    }

    @Override
    public String getCorrectForm() {
        return this.correctForm;
    }

    @Override
    public String getSentence() {
        return this.sentence;
    }

}
