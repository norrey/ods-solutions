package com.norrey.chapter.one;

import java.util.EmptyStackException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Norrey Okumu <okumu.norrey@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class Exercise1_2Test {

    @Test(expected = EmptyStackException.class)
    public void testNonDyck() {
        final Exercise1_2 exc12 = new Exercise1_2();
        exc12.testNonDyck();
    }

}
