/*
 * Copyright (C) 2016 Yoshiki Shibata. All rights reserved.
 */
package jpl.ch01.ex15;

/**
 * ExtendedLookup provides addition and removal operations as well as the find operation.
 * 
 * @author yoshiki
 */
public interface ExtendedLookup extends Lookup {
    
    /**
     * Adds a pair of name and value. value must not be null. 
     * If a pair with the specified name has already been added, then the value
     * of the existing pair will be replaced.
     * 
     * @param name name
     * @param value value
     * @throws NullPointerException if either name or value is null.
     */
    void add(String name, Object value);
    
    /**
     * Removes a pair specified by name. If there is no pair with the specified
     * name, null will be returned. Otherwise the corresponding value will be returned.
     * @param name name
     * @return value or null.
     */
    Object remove(String name);
}
