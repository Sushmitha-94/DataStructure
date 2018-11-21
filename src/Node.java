
// Node - Singly Linked List
public class Node {

	private Object data;
	private Node next;
	
	Node(Object data){
		this.data=data;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
		
	
}
