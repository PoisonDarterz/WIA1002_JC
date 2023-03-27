package L3;

class ArrayBag<T> implements BagInterface<T>{
    T[] bag;
    final int DEFAULT_CAPACITY = 25;
    int numberOfEntries;

    public ArrayBag(){
        bag = (T[]) new Object[DEFAULT_CAPACITY];
        numberOfEntries = 0;
    }

    public int getCurrentSize(){
        return numberOfEntries;
    }

    public boolean isFull(){
        return numberOfEntries == bag.length;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry){
        if (isFull()){
            return false;
        }
        else{
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
    }

    public T remove(){
        if (isEmpty()){
            return null;
        }
        else{
            T result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return result;
        }
    }

    public boolean remove(T anEntry){
        if (isEmpty()){
            return false;
        }
        else{
            for (int i = 0; i < numberOfEntries; i++){
                if (bag[i].equals(anEntry)){
                    bag[i] = bag[numberOfEntries - 1];
                    bag[numberOfEntries - 1] = null;
                    numberOfEntries--;
                    return true;
                }
            }
            return false;
        }
    }

    public void clear(){
        while (!isEmpty()){
            remove();
        }
    }

    public int getFrequencyOf(T anEntry){
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++){
            if (bag[i].equals(anEntry)){
                count++;
            }
        }
        return count;
    }

    public boolean contains(T anEntry){
        for (int i = 0; i < numberOfEntries; i++){
            if (bag[i].equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    public T[] toArray(){
        T[] result = (T[]) new Object[numberOfEntries];
        System.arraycopy(bag, 0, result, 0, numberOfEntries);
        return result;
    }

    public BagInterface<T> union(BagInterface<? extends T> bag2){
        BagInterface<T> result = new ArrayBag<>();
        T[] bag1Array = toArray();
        for (T t : bag1Array) {
            result.add(t);
        }
        T[] bag2Array = bag2.toArray();
        for (T t : bag2Array){
            result.add(t);
        }
        return result;
    }

    public BagInterface<T> intersection(BagInterface<? extends T> bag2) {
        BagInterface<T> result = new ArrayBag<>();
        T[] bag1Array = toArray();
        T[] bag2Array = bag2.toArray();
        for (T t : bag1Array){
            result.add(t);
        }

        for(int i = 0; i < bag1Array.length; i++){
            boolean found = false;
            for (int j = 0; j < bag2Array.length; j++){
                if (bag1Array[i].equals(bag2Array[j])){
                    found = true;
                    bag2Array[j] = bag2Array[bag2Array.length - 1];
                    bag2Array[bag2Array.length - 1] = null;
                    break;
                }
            }
            if (!found){
                result.remove(bag1Array[i]);
            }
        }
        return result;
    }

    public BagInterface<T> difference(BagInterface<? extends T> bag2){
        BagInterface<T> result = new ArrayBag<>();
        T[] bag1Array = toArray();
        T[] bag2Array = bag2.toArray();
        for (T t : bag1Array){
            result.add(t);
        }
        for (int i = 0; i < bag1Array.length; i++){
            for (int j = 0; j < bag2Array.length; j++){
                if (bag1Array[i].equals(bag2Array[j])){
                    result.remove(bag1Array[i]);
                    bag2Array[j] = bag2Array[bag2Array.length - 1];
                    bag2Array[bag2Array.length - 1] = null;
                    break;
                }
            }
        }
        return result;
    }
}
