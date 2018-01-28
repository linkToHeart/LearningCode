package com.leetcode;

public class AddTwoNumbers {

    public static class LinkNode{
        int val;
        LinkNode next;
        LinkNode(int val){
            this.val = val;
        }

        void print(){
            StringBuffer str = new StringBuffer();
            str.append(this.val);
            while (this.next != null){
                str.append("->").append(this.next.val);
                this.next = this.next.next;
            }
            System.out.println(str.toString());
        }
    }

    public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2){
        LinkNode allNode = new LinkNode(0);
        LinkNode preNode = allNode;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            LinkNode cur = new LinkNode(sum % 10);
            carry = sum / 10;
            preNode.next = cur;
            preNode = preNode.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            preNode.next = new LinkNode(carry);
        }

        return allNode.next;
    }

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(5);
//        LinkNode l2 = new LinkNode(4);
//        LinkNode l3 = new LinkNode(3);
//        l1.next = l2;
//        l2.next = l3;

        LinkNode n1 = new LinkNode(5);
//        LinkNode n2 = new LinkNode(6);
//        LinkNode n3 = new LinkNode(4);
//        n1.next = n2;
//        n2.next = n3;

        addTwoNumbers(l1,n1).print();
    }
}
