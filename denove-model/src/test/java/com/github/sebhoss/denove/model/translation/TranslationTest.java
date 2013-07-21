package com.github.sebhoss.denove.model.translation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.github.sebhoss.denove.model.example.Example;
import com.github.sebhoss.denove.model.localizedtext.LocalizedText;

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
        creationDate = DateTime.now();
        translation = Translations.prepareTranslation().creationDate(creationDate).text(mock(LocalizedText.class))
                .lastQuestionedDate(creationDate).example(mock(Example.class)).get();
    }

    /**
     * Ensures that the {@link Translation#getScore() getScore()} method returns the current score of a given
     * translation.
     */
    @Test
    public void testGetScore() {
        assertThat(Double.valueOf(translation.getScore()), is(equalTo(Double.valueOf(0D))));
    }

    /**
     * Ensures that the {@link Translation#getTryCount() getTryCount()} method reports the current try count of a given
     * translation.
     */
    @Test
    public void testTryCount() {
        assertThat(Integer.valueOf(translation.getTryCount()), is(equalTo(Integer.valueOf(0))));
    }

    /**
     * Ensures that the {@link Translation#getMissCount() getMissCount} method reports the current miss count of a given
     * translation.
     */
    @Test
    public void testMissCount() {
        assertThat(Integer.valueOf(translation.getMissCount()), is(equalTo(Integer.valueOf(0))));
    }

    /**
     * Ensures that the {@link Translation#getCreationDate() getCreationDate()} method reports the actual creation date
     * of a given translation.
     */
    @Test
    public void testGetCreationDate() {
        assertThat(creationDate, equalTo(translation.getCreationDate()));
    }

    /**
     * Ensures that the {@link Translation#getLastQuestionedDate() getLastQuestionedDate()} method reports the actual
     * creation date of a given translation.
     */
    @Test
    public void testGetLastQuestionedDate() {
        assertThat(creationDate, equalTo(translation.getLastQuestionedDate()));
    }

}
