package com.github.sebhoss.denove.model.example;

import com.google.common.base.Supplier;

/**
 * DOC: Write documentation for type 'ExampleBuilder'!
 */
public interface ExampleBuilder extends Supplier<Example> {

    /**
     * <p>
     * Sets the example sentence of the new {@link Example}.
     * </p>
     * 
     * <p>
     * If the given sentence does not contain the currently set correct form an IllegalArgumentException will be thrown.
     * </p>
     * 
     * @param sentence
     *            The sentence to set (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    ExampleBuilder sentence(String sentence);

    /**
     * <p>
     * Sets the grammatically correct form of the new {@link Example}.
     * </p>
     * 
     * <p>
     * If the given correct form can not be found inside the currently set example sentence an IllegalArgumentException
     * will be thrown.
     * </p>
     * 
     * @param form
     *            The form to set (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    ExampleBuilder correctForm(String form);

}
