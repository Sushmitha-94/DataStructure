 import java.util.HashMap;

 
// LRU Cache using Doubly linked list (DoublyLinkedList class) 
public class Cache_DoubleLinked {
	
	public int size_Cache;
	public HashMap<Integer,NodeD> hashCache=new HashMap<Integer,NodeD>();
	DoublyLinkedList doubleL=new DoublyLinkedList();
	
	Cache_DoubleLinked(int size){
		this.size_Cache=size;
	}
	
	// set, makes the key as the first node in DLL (LRU)
	public void set(int key,int value) {
		// if the key is available in the map, it is removed from the DLL and added as the first node.
		if(hashCache.containsKey(key)) {
			NodeD newnode=hashCache.get(key);
			doubleL.remove(newnode);
			doubleL.addFirst(newnode);
			hashCache.put(key, newnode);
		}
		// if not, cache size is checked and removed the last node if size is equal and then add the key to the DLL as first node
		// and inserted to the map. 
		else {
			if(hashCache.size()>=size_Cache) {
				doubleL.removeLast();
			}
			NodeD newnode=new NodeD(key,value);
			doubleL.addFirst(newnode);
			hashCache.put(key, newnode);
		}
	}
	
	// access the key from the cache if found and made it a first node in DLL.
	public void get(int key) {
		if(hashCache.containsKey(key)) {
			NodeD newNode=hashCache.get(key);
			doubleL.remove(newNode);
			doubleL.addFirst(newNode);
			hashCache.put(key, newNode);
		}
		else {
			System.out.println("No Key found");
		}
		
	}
	
	// displays DLL in LRU format
	public void display() {
		doubleL.display();
	}
	
	public static void main(String[] args) {
		Cache_DoubleLinked cache=new Cache_DoubleLinked(5);
		cache.set(1, 11);
		cache.set(2, 22);
		cache.display();
		cache.set(16, 116);
		cache.get(2);
		cache.display();
	}

}
