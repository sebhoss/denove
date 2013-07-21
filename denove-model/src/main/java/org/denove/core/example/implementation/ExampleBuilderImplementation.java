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
        Preconditions.checkState(sentence != null);
        Preconditions.checkState(correctForm != null);
        Preconditions.checkState(sentence.contains(correctForm));

        return new ExampleImplementation(sentence, correctForm);
    }

    @Override
    public ExampleBuilder correctForm(final String form) {
        Preconditions.checkNotNull(form);

        // Check if sentence is already set and if it contains the form to set
        if (sentence != null && !sentence.contains(form)) {
            throw new IllegalArgumentException("Form does not match to sentence"); //$NON-NLS-1$
        }

        correctForm = form;

        return this;
    }

    @Override
    public ExampleBuilder sentence(final String exampleSentence) {
        Preconditions.checkNotNull(exampleSentence);

        if (correctForm != null && !exampleSentence.contains(correctForm)) {
            throw new IllegalArgumentException("Sentence does not match form"); //$NON-NLS-1$
        }

        sentence = exampleSentence;

        return this;
    }

}
