package com.github.sebhoss.denove.io.common;

import java.nio.file.Path;
import java.util.Set;

import org.denove.core.lesson.Lesson;

public interface Reader {
	
	Set<Lesson> read(Path path);
	Set<Lesson> read(String content);

}
