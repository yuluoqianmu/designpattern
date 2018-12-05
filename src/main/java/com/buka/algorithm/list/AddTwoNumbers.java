package com.buka.algorithm.list;

/**
 * 两数相加
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode resultListNode = new ListNode((l1.val + l2.val + carry) % 10);
        carry = (l1.val + l2.val + carry ) / 10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode temp = resultListNode;
        while(l1!=null || l2!=null || carry!=0) {
            temp.next = new ListNode((l1!=null?l1.val:0) + (l2!=null?l2.val:0) + carry);
            temp = temp.next;
            carry = ((l1!=null?l1.val:0) + (l2!=null?l2.val:0) + carry) / 10;
            l1 = (l1!=null?l1.next:l1);
            l2 = (l2!=null?l2.next:l2);
        }
        return resultListNode;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        ListNode l1 = node1;


        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;
        ListNode l2 = node4;
        ListNode newNode = addTwoNumbers(l1, l2);


        while(newNode!=null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }



}
