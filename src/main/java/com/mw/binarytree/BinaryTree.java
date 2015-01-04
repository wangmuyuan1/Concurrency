package com.mw.binarytree;

public class BinaryTree {
	
	static class Node
	{
		public Node left;
		public Node right;
		public Node parent;
		int value;
		
		public Node(Node parent, int value)
		{
			this.parent = parent;
			this.value = value;
		}
		
		public String toString()
		{
			return String.valueOf(value);
		}
	}
	
	static class Tree
	{
		public Node root;
		
		public void insertNode(int ... array)
		{
			for (int value : array)
			{
				insertNode(root, value);
			}
		}
		
		private void insertNode(Node node, int value)
		{
			if (node.value > value)
			{
				if (node.left != null)
				{
					insertNode(node.left, value);
				}
				else
				{
					node.left = new Node(node, value);
				}
			}
			else 
			{
				if (node.right != null)
				{
					insertNode(node.right, value);
				}
				else
				{
					node.right = new Node(node, value);
				}
			}
		}
		
		public void removeNode(int value)
		{
			findAndRemoveNode(root, value);
		}
		
		private void findAndRemoveNode(Node node, int value)
		{
			if (node.value != value && node.left == null && node.right == null)
			{
				throw new RuntimeException("Value " + value + " is not found.");
			}
			
			if (node.value > value)
			{
				findAndRemoveNode(node.left, value);
			}
			else if (node.value < value)
			{
				findAndRemoveNode(node.right, value);
			}
			else if (node.value == value)
			{
				remove(node);
			}
		}
		
		private void remove(Node node)
		{
			if (node.left == null && node.right == null)
			{
				if (node.parent.left == node)
				{
					node.parent.left = null;
				}
				else
				{
					node.parent.right = null;
				}
			}
			else if (node.left != null && node.right == null)
			{
				if (node.parent.left == node)
				{
					node.parent.left = node.left;
				}
				else
				{
					node.parent.right = node.left;
				}
			}
			else if (node.right != null && node.left == null)
			{
				if (node.parent.left == node)
				{
					node.parent.left = node.right;
				}
				else
				{
					node.parent.right = node.right;
				}
			}
			else
			{
				Node temp = node.left;
				
				if (temp.right != null)
				{
					while (temp.right != null)
					{
						temp = temp.right;
					}
					node.value = temp.value;
					temp.parent.right = temp.left;
				}
				else
				{
					node.left = temp.left;
				}
			}
		}
		
		public boolean isBST()
		{
			if (root == null)
			{
				return false;
			}
			if (root.left == null && root.right == null)
			{
				return true;
			}
			
			return isBST(root.left, 0, root.value - 1) && isBST(root.right, root.value, Integer.MAX_VALUE);
		}
		
		private boolean isBST(Node node, int min, int max)
		{
			boolean leftValid = false;
			boolean selfValid = false;
			boolean rightValid = false;
			
			if (node == null)
			{
				return true;
			}
			
			leftValid = isBST(node.left, min, node.value - 1);
			
			if (node.value >= min && node.value <= max)
			{
				selfValid = true;
			}
			
			rightValid = isBST(node.right, node.value, max);
			
			return (leftValid && selfValid && rightValid);
		}
		
		public void traverse()
		{
			traverse(root);
		}
		
		private void traverse(Node node)
		{
			if (node.left != null)
			{
				traverse(node.left);
			}
			
			System.out.print(node.value + " ");
			
			if (node.right != null)
			{
				traverse(node.right);
			}
		}
	}
	
	public static Tree createTree(int ... array)
	{
		if (array.length < 1)
		{
			throw new RuntimeException("Array length < 1");
		}
		Tree tree = new Tree();
		tree.root = new Node(null, array[0]);
		
		if (array.length > 1)
		{
			int[] newArray = new int[array.length - 1];	
			System.arraycopy(array, 1, newArray, 0, newArray.length);
			tree.insertNode(newArray);
		}
		
		return tree;
	}

	public static void main(String[] args)
	{
		int[] array = {85, 86, 38, 7, 9, 26, 41, 46, 72, 15};
		System.out.println("input: ");
		for (int i : array)
		{
			System.out.print(i + " ");
		}
		Tree tree = createTree(array);
		System.out.println();
		System.out.println("traverse: ");
		tree.traverse();
		System.out.println();
		tree.removeNode(9);
		System.out.println("traverse again: ");
		tree.traverse();
		System.out.println("\nisBST = " + tree.isBST());
		
		
		tree = createTree(3);
		tree.root.left = new Node(tree.root, 2);
		tree.root.left.left = new Node(tree.root.left, 1);
		tree.root.left.right = new Node(tree.root.left, 4);
		tree.root.right = new Node(tree.root, 5);
		System.out.println("traverse: ");
		tree.traverse();
		System.out.println("\nisBST = " + tree.isBST());
	}
}


