package com.github.sebhoss.denove.model.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * DOC: Write documentation for type 'ExampleTest'!
 * 
 * @see Example
 */
@SuppressWarnings("static-method")
public final class ExampleTest {

    /**
     * Test method for {@link com.github.sebhoss.denove.model.example.Example#getSentence()}.
     */
    @Test
    public void testGetSentence() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "goes"; //$NON-NLS-1$
        final Example example = Examples.prepareExample().sentence(sentence).correctForm(form).get();

        Assert.assertEquals(example.getSentence(), sentence);
    }

    /**
     * Test method for {@link com.github.sebhoss.denove.model.example.Example#getCorrectForm()}.
     */
    @Test
    public void testGetCorrectForm() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "goes"; //$NON-NLS-1$
        final Example example = Examples.prepareExample().correctForm(form).sentence(sentence).get();

        Assert.assertEquals(example.getCorrectForm(), form);
    }

}
