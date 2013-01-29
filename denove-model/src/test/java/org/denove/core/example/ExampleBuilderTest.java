/* Project: core
 * Package: org.denove.core.example
 * File   : ExampleBuilderTest.java
 * Created: Feb 2, 2010 - 11:48:15 AM
 *
 *
 * Copyright 2010 Sebastian Hoß
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.denove.core.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * DOC: Write documentation for type 'ExampleBuilderTest'!
 *
 * @author  Sebastian Hoß (mail@shoss.de)
 * @version 1.0.0
 * @see     ExampleBuilder
 * @since   1.0.0
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
        assertEquals(example.getSentence(), sentence);
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
        assertEquals(example.getCorrectForm(), form);
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
     * Ensures that the method does not accept arbitrary forms as valid input. So it ensures
     * that the given form matches the previously given sentence.
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
     * Ensures that the method does not accept arbitrary sentences as valid input. So it ensures
     * that the given sentence matches the previously given form.
     * </p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSentenceMatchesForm() {
        final String sentence = "There he goes again"; //$NON-NLS-1$
        final String form = "went"; //$NON-NLS-1$

        Examples.prepareExample().correctForm(form).sentence(sentence);
    }

} // End class ExampleBuilderTest
