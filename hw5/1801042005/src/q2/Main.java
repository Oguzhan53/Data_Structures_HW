package q2;

import java.util.*;
/**This is main class
 * @author Oguzhan SEZGIN - 1081042005
 *
 */
public class Main {

	
	
	public static void main(String[] args) {
		
		try {
			
			//----------------------EVALUATION TEST ---------------------
			ExpressionTree expt = new ExpressionTree("+ + 10 * 5 15 20");
			ExpressionTree expt2 = new ExpressionTree("+ - 100 / 5 15 20");
			ExpressionTree expt3 = new ExpressionTree("10 2 8 * + 3 - ");
			ExpressionTree expt4 = new ExpressionTree("4 55 + 62 23 - / ");
			System.out.println("-------------Evaluation -------------");
			System.out.println(expt.eval());
			System.out.println(expt2.eval());
			System.out.println(expt3.eval());
			System.out.println(expt4.eval());
			System.out.println("-------------toString2 -------------");
			System.out.println(expt.toString2());
			System.out.println(expt2.toString2());
			System.out.println(expt3.toString2());
			System.out.println(expt4.toString2());
			System.out.println("-------------toString -------------");
			System.out.println(expt.toString());
			System.out.println(expt2.toString());
			System.out.println(expt3.toString());
			System.out.println(expt4.toString());
			
			//----------------EXCEPTÝON TEST ---------------------
			/*
			ExpressionTree expt = new ExpressionTree("+ + 10 * 5 15a 20");
			System.out.println(expt.eval());
			*/
			
		} 
		catch (InputMismatchException  e) {
			System.out.println("Invalid input !!!");
		}
		catch (NoSuchElementException  e) {
			System.out.println("Missing char  !!!");
		}
		
	}

}
