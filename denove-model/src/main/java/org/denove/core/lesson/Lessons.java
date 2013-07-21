package org.denove.core.lesson;

import org.denove.core.lesson.implementation.LessonBuilderImplementation;

/**
 * Utility class which is used to create new {@link Lesson lessons} by using a {@link LessonBuilder}. Thus this class
 * eliminates the need for the "new" keyword.
 * 
 * @see Lesson
 */
public final class Lessons {

    /**
     * Prepares a new {@link Lesson} by returning a new {@link LessonBuilder} which is used to construct the lesson.
     * 
     * @return A new LessonBuilder to build a new lesson.
     */
    public static LessonBuilder prepareLesson() {
        return new LessonBuilderImplementation();
    }

    private Lessons() {
        // Do nothing..
    }

}
