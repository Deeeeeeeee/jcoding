package org.seal_de;

public class MemoryStaticTest {
    /**
     * -javaagent:{jar包路径}\SizeOfObject.jar
     * 使用指针压缩，在一定情况下64位HotSpot jvm默认指针压缩
     *
     * Output:
     * amd64    +UseCompressedOops
     * StaticTest:                          16
     * Integer:                             16
     * StaticReferenceTest:                 16
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.arch") + "    +UseCompressedOops");
        System.out.printf("%-30s%9d\n", "StaticTest:", SizeOfObject.sizeOf(new StaticTest()));
        System.out.printf("%-30s%9d\n", "Integer:", SizeOfObject.sizeOf(new Integer(1)));
        System.out.printf("%-30s%9d\n", "StaticReferenceTest:", SizeOfObject.sizeOf(new StaticReferenceTest()));
    }

    static class StaticTest {
        private static int i1 = 1;
        private static int i2 = 1;
        private static int i3 = 1;
        private static int i4 = 1;
        private static int i5 = 1;
        private static int i6 = 1;
    }

    static class StaticReferenceTest {
        private static Object o1 = new Object();
        private static Object o2 = new Object();
        private static Object o3 = new Object();
        private static Object o4 = new Object();
        private static Object o5 = new Object();

    }
}
