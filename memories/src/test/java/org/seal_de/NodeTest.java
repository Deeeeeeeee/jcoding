package org.seal_de;

public class NodeTest {
    /**
     * -javaagent:{jar包路径}\SizeOfObject.jar
     * 使用指针压缩，在一定情况下64位HotSpot jvm默认指针压缩
     *
     * Output:
     * amd64    +UseCompressedOops
     * DoublyLinkedList:                    24
     * Node:                                32
     *
     * DoublylinkedList: 12 + 4*3 = 24
     * Node: 12 + 4*4 + 4 = 32
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkedList<Object> list = new DoublyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.append(new Object());
        }
        System.out.println(System.getProperty("os.arch") + "    +UseCompressedOops");
        System.out.printf("%-30s%9d\n", "DoublyLinkedList:", SizeOfObject.sizeOf(list));
        System.out.printf("%-30s%9d\n", "Node:", SizeOfObject.sizeOf(list.node(1)));
    }
}
