package structures;

import comparators.IntegerComparator;

import java.util.Comparator;
import java.util.Iterator;



public class MaxQueue<V> implements PriorityQueue<Integer, V> {

  private IntegerComparator intComparitor;
  private StudentArrayHeap<Integer,V> stuArrHeap;
  
  public MaxQueue(){
    intComparitor = new IntegerComparator();
    stuArrHeap = new StudentArrayHeap<Integer,V>(intComparitor);
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
    return intComparitor; 
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
