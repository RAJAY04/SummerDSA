package Implementations.Heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;
    Heap(){
        heap = new ArrayList<>();
    }

    private void swap(int i , int j){
        T temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int left(int index){
        return (index * 2) + 1;
    }

    private int right (int index){
        return (index * 2) + 2;
    }
    public void insert(T value){
        heap.add(value);
        upHeap(heap.size() - 1);
    }

    public void upHeap(int index){
        if(index == 0)return;

        int p = parent(index);
        if(heap.get(index).compareTo(heap.get(p)) < 0){
            swap(index,p);
            upHeap(p);
        }
    }

    public T remove() throws Exception{
        if(heap.isEmpty()){
            throw new Exception("Removing from an empty heap");
        }

        T temp = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()){
            heap.set(0,last);
        }

        downHeap(0);
        return temp;
    }

    public void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);
        if(left < heap.size() && heap.get(min).compareTo(heap.get(left)) > 0){
            min = left;
        }

        if(right < heap.size() && heap.get(min).compareTo(heap.get(right)) > 0){
            min = right;
        }

        if(min != index){
            swap(min,index);
            downHeap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while(!heap.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }

    public ArrayList<T> sortArray(T[] arr) throws Exception{
        for(T t : arr){
            this.insert(t);
        }
        return this.heapSort();
    }
    //complexity of heapSort is O(nlogn)
    //but complexity of heapify is O(n) because we are calling downHeap n/2 times
    public void heapify(T[] arr){
        //heapify the unsorted array
        heap = new ArrayList<>();
        for(T t : arr){
            heap.add(t);
        }
        for(int i = heap.size() / 2 - 1; i >= 0; i--){
            downHeap(i);
        }
    }
}
