package ProgramacionIII.tp2;

public class TreeNode {

	private int value;
	private TreeNode left;
	private TreeNode right;
	private TreeNode padre; // agregado por mi

	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.padre= null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value){
		this.value=value;
	}

	public TreeNode getPadre() {
		return padre;
	}

	public void setPadre(TreeNode padre) {
		this.padre = padre;
	}
}
