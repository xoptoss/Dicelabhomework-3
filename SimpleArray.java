package yammy.main;

import java.util.Arrays;
import java.util.Random;

public class SimpleArray {

	private final int[] array;
	private int writeIndex = 0;
	private final static Random random = new Random();

	public SimpleArray(int size){//constructor
		array = new int[size];
	}
	public void add( int value )
	{
		int position = writeIndex;

		try{//Thread go to sleep
			Thread.sleep(random.nextInt(500));
		}catch ( InterruptedException e)
		{
			e.printStackTrace();
		}

		array[position] = value;//value go in that spot :^)
		System.out.printf("%s wrote %2d to element %d. \n",
				Thread.currentThread().getName(),value,position);
		++writeIndex;
	}
	public String toString()
	{
		return "\nContents of SimpleArray:\n" + Arrays.toString( array );
	}
}
