
package q1;

/**
 * This is main class
 * @author Oguzhan SEZGIN-1801042005
 *
 */
public class Main {

	public static void main(String[] args) {
		
		
		FileSystemTree fs=new FileSystemTree("root");
		
		//------------------ ADD-REMOVE TEST -----------------------------
		fs.addDir("root/dir1");
		fs.addFile("root/dir1/F1.txt");
		fs.addDir("root/dir1/dir2");
		fs.addFile("root/dir1/dir2/F2.txt");
		fs.addFile("root/dir1/dir2/F3.txt");
		fs.addFile("root/dir1/dir2/F4.txt");
		fs.addDir("root/dir1/dir2/dir7");
		fs.addDir("root/dir1/dir3");
		fs.addFile("root/dir1/dir3/F5.txt");
		fs.addDir("root/dir1/dir3/dir4");
		fs.addDir("root/dir1/dir3/dir4/F6");
		fs.addDir("root/dir1/dir5");
		fs.addDir("root/dir6");
		fs.addFile("root/dir6/F2.txt");
		
		fs.search( "F2.txt");
		
		System.out.println("-------Before remove-------------");
		fs.printFileSystem();
		System.out.println("");
		fs.remove("root/dir1/dir3");
		System.out.println("-------After remove-------------");
		fs.printFileSystem();
		
		/*
		//-------------------SEARCH TEST --------------------
		fs.addDir("root/dir1");
		fs.addFile("root/dir1/F1.txt");
		fs.addDir("root/dir1/dir2");
		fs.addFile("root/dir1/dir2/F2.txt");
		fs.addFile("root/dir1/dir2/F3.txt");
		fs.addFile("root/dir1/dir2/F4.txt");
		fs.addDir("root/dir1/dir2/dir7");
		fs.addDir("root/dir1/dir3");
		fs.addFile("root/dir1/dir3/F5.txt");
		fs.addDir("root/dir1/dir3/dir4");
		fs.addDir("root/dir1/dir3/dir4/F6");
		fs.addDir("root/dir1/dir5");
		fs.addDir("root/dir6");
		fs.addFile("root/dir6/F2.txt");
		System.out.println("-------------F2.txt search-------------");
		fs.search( "F2.txt");
		System.out.println("-------------dir2.txt search-------------");
		fs.search( "dir2");
		
		*/
		/*
		//--------------------- EXCEPTION TEST -----------------------
		System.out.println("-----------Empty tree remove test-----------");
		fs.remove("d3");
		fs.addDir("root/dir1");
		fs.addFile("root/dir1/F1.txt");
		fs.addDir("root/dir1/dir2");
		fs.addFile("root/dir1/dir2/F2.txt");
		System.out.println("-----------F3.txt remove test-----------");
		fs.remove("F3.txt");
		System.out.println("-----------Root remove test-----------");
		fs.remove("root");
		System.out.println("-----------Add file to directory test-----------");
		fs.addDir("root/dir1/F1.txt/F4.txt");
		*/
	}

}
