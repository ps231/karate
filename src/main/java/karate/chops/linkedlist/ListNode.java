package karate.chops.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(final int x) { val = x; }
    public ListNode() {

    }

public int getVal() {
   return val;
}

public void setVal(final int val) {
   this.val = val;
}

public ListNode getNext() {
   return next;
}

public void setNext(final ListNode next) {
   this.next = next;
}
}
