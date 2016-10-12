/*
 * Copyright (C) 2016 Yoshiki Shibata. All rights reserved.
 */
package jpl.ch01.ex07;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

import org.junit.Test;

/**
 *
 * @author yoshiki
 */
public class ImprovedFibonacciTest {

    @Test
    public void testMain() {
        String[] expected = new String[]{
            "1: 1",
            "2: 1",
            "3: 2 *",
            "4: 3",
            "5: 5",
            "6: 8 *",
            "7: 13",
            "8: 21",
            "9: 34 *"};

        StdoutCapture sc = new StdoutCapture();
        sc.start();

        ImprovedFibonacci.main(new String[0]);

        sc.stop();
        sc.assertEquals(expected);
    }
}
