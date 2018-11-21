package com.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	static HashMap<String,DirectedGraphNode> nodeMap=new HashMap<String,DirectedGraphNode>();
	
	public static void createNode(String value) {
		DirectedGraphNode newNode=new DirectedGraphNode(value);
		nodeMap.put(value, newNode);
	}
	
	public static void addEdge(String node1,String node2) {
		DirectedGraphNode gNode1=nodeMap.get(node1);
		DirectedGraphNode gNode2=nodeMap.get(node2);
		if(gNode1!=null && gNode2!=null) {
			gNode1.adj.add(node2);
		}
		else {
			System.out.println("Invalid node value");
		}
	}
	
	public static void topSort(String toCheck,Stack<String> visited,HashSet<String> isVisited) {
		isVisited.add(toCheck);
		for(String adj:nodeMap.get(toCheck).adj) {
			if(!visited.contains(adj)) {
				topSort(adj,visited,isVisited);
			}
		}
		if(!visited.contains(toCheck)) {
				System.out.println(toCheck);
				visited.push(toCheck);
		}
	}
	
	public static void topologicalSort() {
		HashSet<String> isVisited=new HashSet<String>();
		Stack<String> visited=new Stack<String>();
		if(!nodeMap.isEmpty()) {
			Set<String> it=nodeMap.keySet();
			for(String node:it) {
				if(!visited.equals(node))
					topSort(node,visited,isVisited);
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
		addEdge("E","D");
		addEdge("F","B");
		addEdge("C","E");
		addEdge("C","F");
		topologicalSort();
	}

}
