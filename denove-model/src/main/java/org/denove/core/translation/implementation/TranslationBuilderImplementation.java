package org.denove.core.translation.implementation;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.denove.core.translation.TranslationBuilder;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;

/**
 * Implementation of the {@link TranslationBuilder} interface.
 */
public final class TranslationBuilderImplementation implements TranslationBuilder {

    private LocalizedText localizedText;

    private DateTime      creationDate;

    private DateTime      lastQuestioned;

    private Example       example;

    private double        score;

    private int           tryCount;

    private int           missCount;

    @Override
    public Translation get() {
        Preconditions.checkState(this.localizedText != null);
        Preconditions.checkState(this.example != null);
        Preconditions.checkState(this.creationDate != null);
        Preconditions.checkState(this.lastQuestioned != null);
        Preconditions.checkState(this.score >= 0D);
        Preconditions.checkState(this.tryCount >= 0);
        Preconditions.checkState(this.missCount >= 0);

        return new TranslationImplementation(this.localizedText, this.example, this.score, this.tryCount,
                this.missCount, this.creationDate, this.lastQuestioned);
    }

    @Override
    public TranslationBuilder text(final LocalizedText text) {
        this.localizedText = Preconditions.checkNotNull(text);

        return this;
    }

    @Override
    public TranslationBuilder example(final Example newExample) {
        this.example = Preconditions.checkNotNull(newExample);

        return this;
    }

    @Override
    public TranslationBuilder missCount(final int misses) {
        Preconditions.checkArgument(misses >= 0);

        this.missCount = misses;

        return this;
    }

    @Override
    public TranslationBuilder score(final double currentScore) {
        Preconditions.checkArgument(currentScore >= 0);

        this.score = currentScore;

        return this;
    }

    @Override
    public TranslationBuilder tryCount(final int tries) {
        Preconditions.checkArgument(tries >= 0);

        this.tryCount = tries;

        return this;
    }

    @Override
    public TranslationBuilder creationDate(final DateTime created) {
        this.creationDate = created;

        return this;
    }

    @Override
    public TranslationBuilder lastQuestionedDate(final DateTime questioned) {
        this.lastQuestioned = questioned;

        return this;
    }

}
