package Tree;

import java.util.ArrayList;
import java.util.List;

public class treeNode<T> {
	public T t;
	private treeNode<T> parent;
	public List<treeNode<T>> nodelist;
	
	public treeNode(T stype){
		t= stype;
		parent = null;
		nodelist = new ArrayList<treeNode<T>>();//这个nodelist就相当于是一个node的平行节点
	}
	
	public treeNode<T> getParent(){
		if(null!= parent) return parent;
		else{ 
			System.err.println("parent节点为空！");
			return null;
		}
	}
	
	public void setParent(treeNode<T> node){
		parent = node;
	}
	
	public static void main(String[] args) {
		tree<String> tree = new tree();
		         tree.addNode(null, "Document");
		         tree.addNode(tree.getNode("Document"), "hello");
		         tree.addNode(tree.getNode("Document"), "world");
		         tree.addNode(tree.getNode("hello"), "sinny");
		         tree.addNode(tree.getNode("hello"), "fredric");
		         tree.addNode(tree.getNode("world"), "Hi");
		         tree.addNode(tree.getNode("world"), "York");
		         tree.deleteNode("hello");
		         tree.showNode(tree.root);
		//System.err.println(tree.getNode("Document").getParent().t);
	}
}
