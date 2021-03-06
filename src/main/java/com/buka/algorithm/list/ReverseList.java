package com.buka.algorithm.list;

/**
 * 反转链表
 */
public class ReverseList {
    /**
     * 节点定义
     */
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        //上一个节点
        ListNode preNode = null;
        //当前节点
        ListNode curNode = head;

        while(curNode != null) {
            ListNode nextNode = curNode.next;
            //当前节点的下一个节点等于前一个节点
            curNode.next = preNode;
            //前一个节点等于当前节点
            preNode = curNode;
            //当前节点等于next
            curNode = nextNode;

        }
        return preNode;
    }

    /**
     * 递归方式
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
       if (head == null || head.next == null)
           return head;

       ListNode nextNode = head.next;
       head.next = null;
       ListNode reverseHead = reverseList2(nextNode);
       nextNode.next = head;
       return reverseHead;
    }

    //测试
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = node1;

        ListNode newHead = reverseList(head);
        while(newHead != null) {
            System.out.print("data :" + newHead.val + "\n");
            newHead = newHead.next;

        }

    }

}
