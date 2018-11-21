// implementation of queue using array
public class QueueUsingArray {

	public static int maxArray;
	public static Object[] queueArray;
	public static int top;
	
	static {
		top=-1;
	}
	
	QueueUsingArray(int maxArray){
		QueueUsingArray.maxArray=maxArray;
		QueueUsingArray.queueArray=new Object[maxArray];
	}
	
	public void enQueue(Object val) {
		if(top==maxArray-1) {
			System.out.println("Queue is full");
		}
		else {
			top++;
			queueArray[top]=val;
		}
	}
	
	public void deQueue() {
		if(top==-1) {
			System.out.println("Empty Queue");			
		}
		else {
			for(int i=0;i<top;i++) {
				queueArray[i]=queueArray[i+1];
			}
			top--;
		}
	}
	
	public void display() {
		System.out.println("Values:");
		for(int i=0;i<=top;i++) {
			System.out.println(queueArray[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray queue=new QueueUsingArray(5);
		queue.enQueue("One");
		queue.enQueue(2);
		queue.enQueue("Three");
		queue.enQueue(4);
		queue.enQueue("Five");
		queue.enQueue(6);
		queue.display();
		queue.deQueue();
		queue.deQueue();
		queue.display();
	}

}
