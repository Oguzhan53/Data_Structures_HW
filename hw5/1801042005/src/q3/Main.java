package q3;

import q3.BinarySearchTree.AgeData;

public class Main {

	public static void main(String[] args) {
	
		try {
			
			//----------------ADD -------------------
			AgeSearchTree age = new AgeSearchTree();
			age.add(new AgeData(10));
			age.add(new AgeData(21));
			age.add(new AgeData(20));
			age.add(new AgeData(16));
			age.add(new AgeData(5));
			age.add(new AgeData(11));
			age.add(new AgeData(12));
			age.add(new AgeData(12));
			age.add(new AgeData(10));
			age.remove(12);
			age.remove(21);
			
			
			
			//----------------FIND TEST -------------------
			System.out.println("Find and tostring 12");
			System.out.println(age.find(new AgeData(12)));
			System.out.println("Find and tostring 16");
			System.out.println(age.find(new AgeData(16)));		
					
			
			
			
			/*
			//----------------EXCEPTION TEST -------------------
			
			System.out.println("Remove not exist age");
			age.remove(53);
			System.out.println("Find not exist age");
			System.out.println(age.find(40).toString());
			
			*/
			
			//----------------PRINT TEST -------------------
			//	System.out.println(age.toString());
			
			
			
			
			
			
		
			
			
			
			
		}
		
		
		catch (Exception e) {
			System.out.println("There is no this number age");
		}
		
		
		
		
	
		
	
	}

}
