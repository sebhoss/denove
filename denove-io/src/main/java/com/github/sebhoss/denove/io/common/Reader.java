package com.github.sebhoss.denove.io.common;

import java.nio.file.Path;
import java.util.Set;

import com.github.sebhoss.denove.model.lesson.Lesson;

/**
 * Common interface for all IO readers
 */
public interface Reader {

    /**
     * @param path
     *            The path to a single file.
     * @return The set of lessons found inside <code>path</code>.
     */
    Set<Lesson> read(Path path);

}
