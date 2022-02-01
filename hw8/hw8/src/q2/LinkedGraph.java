package q2;

import java.util.*;


/**
 * This is Linked Graph class
 * @author Oðuzhan SEZGÝN
 * 
 * @param <E> Generic type
 */
public class LinkedGraph<E> extends AbstractGraph<E>{
	int idIndex;
	Edge<E> destRoot; //destination nodes root
	Edge<E> sourRoot; // source nodes root
	
	/**Linked Graph constructor
	 * @param numV Vertex number
	 * @param directed Graph type (directed - undirected)
	 * @param data Vertex data array
	 */
	public LinkedGraph(int numV, boolean directed,E [] data) {
		super(numV, directed);
		idIndex=0;
		destRoot=new Edge<E>(true,data[0],idIndex);
		sourRoot=new Edge<E>(true,data[0],idIndex);
		idIndex++;
		Edge<E> temp = destRoot;
		Edge<E> temp1 = sourRoot;
		for(int i=1;i<numV;i++) {
			temp.setRnext(new Edge<E>(true,data[i],idIndex));
			temp.getRnext().setRprev(temp);
			temp=temp.getRnext();
			
			temp1.setCnext(new Edge<E>(true,data[i],idIndex));
			temp1.getCnext().setCprev(temp1);
			temp1=temp1.getCnext();
			idIndex++;
		}

	}

	/**This method adds edge to graph with call insert method
	 * @param source Source vertex
	 * @param dest Destination vertex
	 */
	public void addEdge(E source,E dest) {
		if(!isEdge(new Edge<E>(true,source,0), new Edge<E>(true,dest,0))) {
			if(isDirected())
				this.insert(new Edge<E>(source,dest));
			else {
				if(source.equals(dest)) {
					this.insert(new Edge<E>(source,dest));
				}
				else {
					this.insert(new Edge<E>(source,dest));
					this.insert(new Edge<E>(dest,source));
				}
				
			}
		}
		
	}
	
	/**This method removes edge from graph with call remove method
	 * @param source Source vertex
	 * @param dest Destination vertex
	 */
	public void removeEdge(E source, E dest) {
		
		if(isVertex(source) && isVertex(dest)) {
			if(isDirected()) {
				this.remove(new Edge<E>(true,source,0), new Edge<E>(true,dest,0));	
			}
				
			else {
				this.remove(new Edge<E>(true,source,0), new Edge<E>(true,dest,0));
				this.remove(new Edge<E>(true,dest,0), new Edge<E>(true,source,0));
			}
		}
		
		
	}
	
	
	@Override
	public void insert(Edge<E> edge) {
		Edge<E> stemp=this.sourRoot;
		
		boolean flag=false;
		while(stemp.getCnext()!=null) {
			if(stemp.getData().equals(edge.getSource())) {
				flag=true;
				break;
			}
			stemp=stemp.getCnext();
		}
		if(!flag) {
			if(stemp.getData().equals(edge.getSource())) {
				flag=true;
			}
		}
		if(!flag)
			return;
		flag=false;
		Edge<E> dtemp=this.destRoot;
		while(dtemp.getRnext()!=null) {
			if(dtemp.getData().equals(edge.getDestination())) {
				flag=true;
				break;
			}
			dtemp=dtemp.getRnext();
		}
		if(!flag) {
			if(dtemp.getData().equals(edge.getDestination())) {
				flag=true;
				
			}
		}
		if(!flag)
			return;
		flag=false;
		Edge<E> s1temp = stemp;
		if(stemp.getRnext()==null) {
			stemp.setRnext(edge);
			edge.setRnext(null);
			edge.setRprev(stemp);
			flag=true;
		}
		else {

	 		while(s1temp.getRnext()!=null) {
	 			if(findDestination(s1temp.getRnext()).getId()>dtemp.getId()) {
	 				s1temp.getRnext().setRprev(edge);
	 				edge.setRnext(s1temp.getRnext());
	 				edge.setRprev(s1temp);
	 				s1temp.setRnext(edge);
	 				
	 				flag=true;
	 				break;
	 				
	 			}
	 		
	 			s1temp=s1temp.getRnext();
	 		}
		}
		
 		if(!flag) {
 			edge.setRnext(null);
			edge.setRprev(s1temp);
			s1temp.setRnext(edge);
 		}
 		flag=false;
 		Edge<E> d1temp = dtemp;
 		if(d1temp.getCnext()==null) {
 			d1temp.setCnext(edge);
 			edge.setCnext(null);
 			edge.setCprev(d1temp);
 			flag=true;
 		}
 		else {
 	
 			while(d1temp.getCnext()!=null) {
 				
 				if(findSource(d1temp.getCnext()).getId()>stemp.getId()) {
 					d1temp.getCnext().setCprev(edge);
 					edge.setCnext(d1temp.getCnext());
 					edge.setCprev(d1temp);
 					d1temp.setCnext(edge);
 					
 					
 					flag=true;
 					break;
 				}
 				d1temp=d1temp.getCnext();
 				
 			}
 		}
 		if(!flag) {
 			edge.setCnext(null);
 			edge.setCprev(d1temp);
 			d1temp.setCnext(edge);
 		}
 		
		
	}

