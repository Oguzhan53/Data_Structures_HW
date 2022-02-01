package q4;

/**
 * This main class.
 * @author Oguzhan SEZGIN - 1801042005
 *
 */
public class Main {

	public static void main(String[] args) {
		MaxHeap heap=new MaxHeap();
		
		try {
			heap.add(new AgeData(10));
			heap.add(new AgeData(5));
			heap.add(new AgeData(70));
			heap.add(new AgeData(10));
			heap.add(new AgeData(50));
			heap.add(new AgeData(5));
			heap.add(new AgeData(15));
			
			
			//---------------YOUNGER - OLDER AGE TEST ---------------------
			System.out.println(heap.youngerThan(16));
			System.out.println(heap.olderThan(10));
			
			System.out.println(heap.toString());
			
			
			
			/*
			//-------------------EXCEPTION TEST ------------------
			System.out.println("Does not exist age remove");
			heap.remove(100);
			System.out.println("Does not exist age find");
			System.out.println(heap.find(new AgeData(150)).toString());
			*/
			
			/*
			//-------------------FIND TEST----------------------------
			System.out.println(heap.find(new AgeData(10)).toString());
			System.out.println(heap.find(new AgeData(70)).toString());
			*/
			
			
			
			
			/*
			//-------------PRINT TEST -----------------
			System.out.println(heap.toString());
			*/
			
			
			
		}
		catch (Exception e) {
			System.out.println("There is no this number age in tree");
		}
	}

}
