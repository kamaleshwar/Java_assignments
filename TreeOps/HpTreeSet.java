/*
 *HpTreeSet.java
 *
 * Version:
 *     $Id: YourCollections.java,v 1.7 10/19/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*This Program implements a Subset of a TreeSet present java collections
 *The implemented HpTreeSet has the following valid methods.
 *  boolean add(Object e)
 *  void clear()
 *  boolean contains(Object o)
 *  boolean isEmpty()
 *  Iterator  iterator()
 *  int size() 
 *The HpTree is implemented using AVL tree data structure.  
 */

import java.io.*;
import java.util.TreeSet;

//Declaring Node data structure in Node class 
//Data storage is of Object type

class Node {
	public Object data;
	public int height;
	public Node left;
	public Node right;

	public Node(Object id) // constructor
	{
		data = id;
		height = 0;
		left = null;
		right = null;
	}

} // end class Node

// Implementing HpTreeSet class

public class HpTreeSet<E> extends TreeSet<E> {

	private Node root; // first node of tree

	private Object[] arr; // Used by MyIterator

	private static int counter = 0;

	public HpTreeSet() { // constructor

		this.root = null;
		Object arr = new Object[1];

	} // no nodes in tree yet

	/**
	 * getRoot() This method returns root Node of the tree
	 * 
	 * @param :
	 * @return : Node
	 */

	public Node getRoot() {
		return root;
	}

	/**
	 * isEmpty() This method check id the tree is empty or not
	 * 
	 * @param :
	 * @return : Boolean.
	 */

	public boolean isEmpty() {

		if (this.getRoot() == null)
			return true;

		else
			return false;

	}

	/**
	 * clear() This method clears the Tree by setting root to null
	 * 
	 * @param :
	 * @return : void
	 */

	public void clear() {

		this.setRoot(null);

	}

	/**
	 * setRoot() This method sets the Root to passed Node
	 * 
	 * @param : Node
	 * @return : void
	 */

	private void setRoot(Node object) {
		this.root = object;

	}

	/**
	 * size() This method gets the total number of nodes of tree.
	 * 
	 * @param :
	 * @return :int Which is size of the tree
	 */

	public int size() {

		return this.sizeAll(this.getRoot());

	}

	/**
	 * sizeAll() This method is helper method to size() method.
	 * 
	 * @param :Node node root node of tree for which size is to be calculated.
	 * @return :int Which is size of the tree
	 */

	public int sizeAll(Node node) {

		if (node == null)
			return 0;
		else
			// size of left sub tree + size of right sub tree + root
			return 1 + sizeAll(node.left) + sizeAll(node.right);
	}

	/**
	 * contains() This checks whether the key passed is present or not
	 * 
	 * @param :Object This has the key to be searched for
	 * @return :Boolean Found:True Not-Found:False
	 */

	public boolean contains(Object key) {

		if (this.find(key, this.getRoot()) == null)
			return false;
		else
			return true;

	}

	// Recursive find to check contents of node with given key

	/**
	 * find() This method is helper method to contains() method.
	 * 
	 * @param :Object key Key to be searched for
	 * @param: Node node passing the root of the tree to be searched.
	 * @return :Node reference of found Node
	 */

	public Node find(Object key, Node node) {

		if (node == null)
			return null;

		else if (node.data.toString().compareTo(key.toString()) == 0)
			return node;

		else if ((node.data).toString().compareTo(key.toString()) < 0)
			return find(key, node.right);

		else
			return find(key, node.left);

	}

	/**
	 * height() This method returns the height of the node
	 * 
	 * @param :Node node of which height is to be found
	 * @return :int Height of the Node asked for
	 */

	public int height(Node x) {
		if (x == null)
			return -1; // Empty tree height is -1
		else
			return x.height; // Node property, it keeps height
	}

	/**
	 * add() This method adds the new node to the tree
	 * 
	 * @param :Object id The object to be added to tree
	 * @return :boolean Added True, NotAdded False
	 */

	public boolean add(Object id) // Recursive add
	{

		Node newNode = new Node(id); // make new node

		if (root == null) {

			// if tree is null adding object node will
			// become root

			root = newNode;
			return true;
		}

		else {

			// calling avlinsert method to add

			root = avlinsert(newNode, root);

			return true;
		}

	} // end add()

	/**
	 * rotatewithleft() This method is called to balance the avl tree when the
	 * not balanced conditions are met for left rotation
	 * 
	 * @param :Node c Node around which the rotation is done.
	 * @return :Node The balanced node
	 */

	public Node rotatewithleft(Node c) {
		Node p; // left child of c

		p = c.left;
		c.left = p.right;
		p.right = c;

		c.height = Math.max(height(c.left), height(c.right)) + 1;
		p.height = Math.max(height(p.left), height(p.right)) + 1;

		return p;

	}

