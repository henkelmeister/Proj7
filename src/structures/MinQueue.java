package structures;

import comparators.ReverseIntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
  
  private ReverseIntegerComparator revIntComparitor;
  private StudentArrayHeap<Integer,V> stuArrHeap;
  
  public MinQueue(){
    revIntComparitor = new ReverseIntegerComparator();
    stuArrHeap = new StudentArrayHeap<Integer,V>(revIntComparitor);
  }
  
  @Override
  public PriorityQueue<Integer, V> enqueue(Integer priority, V value){
    if(priority == null || value == null) throw new NullPointerException();
    else{
      stuArrHeap.add(priority,value);
      return this;
    }
  }

  @Override
  public V dequeue(){
    if(isEmpty()) throw new IllegalStateException(); 
    else{
      return stuArrHeap.remove(); 
    }
  }

  @Override
  public V peek(){
    if(isEmpty()) throw new IllegalStateException(); 
    else{
      return stuArrHeap.peek(); 
    }
  }

  @Override
  public Iterator<Entry<Integer, V>> iterator(){
    return stuArrHeap.asList().iterator(); 
  }

  @Override
  public Comparator<Integer> getComparator(){
    return revIntComparitor; 
  }

  @Override
  public int size(){
    return stuArrHeap.size(); 
  }

  @Override
  public boolean isEmpty(){
    return (this.size() == 0); 
  }
}
