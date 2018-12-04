package com.buka.algorithm.list;

/**
 * Created by shaomaolin on 2018/12/4.
 */
public class ReverseList {

    public static class ListNode {
        private String data;
        private ListNode next;

        public ListNode(String data) {
            this.data = data;
        }
        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        if (head.getNext() == null)
            return head;

        //上一个节点
        ListNode preNode = null;
        //当前节点
        ListNode curNode = head;

        while(curNode != null) {
            ListNode nextNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = nextNode;

        }
        return preNode;
    }

    public static ListNode reverseList2(ListNode head) {
       if (head == null || head.getNext() == null)
           return head;

       ListNode nextNode = head.getNext();
       head.setNext(null);
       ListNode reverseHead = reverseList2(nextNode);
       nextNode.setNext(head);
       return reverseHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode("1");
        ListNode node2 = new ListNode("2");
        ListNode node3 = new ListNode("3");
        ListNode node4 = new ListNode("4");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        ListNode head = node1;

        ListNode newHead = reverseList2(head);
        while(newHead != null) {
            System.out.print("data :" + newHead.getData() + "\n");
            newHead = newHead.getNext();

        }

    }

}
