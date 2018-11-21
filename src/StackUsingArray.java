
// implementation of stack using array
public class StackUsingArray {
	public static int maxArray;
	public static int top;
	public static int[] intArray;
	
	static {
		top=-1;
	}
	
	StackUsingArray(int maxArray){
		StackUsingArray.maxArray=maxArray;
		StackUsingArray.intArray=new int[maxArray];
	}	
	
	public void push(int pushVal) {
		if(top==maxArray-1) {
			System.out.println("Stack is full");
		}
		else {
			top++;
			intArray[top]=pushVal;
		}
	}
	
	public void pop() {
		if(top==-1) {
			System.out.println("Stack is empty");
		}
		else {
			top--;
		}
	}
	
	public void display() {
		System.out.println("Values in Array:");
		for(int i=top;i>=0;i--) {
			System.out.println(intArray[i]);
		}
		
	}
	
	public static void main(String[] args) {
		StackUsingArray stackNew=new StackUsingArray(10);
		stackNew.push(1);
		stackNew.push(2);
		stackNew.push(3);
		stackNew.push(4);
		stackNew.push(5);
		stackNew.display();
		stackNew.pop();
		stackNew.display();

	}
}
