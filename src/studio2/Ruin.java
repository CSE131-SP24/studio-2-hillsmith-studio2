package studio2;
import java.util.Scanner;
public class Ruin {

	private static final String ExpectedRuinRate = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Starting amount of $");
		int startAmount = in.nextInt();
		System.out.println("The win probability of a single play (in terms of percent)");
		double winChance = in.nextDouble();
		System.out.println("The amount of money you need to leave the casino");
		int winLimit = in.nextInt();
		System.out.println("How many simulations?");
		int totalSimulations = in.nextInt();
		int Cash = startAmount;
		int Ruins = 0;
		int Sucesses = 0;
		while (totalSimulations != 0)
		{
			while (Cash > 0 && Cash < winLimit)
			{
				int x = (int)(Math.random()*100 + 1);
				if (x <= winChance)
				{
					Cash++;
				}
				else 
				{
					Cash--;
				}
			
			}
			if (Cash == 0)
			{
				Ruins ++;
				totalSimulations --;
				Cash = startAmount ;
			}
			else
			{
				Sucesses ++;
				totalSimulations --;
			Cash = startAmount ;
					}
		}
		double Ruinrate =  (Ruins / (Ruins + Sucesses))*100;
		if (winChance == 0.5)
			{
			double ExpectedRuinRate = (1-(startAmount/winLimit));
			System.out.println("Expected Ruin Rate : "+ExpectedRuinRate+"%");
			}
		else
			{double alpha = (1-winChance)/winChance;
			double ExpectedRuinRate = (100*(Math.pow(alpha,(double)startAmount))-Math.pow(alpha, (double)winLimit))/(1-Math.pow(alpha, winLimit));
			System.out.println("Expected Ruin Rate : "+ExpectedRuinRate+"%");	
	}
		
		System.out.println("Ruinrate = " + Ruinrate + "%" );
		
	}

}
