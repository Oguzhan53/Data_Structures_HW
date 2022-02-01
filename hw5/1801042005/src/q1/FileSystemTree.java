package q1;
import java.util.*;

 
/**
 * This is File system tree class.
 * @author Oguzhan SEZGIN
 *
 */
public class FileSystemTree {

	private FileNode root;
	private int nodeSize;
	
	public FileSystemTree(String root) {
		this.root=new FileNode(root, 1,root);
	}
	public FileNode getRoot() {
		return root;
	}
	public void setRoot(FileNode root) {
		this.root = root;
	}
	public int getNodeSize() {
		return nodeSize;
	}
	public void setNodeSize(int nodeSize) {
		this.nodeSize = nodeSize;
	}
	
	/**
	 * This method adds directory to tree
	 * @param directory Directory name which will add
	 * @return if it succeeds return 0 else -1
	 */
	public int addDir(String directory) {
		String del="[/]";
		String[] keys=directory.split(del);
		FileNode iter = new FileNode("temp",1,directory);
		if(!(root.getNodeName().equals(keys[0]))) {
			System.out.println("Wrong root ");
			return -1;
		}
		iter = root;
		
		for(int i=1;i<keys.length;i++) {
			List <FileNode> tlist=iter.getChildRoots();
			if(i==keys.length-1) {
				tlist=iter.getChildRoots();
				tlist.add(new FileNode(keys[i], 1,directory));
				//System.out.println("ekledi "+keys[i]);
				break;
			}
			int i1;
			for(i1=0; i1<tlist.size(); i1++) {
				
				if(tlist.get(i1).getNodeName().equals(keys[i])) {
					iter=tlist.get(i1);
					break;
				}
			}
			if(i1==tlist.size()) {
				System.out.println("Wrong Directory !!!");
				return -1;
			}
			
		}
		return 0;
	}

	/**
	 * This method adds File to tree
	 * @param file File name which will add
	 * @return If it succeeds return 0 else -1
	 */
	public int addFile(String file) {
		
		String del="[/]";
		String[] keys=file.split(del);
		FileNode iter = new FileNode("temp",1,file);
		if(!(root.getNodeName().equals(keys[0]))) {
			System.out.println("Wrong root ");
			return -1;
		}
		iter = root;
		
		for(int i=1;i<keys.length;i++) {
			List <FileNode> tlist=iter.getChildRoots();
			if(i==keys.length-1) {
				
				List<String> flist=iter.getFileNames();
				flist.add(keys[i]);
				
				break;
			}
			int i1;
			for(i1=0; i1<tlist.size(); i1++) {
				
				if(tlist.get(i1).getNodeName().equals(keys[i])) {
					iter=tlist.get(i1);
					break;
				}
			}
			if(i1==tlist.size()) {
				System.out.println("Wrong Directory !!!");
				return -1;
			}
			
		}
		return 0;
		
	}
	
	/**
	 * This method remove file or directory
	 * @param data data which will remove
	 * @return If it succeeds return 0 else -1
	 */
	public int remove(String data) {
		if(data.equals(this.getRoot().getNodeName())) {
			System.out.println("Root can not remove!!!");
			return -1;
		}
		else if(this.getRoot().getChildRoots().isEmpty()) {
			System.out.println("There is no directory or file!!!");
			return-1;
		}
		String del="[/]";
		String[] keys=data.split(del);
		FileNode iter = new FileNode("temp",1,data);
		if(!(root.getNodeName().equals(keys[0]))) {
			System.out.println("There is no this name directory or file");
			return -1;
		}
		iter = root;
		
		for(int i=1;i<keys.length;i++) {
			List <FileNode> tlist=iter.getChildRoots();
			if(i==keys.length-1) {

				tlist=iter.getChildRoots();
				int i2;
				for( i2=0;i2<tlist.size();i2++) {
					if(tlist.get(i2).getNodeName().equals(keys[i])) {
						if(tlist.get(i2).getFileNames().isEmpty() && tlist.get(i2).getChildRoots().isEmpty())
							tlist.remove(i2);
						else {
							@SuppressWarnings("resource")
							Scanner scan =new Scanner(System.in);
							System.out.println("\n\" "+data+" \" directory contains below elements.Do you want to remove"
									+ "this directory ?(Y/N)\n");
							print(tlist.get(i2));
							String decision=scan.nextLine();
							if(decision.equalsIgnoreCase("y"))
								tlist.remove(i2);
							else
								System.out.println("Did not remove");
							
							
						}
						break;
					}
				}
				if(i2==tlist.size()) {
					System.out.println("Wrong Directory .Program can not delete !!!");
					return -1;
				}
				
				break;
			}
			int i1;
			for(i1=0; i1<tlist.size(); i1++) {
				
				if(tlist.get(i1).getNodeName().equals(keys[i])) {
					iter=tlist.get(i1);
					break;
				}
			}
			if(i1==tlist.size()) {
				System.out.println("Wrong Directory .Program can not delete !!!");
				return -1;
			}
			
		}
		return 0;
		
	}

	
	/**
	 * This method search file or directory recursively and print screen to their path
	 * @param root Searched roots
	 * @param name File or directory name which will search
	 */
	private void search_iter(FileNode root,String name) {
		if(root==null || root.getNodeName().equals(name) || root.getFileNames().contains(name)) {
			if(root!=null ) {
				if(root.getFileNames().contains(name))
					System.out.print("file - ");
				else
					System.out.print("dir - ");
				System.out.println(root.getDirectory());
			}
				
			}
		
			for(int i=0;i<root.getChildRoots().size();i++) {
				 search_iter(root.getChildRoots().get(i), name);
			}
			
		//}
		
	}
	
	/**This method search file or directory with call search_iter method
	 * @param name Name which will search
	 */
	public void search(String name) {
		search_iter(this.getRoot(), name);
	}
	
	/**This function print tree with preorder traverse method
	 * @param root Printed roots
	 */
	private void print(FileNode root) { 
		if(root!=null ){
			System.out.print(root.getNodeName()+"(d) ");
			for(String str:root.getFileNames())
				System.out.print(str+"(f) ");
		
		}
		
		
		for(int i=0;i<root.getChildRoots().size();i++) {
			 print(root.getChildRoots().get(i));
			 
		}
			
		
	}
	
	/**
	 * This function prints tree with call print method
	 */
	public void printFileSystem() {  
		this.print(this.getRoot());
	}

}


