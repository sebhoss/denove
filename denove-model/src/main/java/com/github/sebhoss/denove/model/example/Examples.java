package com.github.sebhoss.denove.model.example;

import com.github.sebhoss.denove.model.example.implementation.ExampleBuilderImplementation;

/**
 * DOC: Write documentation for type 'Examples'!
 */
public final class Examples {

    /**
     * Prepares a new {@link Example example} by creating a {@link ExampleBuilder example builder}.
     * 
     * @return A new ExampleBuilder to build a new example.
     */
    public static ExampleBuilder prepareExample() {
        return new ExampleBuilderImplementation();
    }

    /**
     * @return An empty example.
     */
    @SuppressWarnings("nls")
    public static Example emptyExample() {
        return new ExampleBuilderImplementation().sentence("").correctForm("").get();
    }

    private Examples() {
        // Do nothing..
    }

}
