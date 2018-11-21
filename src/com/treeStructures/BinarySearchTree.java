package com.treeStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	static NodeTree root=null;
	static int step=0;
	static int index=0;
	static int[] toBST;
	static Queue<NodeTree> tempQ=new LinkedList<NodeTree>();
	
	// add the element to the leaf of the node by checking the values of the parent node recursively
	public static NodeTree insertRBST(NodeTree trav,int data) {
		if(trav==null)
			trav=new NodeTree(data);
		else {
			if(trav.data>data)
				trav.lTree=insertRBST(trav.lTree,data);
			else
				trav.rTree=insertRBST(trav.rTree,data);
		}
		return trav;
	}
	
	// add the element to the leaf of the node by checking the values of the parent node iteratively
	public static void insertBST(int data) {
		if(root==null) 
			root= new NodeTree(data);
		else {
			NodeTree trav=root;
			while(trav!=null) {
				if(data<trav.data)
				{
					if(trav.lTree==null) {
						trav.lTree=new NodeTree(data);
						break;
					}
					else
						trav=trav.lTree;
				}
				else {
					if(trav.rTree==null) {
						trav.rTree=new NodeTree(data);
						break;
					}
					else
						trav=trav.rTree;
				}
					
			}
			
		}
	}
	
	// delete the node
	public static NodeTree deleteBST(NodeTree root,int data) {
		NodeTree trav=root;
		if(trav==null) {
			return null;
		}
		// if data found
		else if(trav.data==data) {
			// if no child, delete
			if(trav.lTree==null && trav.rTree==null)
				return null;
			// has only right child, place right child in its position
			else if(trav.lTree==null) {
				return trav.rTree;
			}
			// has only left child, place right child in its position
			else if(trav.rTree==null) {
				return trav.lTree;
			}
			// has both right and left child, find min of all children, 
			// replace with min child and delete min child
			else {
				NodeTree minNode=findMin(trav.rTree);
				trav.data=minNode.data;
				trav.rTree=deleteBST(trav.rTree,minNode.data);
			}
		}
		// if not, traverse left or right accordingly (recursive)
		else if(trav.data>data)
			trav.lTree=deleteBST(trav.lTree,data);
		else
			trav.rTree=deleteBST(trav.rTree,data);
		return trav;
	}
	
	// last left node will be the min child
	public static NodeTree findMin(NodeTree node) {
		if(node.lTree!=null)
			node=findMin(node.lTree);
		return node;
	}
	
	// search node, traverse left or right recursively till data is found
	public static NodeTree searchBST(NodeTree trav,int data) {
		if(trav==null)
			return null;
		if(trav.data==data)
			return trav;
		else if(trav.data>data)
			return searchBST(trav.lTree,data);
		else
			return searchBST(trav.rTree,data);
	}
	
	// data, left, right
	public static void preOrderTraversal(NodeTree trav) {
		if(trav!=null) {
			System.out.print(trav.data+" ");
			preOrderTraversal(trav.lTree);
			preOrderTraversal(trav.rTree);
		}
	}
	
	// left, right, data
	public static void postOrderTraversal(NodeTree trav) {		
		if(trav!=null) {
			postOrderTraversal(trav.lTree);
			postOrderTraversal(trav.rTree);
			System.out.print(trav.data+" ");
		}
		
	}
	
	// left, data, right
	public static void inOrderTraversal(NodeTree trav) {
		if(trav!=null) {
			inOrderTraversal(trav.lTree);
			System.out.print(trav.data+" ");
			inOrderTraversal(trav.rTree);
		}
	}
	
	// level order
	public static void levelOrderTraversal(NodeTree trav) {
		if(trav!=null) {
			System.out.print(" "+trav.data);
			if(trav.lTree!=null)
				tempQ.add(trav.lTree);
			if(trav.rTree!=null)
				tempQ.add(trav.rTree);
			if(!tempQ.isEmpty())
				levelOrderTraversal(tempQ.poll());
		}
	}
	
	// BST to array	
	public static void toBSTArray(NodeTree trav) {
		if(trav!=null) {
			toBSTArray(trav.lTree);
			toBST[index++]=trav.data;
			toBSTArray(trav.rTree);
		}
	}

	public static NodeTree inOderSuccessor(NodeTree root, int data) {
		NodeTree current=searchBST(root,data);
		if(current==null)
		{
			return null;
		}
		else if(current.rTree!=null)
			return 	findMin(current.rTree);
		else {
			NodeTree Successor=null;
			NodeTree ancestor=root;
			while(ancestor.data!=current.data) {
				if(ancestor.data>current.data) {
					Successor=ancestor;
					ancestor=ancestor.lTree;
				}
				else
					ancestor=ancestor.rTree;
			}
			return Successor;
		}		
	}
	
	// array to BST
	public static NodeTree arrayToBBST(int[] arr,int low,int high) {
		
		NodeTree tree;
		int mid=(high+low)/2;
		if(high==low) {
			tree=new NodeTree(arr[mid]);
		}
		else if(mid==low) {
			tree=new NodeTree(arr[mid]);
			tree.rTree=arrayToBBST(arr,mid+1,high);
		}
		else { 
			tree=new NodeTree(arr[mid]);
			tree.lTree=arrayToBBST(arr,low,mid-1);
			tree.rTree=arrayToBBST(arr,mid+1,high);
		}
		return tree;
	}
	
	public static void main(String[] args) {
		root=insertRBST(root,50);
		root=insertRBST(root,60);
		root=insertRBST(root,20);
		root=insertRBST(root,30);
		root=insertRBST(root,10);
		root=insertRBST(root,8);
		root=insertRBST(root,5);
		root=insertRBST(root,2);
		root=insertRBST(root,1);
	    /*toBST= new int[8];
	    toBSTArray(root);
	    for(int i=0;i<8;i++) {
	    	System.out.println(" "+toBST[i]);
	    }
		NodeTree bBST=arrayToBBST(toBST,0,8);
		levelOrderTraversal(bBST);
		*/
		levelOrderTraversal(root);
	}
}
