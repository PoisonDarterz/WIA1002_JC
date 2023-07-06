package selfuse;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GenericQueue<E> {
    LinkedList <E> list  = new LinkedList<>();
    int capacity;

    public GenericQueue(int capacity) {
        this.capacity = capacity;
    }

    public GenericQueue() {
    }


    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean isFull(){
        if(list.size()>capacity)
            return true;

        else
            return false;
    }

    public E peek(){
        return list.getFirst();
    }

    public void enqueue(E element){
        list.add(element);
        System.out.println("Enqueue : "+element);
    }

    public void enqueueMany(String element){
        String [] split = element.split(",");
        for(int i=0;i<split.length;i++){
            list.add((E)split[i]);

            System.out.println("Enqueue : "+split[i]);
        }
        System.out.println("");
    }

    public E dequeue(){
        if(list.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }

        E removed = list.removeFirst();
        System.out.println("Dequeue : "+removed);
        return removed;
    }

    public void dequeueAll(){
        System.out.println("There are "+list.size()+" items in the queue. Removing them all...");
        int size = list.size();
        for(int i=0;i<size;i++){
            System.out.println("Dequeue :"+list.remove());
        }
        System.out.println("");
    }

    public void display(){
        System.out.println("There are " + list.size() + " items in the queue. Displaying...");

        if(list.size()==0){
            System.out.println("Nothing to display");
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
        System.out.println("");
    }
}