	/**
	 * rotatewithright() This method is called to balance the avl tree when the
	 * not balanced conditions are met for right rotation.
	 * 
	 * @param :Node c Node around which the rotation is done.
	 * @return :Node The balanced node
	 */

	public Node rotatewithright(Node c) {

		Node p; // right child of c

		p = c.right;
		c.right = p.left;
		p.left = c;

		c.height = Math.max(height(c.left), height(c.right)) + 1;
		p.height = Math.max(height(p.left), height(p.right)) + 1;

		return p;

	}

	/**
	 * doublerotatewithleft() This method is called to balance the avl tree when
	 * the not balanced conditions are met for double rotation left
	 * 
	 * @param :Node c Node around which the rotation is done.
	 * @return :Node The balanced node
	 */

	public Node doublerotatewithleft(Node c) {

		Node tmp;

		c.left = rotatewithright(c.left);
		tmp = rotatewithleft(c);

		return tmp;

	}

	/**
	 * doublerotatewithright() This method is called to balance the avl tree
	 * when the not balanced conditions are met for double rotate right
	 * 
	 * @param :Node c Node around which the rotation is done.
	 * @return :Node The balanced node
	 */

	public Node doublerotatewithright(Node c) {

		Node tmp;

		c.right = rotatewithleft(c.right);
		tmp = rotatewithright(c);

		return tmp;

	}

	/**
	 * avlinsert() This method inserts the a new node by checking tree
	 * conditions and balances the tree if unbalanced
	 * 
	 * @param:Node newNode Node to be inserted
	 * @param:Node par First it is root then it is root of sub tree.
	 * @return:Node return new root of this subtree
	 * 
	 */

	public Node avlinsert(Node newNode, Node par) {

		Node newpar = par; // root of subtree par

		// If NewNode data less than par then add to left side

		if (newNode.data.toString().compareTo(par.data.toString()) < 0) {

			if (par.left == null) {

				par.left = newNode; // attach new node as leaf

			} else {

				par.left = avlinsert(newNode, par.left); // branch left

				if ((height(par.left) - height(par.right)) == 2) {

					if (newNode.data.toString().compareTo(
							par.left.data.toString()) < 0) {

						newpar = rotatewithleft(par);

					} else {

						newpar = doublerotatewithleft(par);

					}
				}
			}
		}

		// If NewNode data greater than par then add to right

		else if (newNode.data.toString().compareTo(par.data.toString()) > 0)

		{
			if (par.right == null) {

				par.right = newNode; // attach new node as leaf

			} else {

				par.right = avlinsert(newNode, par.right); // branch right

				if ((height(par.right) - height(par.left)) == 2) {

					if (newNode.data.toString().compareTo(
							par.right.data.toString()) > 0) {

						newpar = rotatewithright(par);

					} else {

						newpar = doublerotatewithright(par);

					}
				}
			}
		}

		else {

			// What if newNode data matches with existing node?

			// Do Nothing its a Duplicate Element : So Not Added.
		}

		// Update the height

		if ((par.left == null) && (par.right != null))
			par.height = par.right.height + 1;

		else if ((par.right == null) && (par.left != null))
			par.height = par.left.height + 1;

		else
			par.height = Math.max(height(par.left), height(par.right)) + 1;

		return newpar; // return new root of this subtree

	} // end avlinsert
	
	
	/**
	 * iterator()  method is called to iterate through the elements 
	 * of the set
	 * 
	 * @return: Iterator
	 * 		returns object of myIterator
	 */
	
	public java.util.Iterator<E> iterator() {
		counter = 0;
		inOrderTraversal(this.getRoot());
		return new MyIterator(arr);
	}
	
	/**
	 * inOrderTraversal()  method will traverse through the tree in order
	 * and adds each node values to the array.
	 * @param 
	 *  	currNode is the root node from which traversal begins
	 *  @return: void
	 */
	
	public void inOrderTraversal(Node currNode) {
		if (currNode != null) {
			inOrderTraversal(currNode.left);
			FillArray(currNode.data);
			inOrderTraversal(currNode.right);

		}
	}
	
	/**
	 * FillArray() method adds elements to the array each time called 
	 * during the in order traversal of the tree
	 * @param data
	 *  	data is the value of the node to be added
	 *  @return: void
	 */
	
	public void FillArray(Object data) {

		if (arr == null) {
			arr = new Object[1];
		}

		if (counter >= arr.length) {
			int newSize = 2 * arr.length;
			if (counter >= newSize) {
				newSize = 2 * counter;
			}
			Object[] newData = new Object[newSize];
			System.arraycopy(arr, 0, newData, 0, arr.length);
			arr = newData;
		}
		arr[counter++] = data;
		
	}

}
