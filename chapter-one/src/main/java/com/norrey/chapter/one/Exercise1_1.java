package com.norrey.chapter.one;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

/**
 *
 * @author Norrey Okumu
 */
public class Exercise1_1 {

    private static final Logger LOGGER = Logger.getLogger(Exercise1_1.class.getName());

    /**
     * Read all lines from a file using a stream and store the contents in an
     * arrayList Print the contents of the arraylist in reverse order.
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
     * Write unique lines only
     *
     * @param file
     * @throws IOException
     */
    public void partFour(@Nonnull final File file) throws IOException {
        requireNonNull(file, " The file must not be null");

        final List<String> lineList = ImmutableList.of();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String possibleDuplicate = scanner.nextLine();

            lineList.stream().filter((prev) -> (!prev.equals(possibleDuplicate))).forEach((prev) -> {
                lineList.add(possibleDuplicate);
                System.out.println(prev);
            });

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

        final List<String> lineList = ImmutableList.of();
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String possibleDuplicate = scanner.nextLine();
            lineList.stream().filter((prev) -> (prev.equals(possibleDuplicate))).forEach( (prev) ->{
                System.out.println(prev);
                lineList.add(possibleDuplicate);
            });
            
        }

    }

}
