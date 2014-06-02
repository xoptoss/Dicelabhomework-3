package yammy.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{

	private static final ExecutorService executor = null;

	public static void main(String[] args) {
		SimpleArray array = new SimpleArray(9);
		DiceRoller[] Roller = new DiceRoller[3];//makes 3 dice rollers
		Dice dice = new Dice();
		for(int i = 0; i<Roller.length;i++)
		{
			//create task with array
			Roller[i]= new DiceRoller("Task"+i,dice.roll() ,array);	
		}

		System.out.println("Starting executor");
		ExecutorService TE = Executors.newCachedThreadPool();

		for(int i = 0;i<Roller.length;i++){
			//execute with array
			TE.execute (Roller[i]);
		}	
		TE.shutdown();//closes it
		System.out.println("Task started, main ended.\n");
		try{
			boolean tasksEnded = executor.awaitTermination(1,TimeUnit.MINUTES);
			if(tasksEnded)
			{
				System.out.println(array);
			}
			else
				System.out.println("Timed out while waiting for task");
		}
		catch(InterruptedException ex)
		{
			System.out.println("Interrupted while wating for task");
		}
	}
}

// Good job, but SimpleArray array = new SimpleArray(9); should be in the Dice class...see slide #43-52 of W15 part 2.
