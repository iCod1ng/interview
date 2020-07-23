package leetcode.linkList.easy.intersect;

import leetcode.linkList.ListNode;

/**
 * @author yanyuchi
 * @date 2020-07-22 10:16
 */
public class Solution {


    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return  null;
        }
        ListNode p =  headA;
        ListNode q = headB;
        int lengthA = getLength(p);
        int lengthB = getLength(q);
        if(lengthA>lengthB){
            int offset = lengthA - lengthB;
            for(int i=0;i<offset;i++){
                headA = headA.next;
            }
        }else {
            int offset = lengthB - lengthA;
            for(int i=0;i<offset;i++){
                headB = headB.next;
            }
        }
        while (headA!=null && headB !=null){
            if(headA==headB){
                System.out.println("Intersect Node:"+headA);
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        System.out.println("No intersect");
        return null;
    }

    public int getLength(ListNode node){
        int length = 0;
        while (node!=null){
            length++;
            node = node.next;
        }
        return length;
    }

    public static void main(String[] args) {
        int a [] = {4,1,8,4,5};
        int b [] = {5,0,1};

        ListNode headerA = ListNode.createListR(a);

        ListNode headerB = ListNode.createListR(b);

        ListNode p = headerA;

        while (p!=null){
            if(p.val == 8){
                break;
            }
            p = p.next;
        }
        ListNode q = headerB;
        while (q!=null){
            if(q.next == null){
                q.next = p;
                break;
            }
            q = q.next;
        }

        ListNode.printLinkList(headerA);
        ListNode.printLinkList(headerB);

        Solution solution = new Solution();

        solution.getIntersectionNode(headerA,headerB);

    }

}
