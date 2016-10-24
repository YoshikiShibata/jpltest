/*
 * Copyright © 2016 Yoshiki Shibata. All rights reserved.
 */
package jpl.ch01.ex15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author yoshiki
 */
public class SimpleExtendedLookupTest {

    @Test(expected = NullPointerException.class)
    public void testNullForFind() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        el.find(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameForAdd() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        el.add(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullValueForAdd() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        el.add("hello", null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullForRemove() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        el.remove(null);
    }

    @Test
    public void testFindForEmpty() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        Object value = el.find("hello");

        // Check
        assertNull("value should be null", value);
    }

    @Test
    public void testRemoveForEmpty() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        Object value = el.remove("hello");

        // Check
        assertNull("value should be null", value);
    }

    @Test
    public void testSimpleAddFindRemove() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();

        // Action
        el.add("hello", "world");
        Object value = el.find("hello");

        // Check
        assertEquals("value should be hello", "world", value);

        // Action
        value = el.remove("hello");

        // Check
        assertEquals("value should be hello", "world", value);
    }

    @Test
    public void testMultipleAddFindRemoves() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();
        String[] data = {
            "key1", "value1",
            "key2", "value2",
            "key3", "value3",
            "key4", "value4",
            "key5", "value5",};

        // Action
        for (int i = 0; i < data.length; i += 2) {
            el.add(data[i], data[i + 1]);
        }

        for (int i = 0; i < data.length; i += 2) {
            // Action
            Object value = el.find(data[i]);
            // Check
            assertEquals(data[i + 1], value);
        }

        for (int i = 0; i < data.length; i += 2) {
            // Action
            Object value = el.remove(data[i]);
            // Check
            assertEquals(data[i + 1], value);
        }
    }
    
    @Test
    public void testSimpleMultipleSameAdds() {
        // Prepare
        ExtendedLookup el = new SimpleExtendedLookup();
        
        // Action
        el.add("hello", "world");
        el.add("hello", "世界");
        Object value = el.find("hello");
        
        // Check
        assertEquals("value should be 世界:", "世界", value);
    }

}
