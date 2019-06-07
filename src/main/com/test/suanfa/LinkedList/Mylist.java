package suanfa.LinkedList;

public class Mylist {
    /**
     * 定义头节点
     */
    private Node head;
    /**
     * 记录当前节点(为链表中最后一个节点）
     */
    private Node current;

    /**
     * 结点定义
     */
    class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 链表中添加数据
     * @param data
     */
    private void addData(int data) {
        if (head == null) {
            //头节点为空则新建头节点
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    /**
     * 打印链表
     * @param head
     */
    private void printList(Node head) {
        if (head != null) {
            current = head;
            while (current != null) {
                //未节点换行
                if (current.next == null) {
                    System.out.println(current.data);
                } else {
                    System.out.print(current.data + "-->");
                }
                current = current.next;
            }
        }
    }


    public static void main(String[] args) {
        Mylist mylist = new Mylist();
        for (int i = 0; i < 5; i++) {
            mylist.addData(i);
        }
        //打印链表
        mylist.printList(mylist.head);
        System.out.println("倒置链表1");
        //通过反转得到反转后的head节点，然后打印。下同
        mylist.head = mylist.reverse1(mylist.head);
        mylist.printList(mylist.head);
        System.out.println("遍历倒置链表");
        mylist.head = mylist.reverse2(mylist.head);
        mylist.printList(mylist.head);
    }

    /**
     *  递归倒置单向链表(入参传入头节点)，最后返回的是倒置后的head
     * @param head
     * @return The new head of reversed linked list
     */
    //TODO  没太理解
    private Node reverse1(Node head) {
        if (head == null || head.next == null) {
            return head;                        // 若为空链或者当前结点在尾结点，则直接返回
        } else {
            Node newHead = reverse1(head.next);   //反转后续节点head.next
            head.next.next = head;              //将当前节点的指针域向前移
            head.next = null;                   //前一节点的指针域置空
            return newHead;
        }
    }

    /**
     * 遍历方法倒置单向链表(入参传入头节点)，最后返回的是倒置后的head
     * @param node
     * @return The new head of reversed linked list
     */
    public Node reverse2(Node node) {
        Node prev = null;
        Node now = node;
        //while 循环里已经把链表倒置，最后返回新链表中的head
        while (now != null) {
            Node next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }

}
