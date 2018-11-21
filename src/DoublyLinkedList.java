// implementation of Doubly linked list
public class DoublyLinkedList {
	public static NodeD first;
	public NodeD last;
	
	// adds the node as the head node
	public void addFirst(NodeD node) {
		if(first==null) {
			first=node;
			last=node;
		}
		else {
			first.prev=node;
			node.prev=null;
			node.next=first;
			first=node;
		}
	}
	
	// display the value of the nodes from first till node.next becomes null
	public void display() {
		NodeD node=first;
		System.out.println("Values");
		if(node==null) {
			System.out.println("No value found");
		}
		else {
			System.out.println(node.value);
			while(node.next!=null) {
				node=node.next;
				System.out.println(node.value);
			}
		}
	}
	
	// removes the node from DLL
	public void remove(NodeD node) {
		if(node!=null) {
			// if node is the last node, make node.prev as last node and remove links from the node
			if(node.next==null && node.prev!=null) {
				node.prev.next=null;
				last=node.prev;
				node.next=null;
				node.prev=null;
			}
			// if it is the only node, make first and last null
			else if(node.prev==null && node.next==null) {
				first=null;
				last=null;
			}
			//if it is the first node
			else if(node.prev==null) {
				first=node.next;
				node.next=null;
				node.prev=null;
			}
			else {
				node.prev.next=node.next;
				node.next.prev=node.prev;
				node.next=null;
				node.prev=null;
			}
		}
		
	}
	
	// removes last node
	public void removeLast() {
		if(last.prev!=null) {
			last=last.prev;
			last.next=null;
		}
		else {
			last=null;
			first=null;
		}
	}
	
}
