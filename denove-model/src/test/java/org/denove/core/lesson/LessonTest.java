package org.denove.core.lesson;

import java.util.ArrayList;
import java.util.Collection;

import org.denove.core.word.Word;

/**
 * Test cases for the {@link Lesson} interface and its underlying implementation.
 * 
 */
public final class LessonTest {

    private Lesson lesson;

    /**
     * Prepares a single translation which should be used by all tests in this class.
     */
    @Before
    public final void setUp() {
        this.lesson = Lessons.prepareLesson().get();
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#addWord(org.denove.core.word.Word)}.
     */
    @Test
    public void testAddWord() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
    }

    /**
     * <p>
     * Test method for {@link Lesson#addWord(Word)}.
     * </p>
     * 
     * <p>
     * Ensures that you can't add the same word twice.
     * </p>
     */
    @Test
    public void testAddWordDoesNotAcceptDuplicates() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);
        this.lesson.addWord(word);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * <p>
     * Test method for {@link Lesson#addWord(Word)}.
     * </p>
     * 
     * <p>
     * Ensures that you can't add <code>null</code>.
     * </p>
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddWordDoesNotAcceptNull() {
        this.lesson.addWord(null);
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#removeWord(org.denove.core.word.Word)}.
     */
    @Test
    public void testRemoveWord() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);
        this.lesson.removeWord(word);

        // then
        assertThat(this.lesson.getWords(), not(hasItem(word)));
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#addAllWords(java.util.Collection)}.
     */
    @Test
    public void testAddAllWords() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<Word>();
        words.add(word);

        // when
        this.lesson.addAllWords(words);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * <p>
     * Test method for {@link Lesson#addAllWords(Collection)}.
     * </p>
     * 
     * <p>
     * Ensures that you can't add duplicates.
     * </p>
     */
    @Test
    public void testAddAllWordsDoesNotAcceptDuplicates() {
        // given
        final Word word = mock(Word.class);
        final Collection<Word> words = new ArrayList<Word>();
        words.add(word);

        // when
        this.lesson.addWord(word);
        this.lesson.addAllWords(words);

        // then
        assertThat(this.lesson.getWords(), hasItem(word));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(Integer.valueOf(1)));
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#clearWords()}.
     */
    @Test
    public void testClearWords() {
        // given
        final Word word = mock(Word.class);

        // when
        this.lesson.addWord(word);
        this.lesson.clearWords();

        // then
        assertThat(this.lesson.getWords(), not(hasItem(word)));
        assertThat(Integer.valueOf(this.lesson.getWords().size()), is(equalTo(Integer.valueOf(0))));
    }

    /**
     * Test method for {@link org.denove.core.lesson.Lesson#getWords()}.
     */
    @Test
    public void testGetWords() {
        assertThat(this.lesson.getWords(), is(notNullValue()));
    }

}
