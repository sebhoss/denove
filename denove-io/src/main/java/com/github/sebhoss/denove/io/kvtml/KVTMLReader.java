package com.github.sebhoss.denove.io.kvtml;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.joda.time.DateTime;

import com.github.sebhoss.denove.io.common.Reader;
import com.github.sebhoss.denove.model.example.Example;
import com.github.sebhoss.denove.model.example.Examples;
import com.github.sebhoss.denove.model.lesson.Lesson;
import com.github.sebhoss.denove.model.lesson.LessonBuilder;
import com.github.sebhoss.denove.model.lesson.Lessons;
import com.github.sebhoss.denove.model.localizedtext.LocalizedTextBuilder;
import com.github.sebhoss.denove.model.localizedtext.LocalizedTexts;
import com.github.sebhoss.denove.model.translation.Translation;
import com.github.sebhoss.denove.model.translation.TranslationBuilder;
import com.github.sebhoss.denove.model.translation.Translations;
import com.github.sebhoss.denove.model.word.WordBuilder;
import com.github.sebhoss.denove.model.word.Words;
import com.google.common.collect.ImmutableSet;

/**
 * <h1>Overview</h1>
 * <p>
 * Reader for KVTML version 1 files.
 * </p>
 * 
 * <h1>Warnings</h1>
 * <ul>
 * <li>Can only hold a single lesson</li>
 * <li>Doesn't specify the language of its entries</li>
 * </ul>
 * 
 * <h1>Examples</h1>
 * <p>
 * 
 * </p>
 */
public class KVTMLReader implements Reader {

    private static final String  ENTRY                      = "e";           //$NON-NLS-1$
    private static final String  ORIGINAL                   = "o";           //$NON-NLS-1$
    private static final String  TRANSLATION                = "t";           //$NON-NLS-1$
    private static final Locale  DEFAULT_ORIGINAL_LOCALE    = Locale.CHINESE;
    private static final Locale  DEFAULT_TRANSLATION_LOCALE = Locale.FRENCH;
    private static final Example EMPTY_EXAMPLE              = Examples.prepareExample().sentence("").correctForm("") //$NON-NLS-1$ //$NON-NLS-2$
                                                                    .get();

    @Override
    public Set<Lesson> read(final Path path) {
        final Document document = buildDocument(path);

        return parseLessons(document);
    }

    private static Document buildDocument(final Path path) {
        final SAXBuilder saxBuilder = new SAXBuilder();

        try {
            return saxBuilder.build(path.toFile());
        } catch (JDOMException | IOException exception) {
            throw new IllegalArgumentException(exception.getCause());
        }
    }

    private static Set<Lesson> parseLessons(final Document document) {
        final LessonBuilder lessonBuilder = Lessons.prepareLesson();

        final Element rootElement = document.getRootElement();
        final List<Element> entries = rootElement.getChildren(ENTRY);

        for (final Element entry : entries) {
            final WordBuilder wordBuilder = Words.prepareWord();

            final Translation original = parseTranslation(entry.getChild(ORIGINAL));
            final Translation translation = parseTranslation(entry.getChild(TRANSLATION));

            wordBuilder.translation(DEFAULT_ORIGINAL_LOCALE, original);
            wordBuilder.translation(DEFAULT_TRANSLATION_LOCALE, translation);

            lessonBuilder.word(wordBuilder.get());
        }

        return ImmutableSet.of(lessonBuilder.get());
    }

    private static Translation parseTranslation(final Element element) {
        final LocalizedTextBuilder localizedTextBuilder = LocalizedTexts.prepareLocalizedText();
        localizedTextBuilder.text(element.getText());
        localizedTextBuilder.phoneticSpelling(""); //$NON-NLS-1$

        final TranslationBuilder translationBuilder = Translations.prepareTranslation();
        translationBuilder.creationDate(DateTime.now()); // KVTML 1 does not support creation dates
        translationBuilder.lastQuestionedDate(DateTime.now()); // KVTML 1 does not support last questioned date
        translationBuilder.example(EMPTY_EXAMPLE); // KVTML 1 does not support example sentences
        translationBuilder.text(localizedTextBuilder.get());

        return translationBuilder.get();
    }

}
