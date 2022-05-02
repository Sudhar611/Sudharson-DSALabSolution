package com.gl.question2;
import java.util.*;

class Node {
	int nodeData;
	Node leftNode, rightNode;
}

public class MainClass {
	static Node NewNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		
		return temp;
	}
	
	public Node insert(Node root, int key) {
		if(root == null) {
			return NewNode(key);
		}
		if(key < root.nodeData) {
			root.leftNode = insert(root.leftNode, key);
		}else {
			root.rightNode = insert(root.rightNode, key);
		}
		return root;
	}
	
	boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
		if(root == null) {
			return false;
		}
		
		if(findpairUtil(root.leftNode, sum, set)) {
			return true;
		}
		
		if(set.contains(sum - root.nodeData)) {
			System.out.println("Pair is found (" + 
								(sum - root.nodeData) + "," + 
									root.nodeData + ")");
			return true;
		}
		else {
			set.add(root.nodeData);
		}
		
		return findpairUtil(root.rightNode, sum, set);
	}
	
	void findPair(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findpairUtil(root, sum, set)) {
			System.out.println("Pairs do not exist"+ "\n");
		}
	}

	public static void main(String[] args) {
		
		Node root = null;
		
		MainClass Obj = new MainClass();
		
		root = Obj.insert(root, 40);
		root = Obj.insert(root, 20);
		root = Obj.insert(root, 60);
		root = Obj.insert(root, 10);
		root = Obj.insert(root, 30);
		root = Obj.insert(root, 50);
		root = Obj.insert(root, 70);
		
		int sum = 130;
		Obj.findPair(root, sum);

	}

}
