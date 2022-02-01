package q2;

/**
 * This is node class . It use for either vertex or edge
 * @author Oðuzhan SEZGÝN 
 * 
 *	
 * @param <E> Generic type
 */
public class Edge<E>  {
	
	private E data;
	private E source;
	private E destination;
	private int id;
	private boolean isSource;
	private Edge<E> rprev;
	private Edge<E> rnext;
	private Edge<E> cprev;
	private Edge<E> cnext;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public E getSource() {
		return source;
	}
	public void setSource(E source) {
		this.source = source;
	}
	public E getDestination() {
		return destination;
	}
	public void setDestination(E destination) {
		this.destination = destination;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	
	public boolean isSource() {
		return isSource;
	}
	public void setSource(boolean isSource) {
		this.isSource = isSource;
	}
	public Edge<E> getRprev() {
		return rprev;
	}
	public void setRprev(Edge<E> rprev) {
		this.rprev = rprev;
	}
	public Edge<E> getRnext() {
		return rnext;
	}
	public void setRnext(Edge<E> rnext) {
		this.rnext = rnext;
	}
	public Edge<E> getCprev() {
		return cprev;
	}
	public void setCprev(Edge<E> cprev) {
		this.cprev = cprev;
	}
	public Edge<E> getCnext() {
		return cnext;
	}
	public void setCnext(Edge<E> cnext) {
		this.cnext = cnext;
	}

	
	/**
	 * This constructor use for construct vertex 
	 * @param flag If flag is true , node is vertex else node is edge
	 * @param data Vertex data
	 * @param id Vertex id
	 */
	public Edge(boolean flag,E data,int id) {
		this.isSource=flag;
		this.id=id;
		this.data=data;
		this.rprev=null;
		this.rnext=null;
		this.cprev=null;
		this.cnext=null;
		
	}
	/**This constructor use for construct edge.
	 * @param source Edge source
	 * @param dest Edge destination 
	 */
	public Edge(E source,E dest) {
		this.isSource=false;
		this.id=-1;
		this.source=source;
		this.destination=dest;
		this.data=null;
		this.rprev=null;
		this.rnext=null;
		this.cprev=null;
		this.cnext=null;
	}

	

	
	/**
	 * This method compare vertex's data
	 * @return If data's are equal return true else return false
	 */
	public boolean equals(Object o) {
		@SuppressWarnings("unchecked")
		Edge<E> temp= (Edge<E>) o;
		if(temp.data.equals(temp.data))
			return true;
		else
			return false;
	}
	
	/**
	 * Convert nodes data to string.
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		if(isSource) {
			str.append(this.data);
			return str.toString();
		}
		else {
			str.append("E:"+this.source+","+this.destination);
			return str.toString();
			
		}
			
		
	}
	

}