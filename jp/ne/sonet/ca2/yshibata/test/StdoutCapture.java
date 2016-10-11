/*
 * Copyright (C) 2016 Yoshiki Shibata. All rights reserved.
 */
package jp.ne.sonet.ca2.yshibata.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;

/**
 *
 * @author yoshiki
 */
public final class StdoutCapture {

    private boolean started = false;
    private PrintStream writer;
    private ByteArrayOutputStream baos;

    /**
     * Starts capturing of System.out
     *
     * @throws IllegalStateException Capturing has already started.
     */
    public synchronized void start() {
        if (started) {
            throw new IllegalStateException("Has already started");
        }

        baos = new ByteArrayOutputStream();
        PrintStream ps;
        try {
            ps = new PrintStream(baos, true, "UTF-8");
            writer = System.out;
            System.setOut(ps);
            started = true;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(StdoutCapture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Stops capturing of System.out
     *
     * @throws IllegalStateException Capturing has not started yet.
     */
    public synchronized void stop() {
        if (!started) {
            throw new IllegalStateException("Has not started yet");
        }
        started = false;
        System.out.close();
        System.setOut(writer);
    }

    /**
     * Determines if the captured output equals to the specified argument.
     * All NL and CR characters are ignored.
     *
     * @param expected An array of expected output
     */
    public synchronized void assertEquals(String... expected) {
        if (started) {
            throw new IllegalStateException("Has not stopped yet");
        }
        byte[] bytes = baos.toByteArray();
        try {
            String out = new String(bytes, "UTF-8");
            Assert.assertArrayEquals(trimLines(expected),
                    trimLines(out.split(System.lineSeparator())));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(StdoutCapture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] trimLines(String[] lines) {
        String[] result = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (line.charAt(line.length() - 1) == '\n') {
                line = line.substring(0, line.length() - 1);
            }
            if (line.charAt(line.length() - 1) == '\r') {
                line = line.substring(0, line.length() - 1);
            }
            result[i] = line;
        }

        return result;
    }
}
