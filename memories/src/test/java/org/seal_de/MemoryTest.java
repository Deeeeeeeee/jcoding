package org.seal_de;

public class MemoryTest {
    /**
     * -javaagent:E:\de_project\git\jconding\memories\src\main\resources\SizeOfObject.jar
     */
    public static void main(String[] args) {
        System.out.printf("%-40s%9d\n", "Object:", SizeOfObject.sizeOf(new Object()));
        System.out.printf("%-40s%9d\n", "include one int,IntegerTestOne:", SizeOfObject.sizeOf(new IntegerTestOne()));
        System.out.printf("%-40s%9d\n", "include two int,IntegerTestTwo:", SizeOfObject.sizeOf(new IntegerTestTwo()));
        System.out.println(System.getProperty("os.arch"));
    }

    static class IntegerTestOne {
        private int i1 = 1;
    }

    static class IntegerTestTwo {
        private int i1 = 1;
        private int i2 = 1;
    }
}
