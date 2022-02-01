package q2;

import java.io.*;
//import java.io.FileNotFoundException;
//import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * This is main class.
 * @author Oguzhan SEZGIN 1801042005
 * 
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		
			
		
		
		
	    Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  

	    try {  

	    	String logger_path="C:\\Users\\mance\\OneDrive\\Masaüstü\\gtu-lessons\\bahar\\data-struct\\hw3\\log_file.log";
	        fh = new FileHandler(logger_path);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  
	        
	        
	        

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    
		 //---------------------------- SYSTEM TESTING ----------------------------
		
		SimpleTextEditor text= new SimpleTextEditor("ArrayList");
		SimpleTextEditor text1= new SimpleTextEditor("ArrayList");
		long start,finish,timeElapsed;
		try {
			String path="C:\\Users\\mance\\OneDrive\\Masaüstü\\gtu-lessons\\bahar\\data-struct\\hw3\\text.txt";
			File file = new File(path);
			
			
			logger.info("--------------- TEST READ (WITH ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text.Read(file,logger);
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			logger.info("--------------- TEST READ (WITHOUT ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text1.Read(file,logger);
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			
			logger.info("--------------- TEST FIND (WITH ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text.Find("best", logger);
			text.Find("outside", logger);
			text.Find("longest", logger);
			
			
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			
			logger.info("Working time : "+timeElapsed+" ns");
			logger.info("--------------- TEST FIND (WITHOUT ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			
			text1.Find_without_iter("best", logger);
			text1.Find_without_iter("outside", logger);
			text1.Find_without_iter("longest", logger);
			
			
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			logger.info("--------------- TEST ADD (WITH ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text.Add(1, "vocabluary", logger);
			text.Add(0, "data", logger);
			text.Add(13, "structures", logger);
			
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			logger.info("--------------- TEST ADD (WITHOUT ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text1.Add_without_iter(10, "vocabluary", logger);
			text1.Add_without_iter(0, "data", logger);
			text1.Add_without_iter(13, "structures", logger);
			
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			logger.info("--------------- TEST REPLACE (WITH ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text.Replace(10,"replace", logger);
			text.Replace(0,"some", logger);
			text.Replace(20,"character", logger);
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			logger.info("--------------- TEST REPLACE (WITHOUT ITERATOR) METHODS  ---------------");
			start = System.nanoTime();
			text1.Replace_without_iter(10,"replace", logger);
			text1.Replace_without_iter(0,"some", logger);
			text1.Replace_without_iter(20,"character", logger);
			finish =  System.nanoTime();
			timeElapsed = finish - start;
			logger.info("Working time : "+timeElapsed+" ns");
			
			/*
			text.Read(file,logger);
			//---------------------------- ADD METHOD TESTING ----------------------------
			
			
			text.Add(10, "some", logger);
			text.Add(100, "addelelement", logger);
			
			//---------------------------- FIND METHOD TESTING ----------------------------
			
			text.Find("thousands", logger);
			text.Find("noelement", logger);
			
			//---------------------------- REPLACE METHOD TESTING ----------------------------
			
			text.Replace_without_iter(1,"tryreplace", logger);
			text.Replace_without_iter(1000,"bigindexnumber", logger);
			*/
		
		
		
		}
		catch(FileNotFoundException e) {
			System.out.println("Wrong Path");
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Index out of size");
		}
		logger.info("Program is end");  
		text.print_list();
		
		
	}

}
