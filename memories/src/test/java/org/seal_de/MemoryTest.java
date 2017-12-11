package org.seal_de;

public class MemoryTest {
    /**
     * -javaagent:{jar包路径}\SizeOfObject.jar -XX:+UseCompressedOops
     * 使用指针压缩，在一定情况下64位HotSpot jvm默认指针压缩
     *
     *Output:
     *amd64
     *Object:                              16
     *
     *include one int:                     16
     *include two int:                     24
     *include three int:                   24
     *
     *include one object:                  16
     *include one object:                  24
     */
    static void test1() {
        System.out.println(System.getProperty("os.arch"));
        System.out.printf("%-30s%9d\n", "Object:", SizeOfObject.sizeOf(new Object()));
        System.out.println();
        System.out.printf("%-30s%9d\n", "include one int:", SizeOfObject.sizeOf(new IntegerTestOne()));
        System.out.printf("%-30s%9d\n", "include two int:", SizeOfObject.sizeOf(new IntegerTestTwo()));
        System.out.printf("%-30s%9d\n", "include three int:", SizeOfObject.sizeOf(new IntegerTestThree()));
        System.out.println();
        System.out.printf("%-30s%9d\n", "include one object:", SizeOfObject.sizeOf(new ReferenceTestOne()));
        System.out.printf("%-30s%9d\n", "include one object:", SizeOfObject.sizeOf(new ReferenceTestTwo()));
    }

    /**
     * -javaagent:{jar包路径}\SizeOfObject.jar -XX:-UseCompressedOops
     * 不使用指针压缩
     *
     *Output:
     *amd64
     *Object:                              16
     *
     *include one int:                     24
     *include two int:                     24
     *include three int:                   32
     *
     *include one object:                  24
     *include one object:                  32
     */
    static void test2() {
        System.out.println(System.getProperty("os.arch"));
        System.out.printf("%-30s%9d\n", "Object:", SizeOfObject.sizeOf(new Object()));
        System.out.println();
        System.out.printf("%-30s%9d\n", "include one int:", SizeOfObject.sizeOf(new IntegerTestOne()));
        System.out.printf("%-30s%9d\n", "include two int:", SizeOfObject.sizeOf(new IntegerTestTwo()));
        System.out.printf("%-30s%9d\n", "include three int:", SizeOfObject.sizeOf(new IntegerTestThree()));
        System.out.println();
        System.out.printf("%-30s%9d\n", "include one object:", SizeOfObject.sizeOf(new ReferenceTestOne()));
        System.out.printf("%-30s%9d\n", "include one object:", SizeOfObject.sizeOf(new ReferenceTestTwo()));
    }

    public static void main(String[] args) {
        test2();
    }

    static class IntegerTestOne {
        private int i1 = 1;
    }

    static class IntegerTestTwo {
        private int i1 = 1;
        private int i2 = 1;
    }

    static class IntegerTestThree {
        private int i1 = 1;
        private int i2 = 1;
        private int i3 = 1;
    }

    static class ReferenceTestOne {
        private Object o1 = new Object();
    }

    static class ReferenceTestTwo {
        private Object o1 = new Object();
        private Object o2 = new Object();
    }
}
