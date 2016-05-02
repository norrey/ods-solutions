package com.norrey.chapter.one;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
     */
    private void partOne(final File file) throws IOException {
        final List<String> lineList = ImmutableList.of();
        try (Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
            lines.forEachOrdered(lineList::add);
        }

        for (int i = lineList.size() - 1; i >= 0; i--) {
            System.out.println(lineList.get(i));
        }

    }

}
