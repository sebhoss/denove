/* Project: core
 * Package: org.denove.core.example
 * File   : ExampleTest.java
 * Created: Feb 2, 2010 - 12:03:49 PM
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
 * DOC: Write documentation for type 'ExampleTest'!
 *
 * @author  Sebastian Hoß (mail@shoss.de)
 * @version 1.0.0
 * @see     Example
 * @since   1.0.0
 */
public final class ExampleTest {

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // *                                              TESTS                                              *
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

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

} // End class ExampleTest
