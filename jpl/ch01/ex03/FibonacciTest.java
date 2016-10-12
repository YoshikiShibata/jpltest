/*
 * Copyright (C) 2016 Yoshiki Shibata. All rights reserved.
 */
package jpl.ch01.ex03;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;
import org.junit.Test;

/**
 *
 * @author yoshiki
 */
public class FibonacciTest {

    @Test
    public void testMain() {
        String[] expected = new String[]{
            "フィボナッチ数列",
            "1",
            "1",
            "2",
            "3",
            "5",
            "8",
            "13",
            "21",
            "34"};

        StdoutCapture sc = new StdoutCapture();
        sc.start();

        Fibonacci.main(new String[0]);

        sc.stop();
        sc.assertEquals(expected);
    }
}