	/**
	 * This method removes edge from graph 
	 * @param source Source vertex
	 * @param dest Destination vertex
	 */
	public void remove(Edge<E> source, Edge<E> dest) {
		
		Edge<E> edge=getEdge(source, dest);
		if(edge!=null) {
			if(edge.getCnext()!=null) {
				edge.getCprev().setCnext(edge.getCnext());
				edge.getCnext().setCprev(edge.getCprev());
				
			}
			else 
				edge.getCprev().setCnext(null);
			
			
			if(edge.getRnext()!=null) {
				edge.getRprev().setRnext(edge.getRnext());
				edge.getRnext().setRprev(edge.getRprev());
			}
			else
				edge.getRprev().setRnext(null);
		
			edge=null;
		}
	}
	
	/**This method find edge's destination vertex.
	 * @param node Edge to find destination vertex.
	 * @return Destination vertex
	 */
	private Edge <E> findSource(Edge<E> node){
		while(!node.isSource()) {
			node=node.getRprev();
		}
		return node;
	}
	
	/**This method find edge's source vertex.
	 * @param node Edge to find source vertex.
	 * @return Source vertex
	 */
	private Edge<E> findDestination(Edge<E> node){
		while(!node.isSource()) {
			node=node.getCprev();
		}
		return node;
		
	}
	
	
	/** This method add vertex to graph
	 * @param data New vertex data
	 * @return If it will add return true , else false
	 */
	public boolean addVertex(E data) {
		if(this.destRoot==null || this.sourRoot==null)
			return false;
		if(isVertex(data))
			return false;
		Edge<E> temp = this.destRoot;
		Edge<E> temp1 = this.sourRoot;
		while(temp1.getCnext()!=null) {
			temp1=temp1.getCnext();
			temp=temp.getRnext();
		}
		temp1.setCnext(new Edge<E>(true,data,this.idIndex));
		temp1.getCnext().setCprev(temp1);
		temp.setRnext(new Edge<E>(true,data,this.idIndex));
		temp.getRnext().setRprev(temp);
		this.idIndex++;
		this.setNumV(this.getNumV()+1);
		return true;
	}
	
	/**This method checks is the vertex exist or not
	 * @param data Vertex data
	 * @return If vertex exist return true else return false
	 */
	private boolean isVertex(E data) {
		Edge<E> temp = sourRoot;
		for(int i=0;i<getNumV();i++) {
			if(temp.getData().equals(data))
				return true;
			temp=temp.getCnext();
		}
		return false;
		
	}
	
	
	/**This method remove vertex from graph , and reset vertex id
	 * @param data Data of vertex to be deleted
	 * @return  If it will remove return true , else false
	 */
	public boolean removeVertex(E data) {
		Edge<E> temp = this.destRoot;
		Edge<E> temp1 = this.sourRoot;
		while(temp1.getCnext()!=null) {
			temp1=temp1.getCnext();
			temp=temp.getRnext();
			if(temp1.getData().equals(data) && temp.getData().equals(data) ) {
				if(temp1.getCnext()!=null) {
					temp1.getCprev().setCnext(temp1.getCnext());
					temp1.getCnext().setCprev(temp1.getCprev());
					
					temp.getRprev().setRnext(temp.getRnext());
					temp.getRnext().setRprev(temp.getRprev());
					
					
				}
				else {
					temp1.getCprev().setCnext(null);
					temp.getRprev().setRnext(null);
				}
				temp1=temp1.getRnext();
				temp=temp.getCnext();
				while(temp1!=null) {
					
					temp1.getRprev().setRnext(null);
					temp1.getCprev().setCnext(null);
					temp1 = temp1.getRnext();
				}
				while(temp!=null) {
					temp.getCprev().setCnext(null);
					temp.getRprev().setRnext(null);
					temp = temp.getCnext();
				}
				this.setNumV(this.getNumV()-1);
				resId();
				return true;
				
			}
				
				
		}
		return false;
	}
	

	/**
	 * This method reset all vertex id , when a vertex removes
	 */
	private void resId() {
		Edge<E> dtemp=this.destRoot;
		Edge<E> stemp=this.sourRoot;
		for(int i=0;i<getNumV();i++) {
			stemp.setId(i);
			dtemp.setId(i);
			stemp=stemp.getCnext();
			dtemp=dtemp.getRnext();
		}
	}
	

