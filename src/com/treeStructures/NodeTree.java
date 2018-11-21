package com.treeStructures;

// node for tree data structure (like DLL)
public class NodeTree {
	int data;
	NodeTree lTree;
	NodeTree rTree;
	
	public NodeTree(int data) {
		this.data = data;
		this.lTree=null;
		this.rTree=null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public NodeTree getlTree() {
		return lTree;
	}
	public void setlTree(NodeTree lTree) {
		this.lTree = lTree;
	}
	public NodeTree getrTree() {
		return rTree;
	}
	public void setrTree(NodeTree rTree) {
		this.rTree = rTree;
	}
	
}
