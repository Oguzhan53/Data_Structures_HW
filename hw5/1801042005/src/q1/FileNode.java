package q1;
import java.util.*; 
/**
 * This is class holds files and directoies
 * @author Oguzhan SEZGÝN 1801042005
 *
 */
public class FileNode {

	private List<String> fileNames;
	private int mark ; 
	private String nodeName;
	private String directory;
	private List<FileNode> childRoots;
	
	/**
	 * Parameter constructor
	 * @param name Node name 
	 * @param mark Node flag (if mark is 1 node is directory or else node is file )
	 * @param directory Directory name
	 */
	public FileNode(String name,int mark,String directory) {
		this.nodeName=name;
		this.mark=mark;
		this.directory=directory;
		childRoots=new ArrayList<FileNode>();
		fileNames=new ArrayList<String>();
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public List<String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public List<FileNode> getChildRoots() {
		return childRoots;
	}
	public void setChildRoots(List<FileNode> childRoots) {
		this.childRoots = childRoots;
	}
	
	/**
	 * This function prints file property
	 */
	public void printFiles(){
		for(String file : fileNames) {
			System.out.print(file+" ");
		}
	}
	
	
	
	
	
}
