package org.denove.core.translation.implementation;

import java.util.Date;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;

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
            final int tryCount, final int missCount, final Date creationDate, final Date lastQuestionedDate) {
        Preconditions.checkArgument(score >= 0);
        Preconditions.checkArgument(tryCount >= 0);
        Preconditions.checkArgument(missCount >= 0);

        this.score = score;
        this.tryCount = tryCount;
        this.missCount = missCount;

        this.localizedText = Preconditions.checkNotNull(text);
        this.example = Preconditions.checkNotNull(example);
        this.creationDate = new Date(Preconditions.checkNotNull(creationDate).getTime());
        this.lastQuestioned = new Date(Preconditions.checkNotNull(lastQuestionedDate).getTime());
    }

    @Override
    public boolean hit(final double newScore) {
        Preconditions.checkArgument(newScore >= 0);

        this.score = newScore;
        this.lastQuestioned = new Date();

        this.tryCount++;

        return this.score == newScore;
    }

    @Override
    public boolean miss(final double newScore) {
        Preconditions.checkArgument(newScore >= 0);

        this.score = newScore;
        this.lastQuestioned = new Date();

        this.tryCount++;
        this.missCount++;

        return this.score == newScore;
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
        return new Date(this.creationDate.getTime());
    }

    @Override
    public DateTime getLastQuestionedDate() {
        return new Date(this.lastQuestioned.getTime());
    }

    @Override
    public Example getExample() {
        return this.example;
    }

}
