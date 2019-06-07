package suanfa.LinkedList;

public class Node {
    //链表的值
    private int value;
    //指向下一个节点的指针
    private Node next;

    public Node(int value){
        this.value = value;
    }

    /**
     * 获取单链表的长度（已知链表头节点）
     * @param head
     * @return
     */
    public int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy.next;
        Node pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy;
    }

}
