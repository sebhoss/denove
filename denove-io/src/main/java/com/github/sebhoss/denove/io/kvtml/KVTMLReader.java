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
import com.github.sebhoss.denove.model.example.Examples;
import com.github.sebhoss.denove.model.lesson.Lesson;
import com.github.sebhoss.denove.model.lesson.LessonBuilder;
import com.github.sebhoss.denove.model.lesson.Lessons;
import com.github.sebhoss.denove.model.localizedtext.LocalizedText;
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
 * <h1>Warnings</h1>
 * <ul>
 * </ul>
 * <h1>Examples</h1>
 * <p>
 * 
 * <pre>
 * public void readLessonFromPath() {
 *     final Path path = FileSystems.getDefault().getPath(&quot;path&quot;, &quot;file.kvtml&quot;);
 *     final Reader kvtmlReader = new KVTMLReader();
 *     final Set&lt;Lesson&gt; lessons = kvtmlReader.read(path);
 * }
 * </pre>
 * 
 * </p>
 */
public class KVTMLReader implements Reader {

    private static final Locale DEFAULT_ORIGINAL_LOCALE    = Locale.CHINESE;
    private static final Locale DEFAULT_TRANSLATION_LOCALE = Locale.FRENCH;

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
        final List<Element> entries = rootElement.getChildren(KVTMLElements.ENTRY.getIdentifier());

        for (final Element entry : entries) {
            final WordBuilder wordBuilder = Words.prepareWord();

            final Translation original = parseTranslation(entry.getChild(KVTMLElements.ORIGINAL.getIdentifier()));
            final Translation translation = parseTranslation(entry.getChild(KVTMLElements.TRANSLATION.getIdentifier()));

            wordBuilder.translation(DEFAULT_ORIGINAL_LOCALE, original);
            wordBuilder.translation(DEFAULT_TRANSLATION_LOCALE, translation);

            lessonBuilder.word(wordBuilder.get());
        }

        return ImmutableSet.of(lessonBuilder.get());
    }

    private static Translation parseTranslation(final Element element) {
        final TranslationBuilder translationBuilder = Translations.prepareTranslation();
        translationBuilder.creationDate(DateTime.now());
        translationBuilder.lastQuestionedDate(DateTime.now());
        translationBuilder.example(Examples.emptyExample());
        translationBuilder.text(extractTextInformation(element));

        return translationBuilder.get();
    }

    private static LocalizedText extractTextInformation(final Element element) {
        final LocalizedTextBuilder localizedTextBuilder = LocalizedTexts.prepareLocalizedText();
        localizedTextBuilder.text(element.getText());

        if (element.getAttribute(KVTMLElements.PRONUNCIATION.getIdentifier()) != null) {
            localizedTextBuilder
                    .phoneticSpelling(element.getAttributeValue(KVTMLElements.PRONUNCIATION.getIdentifier()));
        } else {
            localizedTextBuilder.phoneticSpelling(""); //$NON-NLS-1$
        }

        return localizedTextBuilder.get();
    }

}
