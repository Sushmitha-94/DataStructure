package com.graph;

import java.util.LinkedList;

public class DirectedGraphNode {
	public String value;
	public LinkedList<String> adj=new LinkedList<String>();
	
	DirectedGraphNode(String value){
		this.value=value;
	}
}

