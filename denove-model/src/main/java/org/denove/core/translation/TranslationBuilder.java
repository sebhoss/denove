package org.denove.core.translation;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.joda.time.DateTime;

import com.google.common.base.Supplier;

/**
 * A TranslationBuilder is used to construct {@link Translation} objects.
 * 
 * @see Translation
 */
public interface TranslationBuilder extends Supplier<Translation> {

    /**
     * Sets the text of the new {@linkplain Translation translation}.
     * 
     * @param text
     *            The text to set (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    TranslationBuilder text(LocalizedText text);

    /**
     * Sets the example of the new {@linkplain Translation translation}.
     * 
     * @param example
     *            The example to set (<b>may not be <code>null</code></b>).
     * @return The current builder
     */
    TranslationBuilder example(Example example);

    /**
     * Sets the score of the new {@linkplain Translation translation}.
     * 
     * @param score
     *            The current score for the new translation (<b>may not be negative</b>).
     * @return The current builder.
     */
    TranslationBuilder score(double score);

    /**
     * Sets the try count of the new {@linkplain Translation translation}.
     * 
     * @param tryCount
     *            The current try count for the new translation (<b>may not be negative</b>).
     * @return The current builder.
     */
    TranslationBuilder tryCount(int tryCount);

    /**
     * Sets the miss count of the new {@linkplain Translation translation}.
     * 
     * @param missCount
     *            The current miss count for the new translation (<b>may not be negative</b>).
     * @return The current builder.
     */
    TranslationBuilder missCount(int missCount);

    /**
     * Sets the creation date of the new {@linkplain Translation translation}.
     * 
     * @param creationDate
     *            The date to set (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    TranslationBuilder creationDate(DateTime creationDate);

    /**
     * Sets the date the new {@linkplain Translation translation} was questioned for the last time.
     * 
     * @param lastQuestioned
     *            The date to set (<b>may not be <code>null</code></b>).
     * @return The current builder.
     */
    TranslationBuilder lastQuestionedDate(DateTime lastQuestioned);

}
