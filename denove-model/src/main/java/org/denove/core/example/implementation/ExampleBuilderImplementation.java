package org.denove.core.example.implementation;

import org.denove.core.example.Example;
import org.denove.core.example.ExampleBuilder;

/**
 * Implementation of the {@link ExampleBuilder} interface.
 */
public final class ExampleBuilderImplementation implements ExampleBuilder {

    /** Holds the example sentence for the new example. */
    private String sentence;

    /** Holds the correct form of a word inside the example sentence for the new example. */
    private String correctForm;

    @Override
    public Example get() {
        checkState(this.sentence != null);
        checkState(this.correctForm != null);
        checkState(this.sentence.contains(this.correctForm));

        return new ExampleImplementation(this.sentence, this.correctForm);
    }

    @Override
    public ExampleBuilder correctForm(final String form) {
        checkNotNull(form);

        // Check if sentence is already set and if it contains the form to set
        if (this.sentence != null && !this.sentence.contains(form)) {
            throw new IllegalArgumentException("Form does not match to sentence"); //$NON-NLS-1$
        }

        this.correctForm = form;

        return this;
    }

    @Override
    public ExampleBuilder sentence(final String exampleSentence) {
        checkNotNull(exampleSentence);

        if (this.correctForm != null && !exampleSentence.contains(this.correctForm)) {
            throw new IllegalArgumentException("Sentence does not match form"); //$NON-NLS-1$
        }

        this.sentence = exampleSentence;

        return this;
    }

}