	@Override
	public boolean isEdge(Edge<E> source, Edge<E> dest) {
	
		Edge<E> stemp=this.sourRoot;
		for(int i=0;i<this.getNumV();i++) {
			if(stemp.getData().equals(source.getData())) {
				break;
			}
			stemp=stemp.getCnext();
		}
		if(stemp==null || stemp.getRnext()==null)
			return false;
		stemp=stemp.getRnext();
		while(stemp.getRnext()!=null) {
			if(stemp.getDestination().equals(dest.getData()))
				return true;
			stemp=stemp.getRnext();
		}
		if(stemp !=null && stemp.getDestination().equals(dest.getData()))
			return true;
		
		return false;
	}

	@Override
	public Edge<E> getEdge(Edge<E> source, Edge<E> dest) {
		if(isEdge(source, dest)) {
			Edge<E> stemp=this.sourRoot;
			for(int i=0;i<this.getNumV();i++) {
				if(stemp.getData().equals(source.getData())) {
					break;
				}
				stemp=stemp.getCnext();
			}
			stemp=stemp.getRnext();
			while(stemp.getRnext()!=null) {
				if(stemp.getDestination().equals(dest.getData()))
					return stemp;
				stemp=stemp.getRnext();
			}
			if(stemp.getDestination().equals(dest.getData()))
				return stemp;
			
		}
		return null;
	}
	
	/**This method find and return source vertex
	 * @param id Searched vertex id 
	 * @return Source vertex
	 */
	public Edge<E> getSourVer(int id){
		Edge<E> temp = this.sourRoot;
		for(int i=0;i<this.getNumV();i++) {
			if(temp.getId()==id)
				return temp;
			temp=temp.getCnext();
		}
		return null;
	}
	
	/**This methods find and return source vertex
	 * @param data Searched vertex data 
	 * @return Source vertex
	 */
	private Edge<E> getDataVer(E data){
		Edge<E> temp = this.sourRoot;
		for(int i=0;i<this.getNumV();i++) {
			if(temp.getData().equals(data))
				return temp;
			temp=temp.getCnext();
		}
		return null;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public Iterator<Edge> edgeIterator(Edge<E> source) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method prints graph as a matrix
	 */
	public void print() {
		Edge <E> temp=destRoot;
		Edge <E> temp1=sourRoot;
		boolean flag=false;
		for(int i=0;i<getNumV();i++) {
			System.out.print("\t"+temp.toString());
			temp=temp.getRnext();
		}
		System.out.println();
		Edge<E> temp2;
		for(int i=0;i<getNumV();i++) {
			System.out.print((temp1.toString()));
			temp2=temp1;
			int i1=0;
			while(temp2.getRnext()!=null) {
				flag=true;
				if(!temp2.isSource()) {
					
					for(;i1<=findDestination(temp2).getId();i1++) {
							System.out.print("\t");
					}
					System.out.print(temp2.toString());
				}
				
				temp2=temp2.getRnext();
			}
			if(flag) {
				for(;i1<=findDestination(temp2).getId();i1++) {
							System.out.print("\t");
					}
					System.out.print(temp2.toString());
			}
			flag=false;
			
			
			
			System.out.println("");
			temp1=temp1.getCnext();
		}
	}
	
	/**This method do breadth first search
	 * @param data Initial vertex data
	 */
	public void BFS(E data) {
		if(!isVertex(data))
			return;
		int id = getDataVer(data).getId();
		Edge<E> edge= getSourVer(id);
		boolean visited[] = new boolean[this.getNumV()];
		Queue<Edge<E>> queue = new LinkedList<Edge<E>>();
		visited[edge.getId()]=true;
		queue.add(edge);
		while(queue.size()!=0) {
			edge=queue.poll();
			System.out.print(edge.getData()+" ");
			Edge<E> temp = edge;
			while(temp!=null) {
				if(!visited[findDestination(temp).getId()]) {
					visited[findDestination(temp).getId()]=true;
					queue.add(getSourVer(findDestination(temp).getId()));
				}
				temp=temp.getRnext();
			}
		}
		
		
	}

	/**This method do deep first search with call DFSrec method. 
	 * @param data Initial vertex data
	 */
	public void DFS(E data) {
		if(!isVertex(data))
			return;
		int id = getDataVer(data).getId();
		Edge<E> edge= getSourVer(id);
		boolean visited[] = new boolean[this.getNumV()];
		DFSrec(edge, visited);
	}
	
	/**This method do deep first search
	 * @param edge Edge to visit
	 * @param visited Visited array holds visited edge's id
	 */
	private void DFSrec(Edge<E> edge,boolean [] visited) {
		visited[edge.getId()]=true;
		//E data=edge.getData();
		
		Edge<E> temp = edge;
		while(temp!=null) {
			if(!visited[findDestination(temp).getId()]) {
				DFSrec(getSourVer(findDestination(temp).getId()), visited);
			}
			temp= temp.getRnext();
		}
		System.out.print(edge.getData()+" ");
	}
	
	

}
