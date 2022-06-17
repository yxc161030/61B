//import java.util.LinkedList;

public class LinkedListDeque <T> {
        private int size;
    public class IntNode {
        public IntNode prev;
        public T items;
        public IntNode next;

        public IntNode(IntNode p,T i, IntNode n) {
            prev=p;
            items = i;
            next = n;
        }
    }
    private IntNode sentinel;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size = 0;

    }
    public void addFirst(T items) {
        IntNode newFirst=new IntNode(sentinel,items,sentinel.next);
        sentinel.next.prev=newFirst;
        sentinel.next=newFirst;


        size +=1;

    }
    public void addLast (T items){

        IntNode newLast = new IntNode(sentinel.prev, items, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size += 1;
    }


    public boolean isEmpty(){
        return size==0;
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnitems=sentinel.next.items;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return returnitems;


    }
    public int size(){
        return size;
    }
    public T removeLast(){
        if (size==0){
            return null;
        }
        T returnitems=sentinel.prev.items
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        size-=1;

        return returnitems;


    }
    public T get(int index){
        IntNode getitems=sentinel;
        if (size==0||size<=index){
            return null;
        }
        for (int i=0;i<=index;i++){
            getitems=getitems.next;

        }
        return getitems.items;
    }




    public T getnode(int index, IntNode a){

        if (index == 0) {
            return a.items;
        }

        return getnode(index-1,a.next);

    }
    public T getRecursive(int index) {
        /*get the #index intnode*/


        if (size == 0 || index >= size) {
            return null;
        }
        IntNode a=sentinel.next;


        return getnode(index, a);
    }
    public void printDeque(){
        IntNode printIntnode = sentinel.next;
        while(printIntnode.next!=sentinel){
            System.out.print( printIntnode.items + " ");
            printIntnode=printIntnode.next;
        }
        System.out.println( printIntnode.items);
    }
        



}
