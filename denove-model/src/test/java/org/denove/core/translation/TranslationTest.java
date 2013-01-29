package org.denove.core.translation;

import java.util.Date;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;

/**
 * Test cases for the {@link Translation} interface and its underlying implementation.
 */
public final class TranslationTest {

    private Translation translation;
    private Date        creationDate;

    /**
     * Prepares a single translation which should be used by all tests in this class.
     */
    @Before
    public void prepare() {
        this.creationDate = new Date();
        this.translation = Translations.prepareTranslation().creationDate(this.creationDate)
                .text(mock(LocalizedText.class)).lastQuestionedDate(this.creationDate).example(mock(Example.class))
                .get();
    }

    /**
     * Test method for:
     * 
     * <ul>
     * <li>{@link Translation#getLocalizedText()}</li>
     * <li>{@link Translation#setText(LocalizedText)}.</li>
     * </ul>
     * 
     * Ensures that the text of a newly created translation is not <code>null</code> and that it can be overwritten with
     * some real value.
     */
    @Test
    public void testText() {
        // given
        final LocalizedText text = mock(LocalizedText.class);

        // when
        this.translation.setText(text);

        // then
        assertThat(this.translation.getLocalizedText(), is(text));
    }

    /**
     * Ensures that the {@link Translation#setText(LocalizedText) setText(LocalizedText)} method does not accept
     * <code>null</code> as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void testSetTextDoesNotAcceptNull() {
        this.translation.setText(null);
    }

    /**
     * <p>
     * Test method for {@link Translation#setExample(Example)}.
     * </p>
     * 
     * <p>
     * Ensures that the setExample method can overwrite both the example sentence and the correct form (if both match)
     * for a given translation.
     * </p>
     */
    @Test
    public void testExample() {
        // given
        final Example example = mock(Example.class);

        // when
        this.translation.setExample(example);

        // then
        assertThat(this.translation.getExample(), is(example));
    }

    /**
     * Ensures that the {@link Translation#setExample(Example) setExample(String, String)} method does not accept
     * <code>null</code> as valid input.
     */
    @Test(expected = NullPointerException.class)
    public void testSetExampleDoesNotAcceptNullSentence() {
        this.translation.setExample(null);
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
        assertEquals(this.creationDate, this.translation.getCreationDate());
    }

    /**
     * Ensures that the {@link Translation#getLastQuestionedDate() getLastQuestionedDate()} method reports the actual
     * creation date of a given translation.
     */
    @Test
    public void testGetLastQuestionedDate() {
        assertEquals(this.creationDate, this.translation.getLastQuestionedDate());
    }

    /**
     * <p>
     * Test method for {@link Translation#hit(double)}.
     * </p>
     * 
     * <p>
     * Ensures that you can't 'hit' with a negative value.
     * </p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testHitDoesNotAcceptNegatives() {
        this.translation.hit(-1);
    }

    /**
     * <p>
     * Test method for {@link Translation#hit(double)}.
     * </p>
     * 
     * <p>
     * Ensures that the given new score is actually set.
     * </p>
     */
    @Test
    public void testHit() {
        // given
        // this.translation

        // when
        this.translation.hit(2);

        // then
        assertThat(Double.valueOf(this.translation.getScore()), is(equalTo(Double.valueOf(2))));
    }

    /**
     * <p>
     * Test method for {@link Translation#miss(double)}.
     * </p>
     * 
     * <p>
     * Ensures that you can't 'miss' with a negative value.
     * </p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMissDoesNotAcceptNegatives() {
        this.translation.miss(-1);
    }

    /**
     * <p>
     * Test method for {@link Translation#miss(double)}.
     * </p>
     * 
     * <p>
     * Ensures that the given new score is actually set.
     * </p>
     */
    @Test
    public void testMiss() {
        // given
        // this.translation

        // when
        this.translation.miss(2);

        // then
        assertThat(Double.valueOf(this.translation.getScore()), is(equalTo(Double.valueOf(2))));
    }

}
