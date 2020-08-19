package structures;

import java.util.Comparator;
import java.util.Iterator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
  
  public StudentArrayHeap(Comparator<P> comparator){
    super(comparator); 
  }

  @Override
  public int getLeftChildOf(int index){
    if(index < 0){
      throw new IndexOutOfBoundsException();
    }
    int leftIndex = (index * 2) + 1;
    return leftIndex; 
  }

  @Override
  public int getRightChildOf(int index){
    if (index < 0){
      throw new IndexOutOfBoundsException();
    }
    int rightIndex = (index * 2) + 2;
    return rightIndex; 
  }

  @Override
  public int getParentOf(int index){
    if (index < 1){
      throw new IndexOutOfBoundsException();
    }
    int parentIndex = (index - 1)/2;
    return parentIndex; 
  }

  @Override
  public void bubbleUp(int index){
    int parentIndex = (index - 1)/2; 
    if(parentIndex < 0){
      return;  
    }
    if(getComparator().compare(heap.get(index).getPriority(),heap.get(parentIndex).getPriority()) > 0){
      swap(index,parentIndex);
      bubbleUp(parentIndex);
    } else{
      return; 
    }
  }

  @Override
  public void bubbleDown(int index) {
    int leftChildIndex = (index * 2) + 1;
    int rightChildIndex = (index * 2) + 2;
    int largerChildIndex = leftChildIndex;
    if (leftChildIndex < this.size()) {

      if (rightChildIndex < this.size() && getComparator().compare(heap.get(leftChildIndex).getPriority(),
          heap.get(rightChildIndex).getPriority()) < 0) {
        largerChildIndex = rightChildIndex;
      }
      if (getComparator().compare(heap.get(index).getPriority(), heap.get(largerChildIndex).getPriority()) < 0) {
        swap(largerChildIndex, index);
        bubbleDown(largerChildIndex);
      }

    }

  }

  public Iterator<Entry<P,V>> iterator(){
    return heap.iterator(); 
  }

}
