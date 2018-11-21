package com.graph;

import java.util.LinkedList;

public class GraphNode {
	public String value;
	public LinkedList<String> adj=new LinkedList<String>();
	
	GraphNode(String value){
		this.value=value;
	}
}
