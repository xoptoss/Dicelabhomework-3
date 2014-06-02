package yammy.main;

public class DiceRoller implements Runnable {

	private final String taskName;//so you cant change the name
	private final SimpleArray simpleArray;
	private final int startValue;
	public DiceRoller(String name,int Value ,SimpleArray array)
	{
		taskName = name; //sets taskName
		startValue = Value;//value
		simpleArray = array;//makes array
	}

	public void run() {		
		//try catch
		try{
			for(int i = 0; i < 3; i++){
				System.out.printf("%s Starto\n",taskName);
				Runnable T1 = new MyThread(taskName);//make new thread 
				Thread worker = new Thread(T1);
				worker.setName(taskName);//set name
				worker.start();//starto
				simpleArray.add(i);
			}
		}
		catch(Exception e)
		{
			System.out.printf("%s %s\n",taskName,"terminated prematurely due to interruption");
		}
		//when its done
		System.out.printf("%s done Throwing\n",taskName);
	}

}
