package org.denove.core.example;


/**
 * DOC: Write documentation for type 'ExampleTest'!
 * 
 * @see Example
 */
public final class ExampleTest {

    /**
     * Test method for {@link org.denove.core.example.Example#getSentence()}.
     */
    @Test
    public void testGetSentence() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "goes"; //$NON-NLS-1$
        final Example example = Examples.prepareExample().sentence(sentence).correctForm(form).get();

        assertEquals(example.getSentence(), sentence);
    }

    /**
     * Test method for {@link org.denove.core.example.Example#getCorrectForm()}.
     */
    @Test
    public void testGetCorrectForm() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "goes"; //$NON-NLS-1$
        final Example example = Examples.prepareExample().correctForm(form).sentence(sentence).get();

        assertEquals(example.getCorrectForm(), form);
    }

}
