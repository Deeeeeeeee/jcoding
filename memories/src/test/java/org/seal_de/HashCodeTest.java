package org.seal_de;

import org.junit.Test;

public class HashCodeTest {
    @Test
    public void testHashCode() {
        System.out.println(new Object().hashCode());
        System.out.println(new Integer(1).hashCode());
    }
}
