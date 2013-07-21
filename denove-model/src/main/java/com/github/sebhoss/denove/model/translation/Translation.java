package com.github.sebhoss.denove.model.translation;

import org.joda.time.DateTime;

import com.github.sebhoss.denove.model.example.Example;
import com.github.sebhoss.denove.model.localizedtext.LocalizedText;

/**
 * <p>
 * A {@linkplain Translation translation} holds the actual locale-dependent text for a given word.
 * </p>
 * 
 * <p>
 * It also holds most attributes used for iterating and filtering such as:
 * <ul>
 * <li>The localized text</li>
 * <li>The correct phonetic spelling</li>
 * <li>An example</li>
 * <li>The current score</li>
 * <li>The current try count</li>
 * <li>The current miss count</li>
 * <li>The creation date</li>
 * <li>The date this translation was questioned for the last time</li>
 * </ul>
 * </p>
 */
public interface Translation extends Comparable<Translation> {

    /**
     * Gets the localized text of this {@linkplain Translation translation}.
     * 
     * @return The localized text of this translation.
     */
    LocalizedText getLocalizedText();

    /**
     * Gets the example for this {@linkplain Translation translation}.
     * 
     * @return The enclosed example for this translation.
     */
    Example getExample();

    /**
     * Gets the current score of this {@linkplain Translation translation}.
     * 
     * @return The current score.
     */
    double getScore();

    /**
     * Gets the current try count of this {@linkplain Translation translation}.
     * 
     * @return The current try count.
     */
    int getTryCount();

    /**
     * Gets the current miss count of this {@linkplain Translation translation}.
     * 
     * @return The current miss count.
     */
    int getMissCount();

    /**
     * Gets the creation date of this {@linkplain Translation translation}.
     * 
     * @return The creation date.
     */
    DateTime getCreationDate();

    /**
     * Gets the date this {@linkplain Translation translation} was questioned for the last time.
     * 
     * @return The date this translation was questioned the last time.
     */
    DateTime getLastQuestionedDate();

}
