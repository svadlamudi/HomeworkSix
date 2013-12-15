// Name: Sai Kiran Vadlamudi		Username: svadlamudi		Section: B01
// Name: Marilda Bozdo				Username: mbozdo			Section: B06

import java.util.LinkedList;
import tester.Tester;

/**
 * @author Sai Kiran Vadlamudi
 * @author Marilda Bozdo
 * 
 * The Example class provides a set of examples and tests for testing code.
 */
public class Examples {

	/**
	 * Default Constructor
	 */
	Examples(){		
		//Initialize and Setup Graphs and Nodes for Testing
		initGraph();
	}
	
	//Initialize and Construct Graphs
	Graph flights = new Graph();
	Graph empty = new Graph();
	
	//Initialize and Construct Nodes
	Node boston = new Node("Boston");
	Node worcester = new Node("Worcester");
	Node hartford = new Node("Hartford");
	Node chicago = new Node("Chicago");
	Node denver = new Node("Denver");
	Node phoenix = new Node("Phoenix");
	Node houston = new Node("Houston");
	Node tulsa = new Node("Tulsa");
	
	public void initGraph(){
		
		//Add Nodes to Graph
		flights.addNode(boston);
		flights.addNode(worcester);
		flights.addNode(hartford);				
		flights.addNode(chicago);
		flights.addNode(denver);			
		flights.addNode(phoenix);
		flights.addNode(houston);
		flights.addNode(tulsa);			
		
		//Add edges between Nodes
		flights.addDirectedEdge(boston, worcester);
		flights.addDirectedEdge(boston, hartford);
		flights.addDirectedEdge(chicago, denver);	
		flights.addDirectedEdge(phoenix, houston);
		flights.addDirectedEdge(houston, tulsa);	
	}	
	
///////////////////////////////////*Tests*////////////////////////////////////////////
	
//Tests for getNetworks()
	public boolean testGetNetworksEmpty(Tester t){
		return t.checkExpect(empty.getNetworks(), new LinkedList<Network>());
	}
	
	public boolean testGetNetworksFlights(Tester t){		
		
		//Initialize and Construct three subsets of Networks
		Network north = new Network();
		Network mid = new Network();
		Network south = new Network();
		
		//Add names of cities to their corresponding subset network
		north.addFront(hartford.getName());		
		north.addFront(worcester.getName());
		north.addFront(boston.getName());
		mid.addFront(denver.getName());
		mid.addFront(chicago.getName());		
		south.addFront(tulsa.getName());
		south.addFront(houston.getName());
		south.addFront(phoenix.getName());		
		
		//Add three networks to a list of networks
		LinkedList<Network> listOfNetwork = new LinkedList<Network>();
		listOfNetwork.add(north);
		listOfNetwork.add(mid);
		listOfNetwork.add(south);
		
		return t.checkExpect(flights.getNetworks(), listOfNetwork);
	}

//Tests for newFlights()
	public boolean testNewFlightsEmpty(Tester t){
		return t.checkExpect(empty.newFlights(), new LinkedList<String>());
	}
	
	public boolean testNewFlightsFlights(Tester t){
		LinkedList<String> pairsOfCities = new LinkedList<String>();
		LinkedList<String> pairOne = new LinkedList<String>();
		LinkedList<String> pairTwo = new LinkedList<String>();
		
		pairOne.add("Boston");
		pairOne.add("Chicago");
		pairTwo.add("Chicago");
		pairTwo.add("Phoenix");
		
		pairsOfCities.addAll(pairOne);
		pairsOfCities.addAll(pairTwo);
		
		return t.checkExpect(flights.newFlights(), pairsOfCities);
	}
}
