package org.denove.core.example;

import org.denove.core.example.implementation.ExampleBuilderImplementation;

/**
 * DOC: Write documentation for type 'Examples'!
 */
public final class Examples {

    /**
     * DOC: Write documentation for method prepareExample!
     * 
     * @return A new ExampleBuilder to build a new example.
     */
    public static ExampleBuilder prepareExample() {
        return new ExampleBuilderImplementation();
    }

    private Examples() {
        // Do nothing..
    }

}
