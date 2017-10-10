package Tree;

import java.util.List;

public class tree<T> {
	public treeNode<T> root;

	public tree() {
	}

	public void addNode(treeNode<T> node, T newNode) {
		// 增加根节点
		if (null == node) {
			if (null == root)
				root = new treeNode(newNode);
		} else {
			treeNode<T> temp = new treeNode(newNode);
			temp.setParent(node);
			node.nodelist.add(temp);
		}
	}
	
	/* 查找newNode这个节点 */
	public treeNode<T> search(treeNode<T> input, T newNode) {
		treeNode<T> temp = null;
		if (input.t.equals(newNode))
			return input;
		for (int i = 0; i < input.nodelist.size(); i++) {
			temp = search(input.nodelist.get(i), newNode);
			if (null != temp)
				break;

		}
		return temp;
	}

	public treeNode<T> getNode(T newNode) {
		return search(root, newNode);
	}
	
	public void deleteNode(T node){
		treeNode<T> temp = getNode(node);
		List<treeNode<T>> nodelist = temp.getParent().nodelist;
		for(treeNode<T> node2:nodelist){
			if (temp.equals(node2)) {
				/*这样删除虽然在逻辑上不会有什么问题，是因为不可能再通过树搜索到该结点，或者该结点下面的结点，但是
				 * 有个问题，就是node下面的节点，依旧有一个nodelist存储着东西，却没有将其删除，感觉会出事。
				 */
				nodelist.remove(node2);
				break;
			}
		}
	}
	
	public void showNode(treeNode<T> node) {
		if (null != node) {
			// 循环遍历node的节点
			System.out.println(node.t.toString());

			for (int i = 0; i < node.nodelist.size(); i++) {
				showNode(node.nodelist.get(i));
			}
		}
	}
}
