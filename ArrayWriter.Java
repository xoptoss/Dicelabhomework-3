package yammy.main;

public class ArrayWriter implements Runnable {

	private final SimpleArray simpleArray;
	private final int startValue;

	public ArrayWriter(int value , SimpleArray array)
	{
		startValue = value;
		simpleArray = array;
	}//constructor


	public void run() {
		for( int i = startValue ; i < startValue + 3; i++)
		{
			simpleArray.add(i);//add element to shared array
		}
	}

}
