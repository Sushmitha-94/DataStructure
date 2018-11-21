
// implementation of Singly linked list
public class LinkedList {		

	static Node head;
	private static Node temp;
	
	// adds the value at the end of the list
	public void add(Object value) {
		if(head==null) {
			head=new Node(value);
		}
		else {
			Node temp=head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			Node newNode=new Node(value);
			temp.setNext(newNode);
		}
	}
	
	// adds the value at a specific index
	public void add(int index,Object value) {
		Node temp=head;
		for(int i=2; i<index; i++) {
			if(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			else{
				break;
			}
		}
		Node newNode=new Node(value);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
	}
	
	// adds the value to as a first node.
	public void addFirst(Object value) {
		Node newNode=new Node(value);
		Node temp=head;
		newNode.setNext(temp);
		head=newNode;
	}
	
	// remove specified node value
	public void remove(Object value) {
		temp = head;
		Node tempPrev=head;
		// if its the head node
		if(temp.getData()==value) {
			head=temp.getNext();
		}
		// if not
		else {
			temp=temp.getNext();
			while(temp!=null) {
				if(temp.getData()==value) {
					tempPrev.setNext(temp.getNext());
					break;
				}
				tempPrev=temp;
				temp=temp.getNext();
			}
		}
	}
	
	// removes head node
	public void removeFirst() {
		Node temp=head;
		head=temp.getNext();
	}

	// removes last node
	public void removeLast() {
		Node temp=head.getNext();
		Node prevTemp=head;
		if(temp==null) {
			head=null;
		}
		else {
			while(temp.getNext()!=null) {
				temp=temp.getNext();
				prevTemp=prevTemp.getNext();
			}
			prevTemp.setNext(null);
		}
	}
	
	// reverse the linked list recursively
	public Node reverseRecursive(Node temp) {
		if(temp==null)
			return null;
		if(temp.getNext()==null)
			return temp;
		
			Node sec=temp.getNext();
			temp.setNext(null);
			Node newHead=reverseRecursive(sec);
			sec.setNext(temp);
			return newHead;
	}
	
	// reverse the linked list iteratively
	public void reverseIterative() {
		Node temp=head;
		Node prev=null,next=null;
		Node curr=temp;
		while(curr!=null) {
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next; 
		}
		head=prev;
	}
	
	// display the values from head
	public void display () {
		Node temp=head;
		System.out.println("Values");
		if(temp==null) {
			System.out.println("No values to display");
		}
		else {
		while(temp.getNext()!=null) {
			System.out.println(temp.getData());
			temp=temp.getNext();
		}
		System.out.println(temp.getData());
		}
	}
	
	
}
