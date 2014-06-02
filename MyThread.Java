package yammy.main;

public class MyThread implements Runnable {
	private final String Name;//so you cant change the Name
	public MyThread(String taskName) {
		Name = taskName;//sets name
	}

	public void run(){
		long sum = 0;
		Dice dice = new Dice();//new dice object
		sum=dice.roll();//rolls dice
		System.out.println("dice "+Name+" landed on "+sum);//prints name + value
	}
}
