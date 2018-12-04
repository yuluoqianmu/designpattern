package com.buka.algorithm.list;

/**
 * Created by shaomaolin on 2018/12/4.
 */
public class ReverseList {

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
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;

        }
        return preNode;
    }

    public static ListNode reverseList2(ListNode head) {
       if (head == null || head.next == null)
           return head;

       ListNode nextNode = head.next;
       head.next = null;
       ListNode reverseHead = reverseList2(nextNode);
       nextNode.next = head;
       return reverseHead;
    }


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
