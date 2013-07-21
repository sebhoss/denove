package com.github.sebhoss.denove.model.translation.implementation;

import org.joda.time.DateTime;

import com.github.sebhoss.denove.model.example.Example;
import com.github.sebhoss.denove.model.localizedtext.LocalizedText;
import com.github.sebhoss.denove.model.translation.Translation;
import com.github.sebhoss.denove.model.translation.TranslationBuilder;
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
        Preconditions.checkState(localizedText != null);
        Preconditions.checkState(example != null);
        Preconditions.checkState(creationDate != null);
        Preconditions.checkState(lastQuestioned != null);
        Preconditions.checkState(score >= 0D);
        Preconditions.checkState(tryCount >= 0);
        Preconditions.checkState(missCount >= 0);

        return new TranslationImplementation(localizedText, example, score, tryCount, missCount, creationDate,
                lastQuestioned);
    }

    @Override
    public TranslationBuilder text(final LocalizedText text) {
        localizedText = Preconditions.checkNotNull(text);

        return this;
    }

    @Override
    public TranslationBuilder example(final Example newExample) {
        example = Preconditions.checkNotNull(newExample);

        return this;
    }

    @Override
    public TranslationBuilder missCount(final int misses) {
        Preconditions.checkArgument(misses >= 0);

        missCount = misses;

        return this;
    }

    @Override
    public TranslationBuilder score(final double currentScore) {
        Preconditions.checkArgument(currentScore >= 0);

        score = currentScore;

        return this;
    }

    @Override
    public TranslationBuilder tryCount(final int tries) {
        Preconditions.checkArgument(tries >= 0);

        tryCount = tries;

        return this;
    }

    @Override
    public TranslationBuilder creationDate(final DateTime created) {
        creationDate = created;

        return this;
    }

    @Override
    public TranslationBuilder lastQuestionedDate(final DateTime questioned) {
        lastQuestioned = questioned;

        return this;
    }

}
