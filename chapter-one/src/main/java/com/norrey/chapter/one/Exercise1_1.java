package com.norrey.chapter.one;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
public class Exercise1_1 {

    private static final Logger LOGGER = Logger.getLogger(Exercise1_1.class.getName());

    /**
     * Read the input one line at a time and then write the lines out in reverse
     * order, so that the last input line is printed first, then the second last
     * input line, and so on.
     *
     * @param file
     * @throws java.io.IOException
     */
    public void partOne(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final List<String> lineList = ImmutableList.of();
        try (final Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
            lines.forEachOrdered(lineList::add);
        }

        Collections.reverse(lineList);
        lineList.stream().forEach(System.out::println);
    }

    /**
     * Read the first 50 lines of the input and then write them out in reverse
     * order. Read the next 50 lines and then write them out in reverse order.
     *
     * @param file
     * @throws IOException
     */
    public void partTwo(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final List<String> lineList = ImmutableList.of();
        int lineNumber = 0;
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lineList.add(scanner.nextLine());
            if (lineNumber == 49) {
                Collections.reverse(lineList);
                lineList.stream().forEach(System.out::println);
                lineList.clear();
                lineNumber = 0;
            }
            lineNumber++;
        }

    }

    /**
     * Read the input one line at a time. At any point after reading the first
     * 42 lines, if some line is blank, then output the line that occured 42
     * lines prior to that one.
     *
     * @param file
     * @throws IOException
     */
    public void partThree(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final ArrayDeque<String> lineList = new ArrayDeque<>();
        int lineNumber = 0;
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            if (lineNumber < 42) {
                lineList.add(scanner.nextLine());
                lineNumber++;
            } else {
                final String possibleEmpty = scanner.nextLine();
                if (possibleEmpty.isEmpty()) {
                    System.out.println(lineList.poll());
                    lineList.add(possibleEmpty);
                } else {
                    lineList.remove();
                    lineList.add(possibleEmpty);
                }

            }

        }
    }

    /**
     * Read the input one line at a time and write each line to the output if it
     * is not a duplicate of some previous input line.
     *
     * @param file
     * @throws IOException
     */
    public void partFour(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final Set<String> lineSet = new HashSet<>();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String possibleDuplicate = scanner.nextLine();
            boolean added = lineSet.add(possibleDuplicate);
            if (added) {
                System.out.println(possibleDuplicate);
            }

        }

    }

    /**
     * Read the input one line at a time and write each line to the output only
     * if you have read this line before
     *
     * @param file
     * @throws IOException
     */
    public void partFive(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final Set<String> lineSet = new HashSet<>();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String possibleDuplicate = scanner.nextLine();
            boolean added = lineSet.add(possibleDuplicate);
            if (!added) {
                System.out.println(possibleDuplicate);
            }

        }

    }

    /**
     * Read the entire input one line at a time. Then output all line sorted by
     * length with the shortest lines first. In the case where two lines have
     * the same length, resolve their order using the usual "sorted order".
     * Duplicate lines should be printed only once.
     *
     * @param file
     * @throws IOException
     */
    public void partSix(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final List<String> lineList = ImmutableList.of();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String stringLine = scanner.nextLine();
            lineList.stream().filter((prev) -> (prev.equals(stringLine))).forEach(lineList::remove);
            lineList.add(stringLine);

        }

        lineList.sort(new StringLengthComparator());
        lineList.stream().forEach(System.out::println);

    }

    /**
     * Read the entire input one line at a time. Then output all line sorted by
     * length with the shortest lines first. In the case where two lines have
     * the same length, resolve their order using the usual "sorted order".
     * Duplicate lines should be printed the same number of times as the input.
     *
     * @param file
     * @throws IOException
     */
    public void partSeven(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final List<String> lineList = ImmutableList.of();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String stringLine = scanner.nextLine();
            lineList.add(stringLine);
        }

        lineList.sort(new StringLengthComparator());
        lineList.stream().forEach(System.out::println);

    }

    /**
     *
     * @param file
     * @throws IOException
     */
    public void partEight(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final List<String> lineList = ImmutableList.of();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String stringLine = scanner.nextLine();
            lineList.add(stringLine);
        }
    }

    /**
     * Read the entire input one line at a time and randomly permute the lines
     * before outputting them.
     *
     * @param file
     * @throws IOException
     */
    public void partNine(@Nonnull final File file) throws IOException {
        requireNonNull(file, "The file must not be null");
        final List<String> lineList = ImmutableList.of();
        try (final Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
            /*
             * This will not be read in order
             */
            lines.forEach(lineList::add);
        }
        /*
         * This shuffles the list randomly
         */
        Collections.shuffle(lineList);
        lineList.stream().forEach(System.out::println);
    }

    private class StringLengthComparator implements Comparator<String> {

        @Override
        public int compare(final String string1, final String string2) {
            return string1.length() - string2.length();
        }

    }

}
