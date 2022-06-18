public class ArrayDeque<T> {

    public T[] items ;
    public int size;
    public int nextFirst;
    public int nextLast;
    public double R;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 2;
        nextLast = 3;
        R= size/ items.length;
    }
    private void resize(int capacity) {
        T[] a =  (T[])new Object [capacity];
        if (items.length - nextFirst > size)
           /* if(nextFirst<nextLast && 0<size && size< items.length)*/
            {
            System.arraycopy(items, nextFirst+1, a, 0, size);


        }
        /*if (nextFirst>nextLast && size< items.length ){
            System.arraycopy(items, nextFirst+1, a, 0, items.length-1-nextFirst);
            System.arraycopy(items, 0, a, items.length-1-nextFirst, nextLast);
        }*/
        else if (size>0&&nextFirst== items.length-1) {
            System.arraycopy(items, 0, a, 0, size);

        }

        else {
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - 1 - nextFirst);
            System.arraycopy(items, 0, a, items.length - 1 - nextFirst, nextLast);
        }

        items = a;


        nextFirst= items.length-1;
        nextLast=size;
    }

    public void addFirst(T item) {
        if (size == items.length&&size>0) {
            resize(size * 2);
        }
        items[nextFirst] = item;

        size+=1;



        if (nextFirst==0) {


            nextFirst= items.length-1;
        }

        else {
            nextFirst-=1;
        }

    }
    public void addLast(T item) {
        if (size == items.length&&size>0) {
            resize(size * 2);
        }

        size+=1;
        items[nextLast] = item;



        if (nextLast== items.length-1) { nextLast=0;}

        else{
            nextLast+=1;}


    }
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else {
            return false;
        }
    }
    public int size(){
        return size;
    }
    public T removeLast() {

        if (size==0){
            return null;
        }
        else if(nextLast==0){
            T returnItem = items[items.length-1];
            items[items.length-1]= null;
            nextLast= items.length-1;
            size -= 1;
            if (R<0.25&&size>0){
                resize(size*2);
            }
            return returnItem;

        }
        else{
            T returnItem = items[nextLast-1];
            items[nextLast-1]= null ;
            nextLast=nextLast-1;
            size -= 1;
            if (R<0.25&&size>0){
                resize(size*2);
            }
            return returnItem;

        }


    }

    public void printDeque(){
        resize(size*2);
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        else if (nextFirst == items.length - 1) {
            T returnItem = items[0];
            items[0] = null;
            nextFirst = 0;
            size -= 1;
            if (R<0.25){
                resize(size*2);
            }
            return returnItem;

        }
        else {
            T returnItem = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst = nextFirst + 1;
            size -= 1;
            if (R<0.25){
                resize(size*2);
            }
            return returnItem;


        }
    }

    public T  get(int index){
        if (size<= index ){
            return null;
        } else if (nextFirst== items.length-1) {
            return items[index];

        }

        /*else if (nextFirst<nextLast && 0< size < items.length ) {
            return items.[nextFirst+index];
        }*/
        else if ((nextFirst+index+1)< items.length){
            return items[nextFirst+index+1];
        }
        else {
            return items[nextFirst + index+1- items.length];
        }
    }

}
