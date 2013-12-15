// Name: Sai Kiran Vadlamudi		Username: svadlamudi		Section: B01
// Name: Marilda Bozdo				Username: mbozdo			Section: B06

import java.util.LinkedList;

/**
 * @author Sai Kiran Vadlamudi
 * @author Marilda Bozdo
 * 
 * The Node class constructs and provides methods to manipulate a Node, 
 * which is a city with a name and a list of path from and to the city.
 */
public class Node {
	
	/**
	 * name is the name of the Node.
	 */
	private String name;
	
	/**
	 * fromAndTo is the list of Nodes connected to this Node.
	 */
	private LinkedList<Node> fromAndTo;
	
	/**
	 * Default Constructor
	 * Constructs a Node with the name given and an empty list of nodes for fromAndTo.
	 * 
	 * @param name
	 * Name of the Node.
	 */
	public Node(String name){
		this.name = name;
		this.fromAndTo = new LinkedList<Node>();
	}
	
	/**
	 * The getName() method returns the name of this Node.
	 * 
	 * @return String
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * The getFromAndTo() returns the fromAndTo of this Node.
	 * 
	 * @return LinkedList<Node>
	 */
	public LinkedList<Node> getFromAndTo(){
		return this.fromAndTo;
	}
	
	/**
	 * The addEdge(Node) method adds the given Node to the fromAndTo list of this Node.
	 * This method adds an edge(path) between the given Node and this Node.
	 * 
	 * @param toAndFromNode
	 * The Node to and from which there are available paths to this Node.
	 */
	public void addEdge(Node toAndFromNode){
		this.fromAndTo.addFirst(toAndFromNode);
	}
	
	/**
	 * The getNetworkNode() returns a network with the name of the nodes that have edges
	 * to and from this Node.
	 * 
	 * @param visited
	 * List of nodes which have already been traversed and added to a Network.
	 * 
	 * @return Network
	 */
	public Network getNetworkNode(LinkedList<Node> visited){
		
		Network network = new Network();
		
		for(Node n : this.fromAndTo){
			if(visited.contains(n)){
				return network;
			}
			else{
				visited.add(n);
				network.addFront(n.name);
				network.addNetwork(n.getNetworkNode(visited));
			}
		}
		
		return network;
	}
}
