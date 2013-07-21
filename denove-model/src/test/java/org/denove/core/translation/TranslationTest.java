package org.denove.core.translation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link Translation} interface and its underlying implementation.
 */
public final class TranslationTest {

    private Translation translation;
    private DateTime    creationDate;

    /**
     * Prepares a single translation which should be used by all tests in this class.
     */
    @Before
    public void prepare() {
        this.creationDate = DateTime.now();
        this.translation = Translations.prepareTranslation().creationDate(this.creationDate)
                .text(mock(LocalizedText.class)).lastQuestionedDate(this.creationDate).example(mock(Example.class))
                .get();
    }

    /**
     * Ensures that the {@link Translation#getScore() getScore()} method returns the current score of a given
     * translation.
     */
    @Test
    public void testGetScore() {
        assertThat(Double.valueOf(this.translation.getScore()), is(equalTo(Double.valueOf(0D))));
    }

    /**
     * Ensures that the {@link Translation#getTryCount() getTryCount()} method reports the current try count of a given
     * translation.
     */
    @Test
    public void testTryCount() {
        assertThat(Integer.valueOf(this.translation.getTryCount()), is(equalTo(Integer.valueOf(0))));
    }

    /**
     * Ensures that the {@link Translation#getMissCount() getMissCount} method reports the current miss count of a given
     * translation.
     */
    @Test
    public void testMissCount() {
        assertThat(Integer.valueOf(this.translation.getMissCount()), is(equalTo(Integer.valueOf(0))));
    }

    /**
     * Ensures that the {@link Translation#getCreationDate() getCreationDate()} method reports the actual creation date
     * of a given translation.
     */
    @Test
    public void testGetCreationDate() {
    	assertThat(this.creationDate, equalTo(this.translation.getCreationDate()));
    }

    /**
     * Ensures that the {@link Translation#getLastQuestionedDate() getLastQuestionedDate()} method reports the actual
     * creation date of a given translation.
     */
    @Test
    public void testGetLastQuestionedDate() {
    	assertThat(this.creationDate, equalTo(this.translation.getLastQuestionedDate()));
    }

}
