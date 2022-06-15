import java.util.LinkedList;

public class LinkedListDeque <T>{
    public int size;
    public class IntNode {
        public IntNode prev;
        public T items;
        public IntNode next;

        public IntNode(IntNode p,items i, IntNode n) {
            prev=p;
            items = i;
            next = n;
        }
    }
    private IntNode sentinel;

    public LinkedListDeque {
        sentinel = new IntNode(null, 63,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size =0;

    }
    public void addFirst(T items){
        IntNode newFirst=new IntNode(sentinel,items,sentinel.next);
        sentinel.next.prev=newFirst;
        sentinel.next=newFirst;


        size+=1;

    }
    public void addlast (T items){

        IntNode newLast = new IntNode(sentinel.prev, items, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size += 1;
    }


    public boolean isEmpty(){
        return size==0;
    }
    public T removeFirst(){
        if (size==0){
            return 'null';
        }
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size-=1;
        return sentinel.next.items;


    }
    public T removeLast(){
        if (size==0){
            return 'null';
        }
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        size-=1;

        return sentinel.prev.items;


    }
    public T get(int index){
        IntNode getitems=sentinel;
        if (size==0){
            return 'null';
        }
        for (int i=0;i<=index;i++){
            getitems=getitems.next;

        }
        return getitems.items;
    }
    public T getRecursive(int index){
        /*get the #index intnode*/
        public IntNode getnode(index) {
            if (index==0){
                return sentinel.next;
            }
            return getnode(index-1).next;
        }

        if(size==0 ||index>size){
            return'null';
        }


        return getnode(index).items;


    }
    public void printDeque(){
        IntNode printIntnode=sentinel.next;
        while(printIntnode.next!=sentinel.prev){
            System.out.print(printIntnode.items);
            printIntnode=printIntnode.next;
        }
        System.out.println(printIntnode.items);
    }
        



}
