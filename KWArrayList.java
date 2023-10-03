import java.util.Arrays;
import java.util.Iterator;
import java.util.AbstractList;

/**
 * This class implements some of the methods of the Java
 *  ArrayList class.
 *  @author Koffman, Wolfgang, &DB
 */
public class KWArrayList<E>  
{
	// Data Fields

	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	/** The underlying data array */
	private E[] theData;
	/** The current size */
	private int size = 0;
	/** The current capacity */
	private int capacity = 0;

	/**
	 * Construct an empty KWArrayList with the default
	 * initial capacity
	 */
	public KWArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}


	/**
	 * Appends the specified element to the end of this list.
	 * @param anEntry - element to be appended to this list
	 */
	public boolean add(E anEntry) {
		if (size == capacity) {
			reallocate();
		}
		theData[size] = anEntry;
		size++;
		return true;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts 
	 * any subsequent elements to the left (subtracts one from their indices).
	 * @param index - The index of the entry to be removed
	 * @return the element that was removed from the list
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) {
			theData[i - 1] = theData[i];
		}
		size--;
		return returnValue;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - The index of the item returned
	 * @return the element at the specified position in this list
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}


	/**
	 * Get the current size of the array
	 * @return The current size of the array
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns a string representation of this collection. The string 
	 * representation consists of a list of the collection's elements 
	 * order, enclosed in square brackets ("[]"). Adjacent elements 
	 * are separated by the characters ", "  (comma and space).  
	 * This is the string representation returned by Java's ArrayList	 
	 * @return a string representation of the collection
	 */ 
	public String toString(){
		StringBuilder s = new StringBuilder("[");
		for (int i=0; i<size-1; i++){
			s.append(theData[i]+", ");
		}
		if (size>0)
			s.append(theData[size-1]);
		s.append("]");
		return s.toString();
	}

	/**
	 * Allocate a new array to hold the directory
	 */
	private void reallocate() {
		capacity = 2 * capacity;
		theData = Arrays.copyOf(theData, capacity);
	}



	/**************************************************************/
	/**************Implement The Following Methods ****************/
	/**************************************************************/

	/**
	 * Construct an empty KWArrayList with a specified initial capacity
	 * @param capacity The initial capacity
	 */
	public KWArrayList(int capacity) {
        this.capacity = capacity;
		theData = (E[]) new Object[capacity];
	}


	/**
	 * Removes all of the elements from this list (optional operation). 
	 * The list will be empty after this call returns.
	 */
	public void clear() {
		for(int i = 0; i < size; i++){
			theData[i] = null;
		}
		size = 0;
	}


	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 * @param index - The index of the item to replace
	 * @param newValue - The new value to store at this position
	 * @return the element previously at the specified position
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E set(int index, E newValue) {
		if(index > size) throw new ArrayIndexOutOfBoundsException();
		else if(index == size) size++;
		theData[index] = newValue;
		return newValue;
	}


	/**
	 * Inserts the specified element at the specified position in 
	 * this list. Shifts the element currently at that position 
	 * (if any) and any subsequent elements to the right 
	 * (adds one to their indices).
	 * @param index -  index at which the specified element is to 
	 *                 be inserted
	 * @param theValue - The value to be inserted
	 * @throws ArrayIndexOUtOfBoundsException if index is
	 *         less than zero or greater than size
	 */
	public boolean add(int index, E anEntry) {
		if(index < 0 || index > size) throw new ArrayIndexOutOfBoundsException();
		size++;
		E item = (E) theData[index];
		set(index, anEntry);
		for(int i = index + 1; i < size; i++){
			E temp = (E) theData[i];
			set(i, (E) item);
			item = temp;
		}
		return true;
	} 


	/**
	 * Returns the index of the first occurrence of the specified element 
	 * in this list, or -1 if this list does not contain the element.  
	 * @param element to search for
	 * @return the index of the first occurrence of the specified element 
	 *       in this list, or -1 if this list does not contain the element
	 */
	public int indexOf(E item) {
		for(int i = 0; i < this.size; i++){
			if(theData[i].equals(item)) return i;
		}
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 * @param item - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(E item) {		 
		for(int i = 0; i < this.size; i++){
			if(theData[i].equals(item)) return true;
		}
		return false;
	}


	/**
	 * Returns true if this list contains no elements and false otherwise.
	 * @return true if this list contains no elements and false otherwise.
	 */
	public boolean isEmpty() {		 
		return (size > 0);
	}


	/**
	 * Returns the index of the last occurrence of the specified 
	 * element in this list, or -1 if this list does not contain the 
	 * element.  
	 * @param item element to search for
	 * @return the index of the last occurrence of the specified element in 
	 * 		this list, or -1 if this list does not contain the element
	 */
	public int lastIndexOf(E item) {		 			
		for(int i = size - 1; i >= 0; i--){
			if(theData[i].equals(item)) return i;
		}
		return -1;
	}

	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present. If the list does not contain the element, it is unchanged.
	 * @param item - element to be removed from this list, if present
	 * @return true if item is found and removed; otherwise, return false.
	 */
	public boolean remove(E item) {    	 
		for(int i = 0; i < this.size; i++){
			if(theData[i].equals(item)){
				for(int j = i + 1; j < size; j++){
					theData[i] = theData[j];
					i++;
				}
				size--;
				return true;
			}
		}
		return false;
	}
}
