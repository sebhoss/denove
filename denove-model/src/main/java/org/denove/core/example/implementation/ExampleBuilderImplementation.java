package org.denove.core.example.implementation;

import org.denove.core.example.Example;
import org.denove.core.example.ExampleBuilder;

import com.google.common.base.Preconditions;

/**
 * Implementation of the {@link ExampleBuilder} interface.
 */
public final class ExampleBuilderImplementation implements ExampleBuilder {

    private String sentence;

    private String correctForm;

    @Override
    public Example get() {
        Preconditions.checkState(this.sentence != null);
        Preconditions.checkState(this.correctForm != null);
        Preconditions.checkState(this.sentence.contains(this.correctForm));

        return new ExampleImplementation(this.sentence, this.correctForm);
    }

    @Override
    public ExampleBuilder correctForm(final String form) {
        Preconditions.checkNotNull(form);

        // Check if sentence is already set and if it contains the form to set
        if (this.sentence != null && !this.sentence.contains(form)) {
            throw new IllegalArgumentException("Form does not match to sentence"); //$NON-NLS-1$
        }

        this.correctForm = form;

        return this;
    }

    @Override
    public ExampleBuilder sentence(final String exampleSentence) {
        Preconditions.checkNotNull(exampleSentence);

        if (this.correctForm != null && !exampleSentence.contains(this.correctForm)) {
            throw new IllegalArgumentException("Sentence does not match form"); //$NON-NLS-1$
        }

        this.sentence = exampleSentence;

        return this;
    }

}
