// Name: Sai Kiran Vadlamudi		Username: svadlamudi		Section: B01
// Name: Marilda Bozdo				Username: mbozdo			Section: B06

import java.util.LinkedList;

/**
 * @author Sai Kiran Vadlamudi
 * @author Marilda Bozdo
 * 
 * The Graph class constructs and provides methods to manipulate the Graph data structure.
 */
public class Graph {
	
	/**
	 * The list of nodes in this Graph.
	 */
	private LinkedList<Node> listOfNodes;
	
	/**
	 * Default Constructor
	 */
	public Graph(){
		this.listOfNodes = new LinkedList<Node>();
	}
	
	/**
	 * the getListOfNodes() method returns the listOfNodes of this Graph.
	 * 
	 * @return LinkedList<Node>
	 */
	public LinkedList<Node> getListOfNodes(){
		return this.listOfNodes;
	}
	
	/**
	 * The addNode(Node) method adds the given node to the listOfNodes of this Graph.
	 * 
	 * @param node
	 * Node to add to this Graph.
	 */
	public void addNode(Node node){
		this.listOfNodes.add(node);
	}
	
	/**
	 * The addDirectedEdge method adds an edge(path) between the given nodes of this Graph.
	 * 
	 * @param from
	 * The Node from which a path is available to the other Node.
	 * 
	 * @param to
	 * The Node to which a path is available from the other Node.
	 */
	public void addDirectedEdge(Node from, Node to){
		from.addEdge(to);
		to.addEdge(from);
	}
	
	/**
	 * The getNetworks() returns the networks of nodes in the listOfNodes of this Graph.
	 * 
	 * @return LinkedList<Network>
	 */
	public LinkedList<Network> getNetworks(){
		return this.getNetworkHelp(new LinkedList<Node>());
	}
	
	/**
	 * Returns the networks of nodes in this listOfNodes
	 * 
	 * @param visited
	 * List of nodes already traversed in the listOfNodes in this Graph.
	 * 
	 * @return LinkedList<Network>
	 */
	private LinkedList<Network> getNetworkHelp(LinkedList<Node> visited){

		LinkedList<Network> listOfNetwork =  new LinkedList<Network>();
		
		for(Node n : this.listOfNodes){
			if(visited.contains(n) == false){
				visited.add(n);
				
				Network network = new Network();				
				network.addFront(n.getName());				
				network.addNetwork(n.getNetworkNode(visited));
				
				listOfNetwork.add(network);
			}
		}
		
		return listOfNetwork;
	}
	
	/**
	 * Returns the minimum pairs of cities which when flights are added between them
	 * would turn this graph into one network.
	 * 
	 * @return LinkedList<String>
	 */
	public LinkedList<String> newFlights(){
		
		LinkedList<Network> listOfNetwork = this.getNetworks();
		LinkedList<String> pairsOfCities = new LinkedList<String>();
		
		for(int i = 0; i < listOfNetwork.size()-1; i++){
			
			LinkedList<String> pairs = new LinkedList<String>();
			
			Network subNetOne = listOfNetwork.get(i);
			Network subNetTwo = listOfNetwork.get(i+1);
			String cityOne = subNetOne.getListOfName().getFirst();
			String cityTwo = subNetTwo.getListOfName().getFirst();
			
			pairs.add(cityOne);
			pairs.add(cityTwo);
			
			pairsOfCities.addAll(pairs);
		}
		
		return pairsOfCities;
	}
}
