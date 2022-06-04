
public class RingBuffer {
	
	
	// instance variables
	private double[] ringbuffer;
	private int cap_max;
	private int size;
	private int first;
	private int last;
	
	/**
	 *  Initializes a newly created ringbuffer array  with a size of capacity and set the size to zero and first to zero
	 * @param int capacity
	 */
	// constructor
	public RingBuffer(int capacity) {
		ringbuffer = new double[cap_max];
		
		cap_max = capacity;
		size = 0;
		
		first =0;
		last = first;
	}
	// instance methods
	/**
	 * It get the size of the array 
	 * @return number of items currently in the buffer
	 */
	// instance methods
	public int size() {
		return size;
	}
	// is the buffer empty (size equals zero)?
	/**
	 *  Return a boolean and check if the size is zero to see if the buffer isempty
	 * @return boolean 
	 */
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}
	// is the buffer full  (size equals capacity)?
	/**
	 *  Return a boolean by checking if the size equal to capacity
	 * @return
	 */
	public boolean isFull() {
		if(size==cap_max) {
			return true;
		}
		return false;
	}
	
	// add item x to the end
	/**
	 *  add item x to the end
	 * @param x
	 */
	public void enqueue(double x) {
		//double[] b = new double[(2 * size)];
		if(isFull())
    	{
    		throw new RuntimeException("The ring buffer is full!");
    	}
    	
    	else {
    		
    		int pos = (first+size)% ringbuffer.length;
    		
    		ringbuffer[pos] =  x;
    		size++;
        	
        	
    	}
		
		
        
    }
	/**
	 * delete and return item from the front
	 * @return 
	 */
	 public double dequeue() {  
		    // check if it is empty 
	    	if(isEmpty())
	    	{
	    		throw new RuntimeException("The ring buffer is empty!");
	    	}else {
	    	
	        // store the value in the buffer at current position
	        double item = ringbuffer[first];
	        
	        first = (first+1)%ringbuffer.length;
	        // decrease the size of the buffer and return the value
	        size--;
	        return item;
	        }
		 
	 }
	// return (but do not delete) item from the front
	 public double peek()  {         
		 
		 if(isEmpty())
	    		throw new RuntimeException("The ring buffer is empty!");
	    	
	    	// simply return the first position of the buffer
	    	return ringbuffer[first];
		 
	 }
	
	

}
