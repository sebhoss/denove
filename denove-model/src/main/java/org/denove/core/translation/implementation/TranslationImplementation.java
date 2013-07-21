package org.denove.core.translation.implementation;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;

/**
 * Implementation of the {@link Translation} interface.
 */
public final class TranslationImplementation implements Translation {

    private final DateTime      creationDate;

    private DateTime            lastQuestioned;

    private final LocalizedText localizedText;

    private final Example       example;

    private double              score;

    private int                 tryCount;

    private int                 missCount;

    /**
     * Creates a new translation.
     * 
     * @param text
     *            The localized text of the translation (<b>may not be <code>null</code></b>).
     * @param example
     *            The example for the translation (<b>may not be <code>null</code></b>).
     * @param score
     *            The initial score for the translation (<b>may not be negative</b>).
     * @param tryCount
     *            The initial try count for the translation (<b>may not be negative</b>).
     * @param missCount
     *            The initial miss count for the translation (<b>may not be negative</b>).
     * @param creationDate
     *            The creation date of the translation (<b>may not be <code>null</code></b>).
     * @param lastQuestionedDate
     *            The date the translation was questioned for the last time (<b>may not be <code>null</code></b>).
     */
    public TranslationImplementation(final LocalizedText text, final Example example, final double score,
            final int tryCount, final int missCount, final DateTime creationDate, final DateTime lastQuestionedDate) {
        Preconditions.checkArgument(score >= 0);
        Preconditions.checkArgument(tryCount >= 0);
        Preconditions.checkArgument(missCount >= 0);

        this.score = score;
        this.tryCount = tryCount;
        this.missCount = missCount;

        this.localizedText = Preconditions.checkNotNull(text);
        this.example = Preconditions.checkNotNull(example);
        this.creationDate = creationDate;
        this.lastQuestioned = lastQuestionedDate;
    }

    @Override
    public int compareTo(final Translation obj) {
        int result = 0;

        result += this.creationDate.compareTo(obj.getCreationDate());
        result += this.lastQuestioned.compareTo(obj.getLastQuestionedDate());
        result += this.localizedText.compareTo(obj.getLocalizedText());
        result += this.example.compareTo(obj.getExample());

        if (this.score > obj.getScore()) {
            result += 1;
        } else if (this.score < obj.getScore()) {
            result -= 1;
        }

        if (this.tryCount > obj.getTryCount()) {
            result += 1;
        } else if (this.tryCount < obj.getTryCount()) {
            result -= 1;
        }

        if (this.missCount > obj.getMissCount()) {
            result += 1;
        } else if (this.missCount < obj.getMissCount()) {
            result -= 1;
        }

        return result;
    }

    @Override
    public LocalizedText getLocalizedText() {
        return this.localizedText;
    }

    @Override
    public double getScore() {
        return this.score;
    }

    @Override
    public int getTryCount() {
        return this.tryCount;
    }

    @Override
    public int getMissCount() {
        return this.missCount;
    }

    @Override
    public DateTime getCreationDate() {
        return this.creationDate;
    }

    @Override
    public DateTime getLastQuestionedDate() {
        return this.lastQuestioned;
    }

    @Override
    public Example getExample() {
        return this.example;
    }

}
