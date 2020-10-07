package com.thewithel.model;

/**
 * Interface convertible should be implemented to classes
 * that can be converted to message that is represented in
 * String field. It has one method convert which returns string.
 * With only one method to implement it is also made as Functional
 * Interface.
 *
 * @author Mateusz Klimas
 */
public interface Convertible {

    String convert();
}
