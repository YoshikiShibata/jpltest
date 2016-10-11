/*
 * Copyright (C) 2016 Yoshiki Shibata. All rights reserved.
 */
package jpl.ch01.ex01;

import org.junit.Test;
import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

/**
 *
 * @author yoshiki
 */
public class HelloWorldTest {
    
    @Test
    public void testMain() {
        String[] expected = new String[] {"Hello World"};
        
        StdoutCapture sc = new StdoutCapture();
        sc.start();
        
        HelloWorld.main(new String[0]);
        
        sc.stop();
        sc.assertEquals(expected);
    }
}
