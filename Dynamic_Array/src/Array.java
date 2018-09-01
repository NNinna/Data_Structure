

public class Array<E> {

	private E[] data;
	private int size = 0;
	private static final int CAPACITY = 10;
    

    public Array(int capacity){
    	data = (E[]) new Object[capacity];
    }


    public Array(){
    	data = (E[]) new Object[CAPACITY];
    }

   
    public int getCapacity(){
       return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
       return size;
    }

    /**
     * Return if array is empty.
     * @return
     */
    public boolean isEmpty(){
    	return size == 0;
    }

    /**
     * Add an element at specific place.
     * @param index
     * @param e
     */
    public void add(int index, E e){
  
    	if (index < 0 || index > size) {
    		throw new IllegalArgumentException();
    	}
    	if (size == data.length) {
    		resize(data.length * 2);
    	}
    	
    	for (int i = size; i > index; i--) {
    		data[i] = data[i - 1];
    	}
    	data[index] = e;
    	size ++;
    }
    
    public void addFirst(E e) {
    	add(0, e);
    }
    
    public void addLast(E e) {
    	add(size, e);
    }


    /**
     * Return the element at specific index.
     * @param index
     * @return
     */
    public E get(int index){
      if (index < 0 || index >= size) {
    	  throw new IllegalArgumentException();
      }

      return data[index];
    }

    /**
     * Modified the element at specific index with e.
     * @param index
     * @param e
     */
    public void set(int index, E e){
    	if (index < 0 || index >= size) {
    		throw new IllegalArgumentException("index is out of boundary");
    	}
    	data[index] = e;
    	
    }

    /**
     * Check if array contains the specific element.
     * @param e
     * @return
     */
    public boolean contains(E e){
      for (int i = 0; i < size; i++) {
    	  //这边注意用equal别计较
    	  if (data[i].equals(e)) {
    		  return true;
    	  }
      }
      return false;
    }

    /**
     * Return the index of Element e.
     * @param e
     * @return
     */
    public int indexOf(E e){
      for (int i = 0; i < size; i++) {
    	  if (data[i].equals(e)) {
    		  return i;
    	  }
      }
      return -1;
    }
    /**
     * remove the element at specific index.
     * @param index
     * @return
     */
    public E remove(int index){
    	
    	if (index < 0 || index >= size) {
    		throw new IllegalArgumentException("Index is out of boundary");
    	}
    	E value = data[index];
    	for (int i = index; i < size - 1; i++) {
    		data[i] = data[i+1];
    	}
    	data[size - 1] = null;
    	size--;
    	
    	if (size == data.length / 4 && data.length / 2 != 0) {
    		resize(data.length / 2);
    	}
    	
    	return value;
    }

    
    /**
     * Delete the specific element in array.
     * @param e
     */
    public void removeElement(E e){
       int index = indexOf(e);
       if (index == -1) {
    	   throw new IllegalArgumentException("cannot find element");
       }
       remove(index);
    }
    public void removeFirst () {
    	remove (0);
    }
    
    public void removeLast () {
    	remove(size - 1);
    }
    
    @Override
    public String toString(){
    	StringBuilder builder = new StringBuilder();
    	for (int i = 0; i < size; i++) {
    		builder.append(data[i].toString());
    		builder.append(",");
    	}
    	return builder.toString();
    }

    /**
     * Resize the array with an assigned index.
     * @param newCapacity
     */
    private void resize(int newCapacity){
    	E[] arr = (E[]) new Object[newCapacity];
    	
    	for (int i = 0; i < size; i++) {
    		arr[i] = data[i];
    	}
    	data = arr;
    }
}

