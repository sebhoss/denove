package com.github.sebhoss.denove.model.example.implementation;

import com.github.sebhoss.denove.model.example.Example;
import com.google.common.base.Preconditions;

/**
 * Implementation of the {@link Example} interface.
 */
public final class ExampleImplementation implements Example {

    private final String sentence;

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
        this.sentence = Preconditions.checkNotNull(sentence);
        this.correctForm = Preconditions.checkNotNull(correctForm);

        assert this.sentence != null : "Sentence may not be 'null'"; //$NON-NLS-1$
        assert this.correctForm != null : "Correct form may not be 'null'"; //$NON-NLS-1$
    }

    @Override
    public int compareTo(final Example obj) {
        return sentence.compareTo(obj.getSentence()) + correctForm.compareTo(obj.getCorrectForm());
    }

    @Override
    public String getCorrectForm() {
        return correctForm;
    }

    @Override
    public String getSentence() {
        return sentence;
    }

}
