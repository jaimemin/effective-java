package com.tistory.jaimemin.effectivejava.ch05.item30.recursive_type_bound;

public class TreeNode<T> {

	private T data;

	private TreeNode<T> left;

	private TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
	}

	public static <T> void inOrderTraversal(TreeNode<T> node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		// 이진 트리 생성
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);

		// 중위 순회
		inOrderTraversal(root);
	}
}
