package com.greatlearning.corejava.findpairsum;

import java.util.HashSet;

public class SumPair {
	
	// A class to store a BST node
	static class Node {
		int nodeData;
		Node leftNode; 
		Node rightNode;
	}

	static Node NewNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}
    // Recursive function to insert a key into a BST
	public Node insert(Node root, int key) {
	
		// if the root is null, create a new node and return it
		if(root == null) {
			return NewNode(key);
		}// if the given key is less than the root node, recur for the left subtree
		else if(key < root.nodeData) 
		{    
			root.leftNode = insert(root.leftNode, key);
		}// if the given key is more than the root node, recur for the right subtree
		else 
		{
			root.rightNode = insert(root.rightNode, key);
		}
		return root;
	}
	// Function to find a pair with a given sum in the BST
	public boolean findPair(Node root, int sum,HashSet<Integer> set)
	{
		if (root == null)
			return false;
		 // return true if pair is found in the left subtree; otherwise, continue
		
		if (findPair(root.leftNode, sum, set))
			return true;
		
		// if a pair is formed with the current node, print the pair and return true
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found ("
					+ (sum - root.nodeData) + ", "
					+ root.nodeData + ")");
			return true;
		}
		else // insert the current node's value into the set
			set.add(root.nodeData);
		
		// search in the right subtree
		return findPair(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		if (!findPair(root, sum, set))
			System.out.print("Pairs do not exist"+ "\n");

	}

	public static void main(String[] args)
	{
		Node root = null;
		
		SumPair findSP = new SumPair();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);

		int sum = 80;
		findSP.findPairWithGivenSum(root, sum);
	}
}
