
public class GuitarString {
	
		private RingBuffer stringBuffer;
		//instance variable
		
		// the length of our buffer
		private int b_Length;
		
		// the amount of time (in 'tics')
		private int time;
		
		// Sampling rate to use for this simulation sampling rate
		private int sampling_rate = 44100;
		
		// constant for they wave decay function
		private double energy_decay_factor  = 0.994;
	
	
	// constructor

	/**
	 * create a guitar string of the given frequency, using a sampling rate of 44,100
	 * @param frequency double 
	 */
	public GuitarString(double frequency){
			time = 0;
			int length = (int)(sampling_rate / frequency);
			b_Length = length;
			stringBuffer = new RingBuffer(length);
			
			// create a RingBuffer filled with 0s.
			while(!stringBuffer.isFull())
				stringBuffer.enqueue(0.0);
	}
	/**
	 * 	// create a guitar string whose size and initial values are given by the array
	 * @param init[] double
	 */
	public GuitarString(double[] init){   
		time = 0;
		stringBuffer = new RingBuffer(init.length);
		
		// set the buffer to initial values given in init
		for(int i = 0; i < init.length; i++)
		{
			stringBuffer.enqueue(init[i]);
		}
	
	}

	// instance methods
	/**
	 * 
	 * replace all items in the ring buffer with N random values between -0.5 and +0.5.
	 */
	public void pluck() {  
		// check if the stringBuffer is empty and if not dequeue
		     while(!stringBuffer.isEmpty()) {
		    	 stringBuffer.dequeue();
		     }
		     
		  // find a random value in [0.5-0.5) and queue it
			for(int i = 0; i < b_Length; i++){
				double k = Math.random() - 0.5;
				stringBuffer.enqueue(k);
		}
	}
	/**
	 * advance the simulation one time step
	 */
	public void tic() { 
		// dequeue the buffer and peek it to find the average of the two values
				double first = stringBuffer.dequeue();
				double second = sample();
				// equation from the assignment website
				stringBuffer.enqueue(energy_decay_factor * (first + second) / 2 );
				// increment the time
				time++;
	}
	/**
	 * return the current sample
	 * @return  current sample
	 *
	 */
	public double sample() {
		
		return stringBuffer.peek();                       
	
	}
	
	/**
	 * return number of tics
	 * @return
	 */
	int time() {
		return time;                        
	
	}
}
