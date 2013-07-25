package com.github.sebhoss.denove.io.kvtml;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;

import com.github.sebhoss.denove.io.common.Reader;
import com.github.sebhoss.denove.model.lesson.Lesson;
import com.github.sebhoss.denove.model.word.Word;
import com.google.common.collect.ImmutableSet;

/**
 * Tests for {@link KVTMLReader}.
 */
@SuppressWarnings({ "static-method", "nls" })
public class KVTML1ReaderTest {

    private static final String RESOURCE_PATH = "src/test/resources/kvtml";

    /**
     * Test for {@link KVTMLReader#read(Path)}
     * <p>
     * Ensures that the reader can read from a path
     */
    @Test
    public void shouldReadKVTML1Path() {
        // given
        final Reader kvtmlReader = new KVTMLReader();
        final Path path = FileSystems.getDefault().getPath(RESOURCE_PATH, "sample.kvtml");

        // when
        final Set<Lesson> lessons = kvtmlReader.read(path);

        // then
        assertThat("Could not parse lesson", Integer.valueOf(lessons.size()), is(Integer.valueOf(1)));
    }

    /**
     * Test for {@link KVTMLReader#read(Path)}
     * <p>
     * Ensures that all entries inside the sample file are parsed
     */
    @Test
    public void shouldReadAllEntries() {
        // given
        final Reader kvtmlReader = new KVTMLReader();
        final Path path = FileSystems.getDefault().getPath(RESOURCE_PATH, "sample.kvtml");

        // when
        final Set<Lesson> lessons = kvtmlReader.read(path);
        final Lesson lesson = lessons.iterator().next(); // only 1 lesson in the set

        // then
        assertThat("Could not parse entries", Integer.valueOf(lesson.getWords().size()), is(Integer.valueOf(3)));
    }

    /**
     * Test for {@link KVTMLReader#read(Path)}
     * <p>
     * Ensures that language codes are parsed correctly.
     */
    @Test
    public void shouldParseLocale() {
        // given
        final Reader kvtmlReader = new KVTMLReader();
        final Path path = FileSystems.getDefault().getPath(RESOURCE_PATH, "sample-with-language-codes.kvtml");
        final Set<Locale> expectedLocales = ImmutableSet.of(Locale.FRENCH, Locale.ENGLISH);

        // when
        final Set<Lesson> lessons = kvtmlReader.read(path);
        final Lesson lesson = lessons.iterator().next(); // only 1 lesson in the set

        // then
        for (final Word word : lesson.getWords()) {
            assertThat("Could not parse Locales", word.getAvailableLanguages(), is(expectedLocales));
        }
    }

}
