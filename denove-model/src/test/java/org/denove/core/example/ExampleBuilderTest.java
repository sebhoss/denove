package org.denove.core.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * DOC: Write documentation for type 'ExampleBuilderTest'!
 * 
 * @see ExampleBuilder
 */
public final class ExampleBuilderTest {

    /**
     * Test method for {@link org.denove.core.example.ExampleBuilder#sentence(java.lang.String)}.
     */
    @Test
    public void testSentence() {
        // given
        final String sentence = "Hi there!"; //$NON-NLS-1$
        final String form = "there"; //$NON-NLS-1$

        // when
        final Example example = Examples.prepareExample().sentence(sentence).correctForm(form).get();

        // then
        Assert.assertEquals(example.getSentence(), sentence);
    }

    /**
     * <p>
     * Test method for {@link org.denove.core.example.ExampleBuilder#sentence(java.lang.String)}.
     * </p>
     * 
     * <p>
     * Ensures that the method does not accept <code>null</code> as valid input.
     * </p>
     */
    @Test(expected = NullPointerException.class)
    public void testSentenceDoesNotAcceptNull() {
        Examples.prepareExample().sentence(null);
    }

    /**
     * Test method for {@link org.denove.core.example.ExampleBuilder#correctForm(java.lang.String)}.
     */
    @Test
    public void testCorrectForm() {
        // given
        final String sentence = "Hi there!"; //$NON-NLS-1$
        final String form = "there"; //$NON-NLS-1$

        // when
        final Example example = Examples.prepareExample().sentence(sentence).correctForm(form).get();

        // then
        Assert.assertEquals(example.getCorrectForm(), form);
    }

    /**
     * <p>
     * Test method for {@link org.denove.core.example.ExampleBuilder#correctForm(java.lang.String)}.
     * </p>
     * 
     * <p>
     * Ensures that the method does not accept <code>null</code> as valid input.
     * </p>
     */
    @Test(expected = NullPointerException.class)
    public void testCorrectFormDoesNotAcceptNull() {
        Examples.prepareExample().correctForm(null);
    }

    /**
     * <p>
     * Test method for {@link org.denove.core.example.ExampleBuilder#correctForm(java.lang.String)}.
     * </p>
     * 
     * <p>
     * Ensures that the method does not accept arbitrary forms as valid input. So it ensures that the given form matches
     * the previously given sentence.
     * </p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCorrectFormMatchesSentence() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "went"; //$NON-NLS-1$

        Examples.prepareExample().sentence(sentence).correctForm(form);
    }

    /**
     * <p>
     * Test method for {@link org.denove.core.example.ExampleBuilder#sentence(java.lang.String)}.
     * </p>
     * 
     * <p>
     * Ensures that the method does not accept arbitrary sentences as valid input. So it ensures that the given sentence
     * matches the previously given form.
     * </p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSentenceMatchesForm() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "went"; //$NON-NLS-1$

        Examples.prepareExample().correctForm(form).sentence(sentence);
    }

}
