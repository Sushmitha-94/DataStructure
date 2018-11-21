
// implementation of queue using linked list
public class QueueUsingLinkedList {

	public int maxArray;
	public static int top;
	public LinkedList queueList;
	
	static {
		top=-1;
	}
	
	QueueUsingLinkedList(int maxArray){
		this.maxArray=maxArray;
		this.queueList=new LinkedList();
	}
	
	public void enQueue(Object value) {
		if(top==maxArray-1) {
			System.out.println("Queue is full");
		}
		else {
			queueList.add(value);
			top++;
		}
	}
	
	public void deQueue() {
		if(top==-1) {
			System.out.println("Queue is empty");
		}
		else {
			queueList.removeFirst();
			top--;
		}
	}
	
	public void display() {
		queueList.display();
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList queue=new QueueUsingLinkedList(3);
		queue.enQueue("One");
		queue.enQueue('2');
		queue.enQueue(3);
		queue.enQueue(4.00);
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
		queue.deQueue();
		queue.display();
	}

}
