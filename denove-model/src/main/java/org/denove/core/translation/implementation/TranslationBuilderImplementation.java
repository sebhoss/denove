package org.denove.core.translation.implementation;

import java.util.Date;

import org.denove.core.example.Example;
import org.denove.core.localizedtext.LocalizedText;
import org.denove.core.translation.Translation;
import org.denove.core.translation.TranslationBuilder;

/**
 * Implementation of the {@link TranslationBuilder} interface.
 */
public final class TranslationBuilderImplementation implements TranslationBuilder {

    private LocalizedText localizedText;

    private Date          creationDate;

    private Date          lastQuestioned;

    private Example       example;

    private double        score;

    private int           tryCount;

    private int           missCount;

    @Override
    public Translation get() {
        checkState(this.localizedText != null);
        checkState(this.example != null);
        checkState(this.creationDate != null);
        checkState(this.lastQuestioned != null);
        checkState(this.score >= 0D);
        checkState(this.tryCount >= 0);
        checkState(this.missCount >= 0);

        return new TranslationImplementation(this.localizedText, this.example, this.score, this.tryCount,
                this.missCount, this.creationDate, this.lastQuestioned);
    }

    @Override
    public TranslationBuilder text(final LocalizedText text) {
        this.localizedText = checkNotNull(text);

        return this;
    }

    @Override
    public TranslationBuilder example(final Example newExample) {
        this.example = checkNotNull(newExample);

        return this;
    }

    @Override
    public TranslationBuilder missCount(final int misses) {
        checkArgument(misses >= 0);

        this.missCount = misses;

        return this;
    }

    @Override
    public TranslationBuilder score(final double currentScore) {
        checkArgument(currentScore >= 0);

        this.score = currentScore;

        return this;
    }

    @Override
    public TranslationBuilder tryCount(final int tries) {
        checkArgument(tries >= 0);

        this.tryCount = tries;

        return this;
    }

    @Override
    public TranslationBuilder creationDate(final Date created) {
        this.creationDate = new Date(checkNotNull(created).getTime());

        return this;
    }

    @Override
    public TranslationBuilder lastQuestionedDate(final Date questioned) {
        this.lastQuestioned = new Date(checkNotNull(questioned).getTime());

        return this;
    }

}
