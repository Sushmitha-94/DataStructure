package com.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSDFSApp {
	static HashMap<String,GraphNode> nodeMap=new HashMap<String,GraphNode>();
	
	public static void createNode(String value) {
		GraphNode newNode=new GraphNode(value);
		nodeMap.put(value, newNode);
	}
	
	public static void addEdge(String node1,String node2) {
		GraphNode gNode1=nodeMap.get(node1);
		GraphNode gNode2=nodeMap.get(node2);
		if(gNode1!=null && gNode2!=null) {
			gNode1.adj.add(node2);
			gNode2.adj.add(node1);
		}
		else {
			System.out.println("Invalid node value");
		}
	}
	
	public static void deleteNode(String value) {
		GraphNode toDelete=nodeMap.get(value);
		if(toDelete!=null) {
			GraphNode adjNode;
			for(String adj:toDelete.adj) {
				adjNode=nodeMap.get(adj);
				adjNode.adj.remove(value);
			}
			nodeMap.remove(value);
		}
		else {
			System.out.println("Invalid node value");
		}
	}
	
	public static void DFSSearch(String value) {
	
		if(nodeMap.get(value)!=null) {
			Stack<String> stackNode=new Stack<String>();
			HashSet<String> visited=new HashSet<String>();
			stackNode.push(value);
			while(!stackNode.empty()) {
				String popValue=stackNode.pop();
				if(!visited.contains(popValue)) {
					System.out.println(popValue);
					visited.add(popValue);
					for(String adj:nodeMap.get(popValue).adj) {
						stackNode.push(adj);
					}
				}
			}
		}		
	}

	public static void BFSSearch(String value) {
		GraphNode gNode=nodeMap.get(value);
		if(gNode!=null) {
			Queue<String> nodeQueue=new LinkedList<String>();
			HashSet<String> visited=new HashSet<String>();
			nodeQueue.add(value);
			while(!nodeQueue.isEmpty()) {
				String popValue=nodeQueue.remove();
				if(!visited.contains(popValue)) {
					visited.add(popValue);
					System.out.println(popValue);
					for(String adj:nodeMap.get(popValue).adj) {
						nodeQueue.add(adj);
					}
				}
			}
		}
	}

	
	
	public static void main(String[] args) {
		createNode("A");
		createNode("B");
		createNode("C");
		createNode("D");
		createNode("E");
		createNode("F");
		addEdge("A","B");
		addEdge("A","E");
		addEdge("D","E");
		addEdge("F","B");
		addEdge("E","C");
		addEdge("F","C");
		//BFSSearch("A");
		DFSSearch("A");
	}

	

}
