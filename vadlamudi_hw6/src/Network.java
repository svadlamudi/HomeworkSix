// Name: Sai Kiran Vadlamudi		Username: svadlamudi		Section: B01
// Name: Marilda Bozdo				Username: mbozdo			Section: B06

import java.util.LinkedList;

/**
 * @author Sai Kiran Vadlamudi
 * @author Marilda Bozdo
 * 
 *  The Network class is a wrapper class for a LinkedList<String>
 */
public class Network {
	
	/**
	 * List of names of Nodes 
	 */
	private LinkedList<String> listOfName;
	
	/**
	 * Default Constructor
	 */
	public Network(){
		listOfName = new LinkedList<String>();
	}
	
	/**
	 * The getListOfName() return the listOfName of this Network.
	 * 
	 * @return LinkedList<String>
	 */
	public LinkedList<String> getListOfName(){
		return this.listOfName;
	}
	
	/**
	 * The addFront(String) adds the given name of a Node to
	 * the beginning of the listOfName of this Network.
	 * 
	 * @param name
	 * The name of a Node.
	 */
	public void addFront(String name){
		this.listOfName.addFirst(name);	
	}
	
	/**
	 * The addNetwork(Network) adds the listOfName of the given Network to 
	 * the listOfName of this Network.
	 * 
	 * @param net
	 * The Network from which the listOfName is to be retrieved and added to this listOfName.
	 */
	public void addNetwork(Network net){
		this.listOfName.addAll(net.listOfName);
	}
}
