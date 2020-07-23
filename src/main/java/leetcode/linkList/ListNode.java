package leetcode.linkList;

/**
 * 结点定义
 * @author yanyuchi
 * @date 2020-07-22 10:11
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}

    public ListNode(int x){
        val = x;
        next = null;
    }

    /**
     * 头指针尾插法
     * @param a 数组
     */
    public static ListNode  createListR(int a[]){

        ListNode header = null;
        ListNode r = null;
        int i;
        if(a.length>0){
            for(i=0;i<a.length;i++){
                ListNode s = new ListNode(a[i]);
                if(header == null){
                    header = s;
                    r = s;
                }else {
                    r.next = s;
                    r = r.next;
                }
            }
            r.next = null;
        }
        return header;
    }

    /**
     * 打印数组
     * @param header 头指针
     */
    public static void printLinkList(ListNode header){
        while (header!=null){
            System.out.println(header.val);
            header = header.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        int a [] = {4,1,2,3};
        ListNode header = createListR(a);
        while (header!=null){
            System.out.println(header.val);
            header = header.next;
        }
    }
}
