package tree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Lca_Compute {
	
	public static void main(String[] args) {
		
		Tree<Integer> tree = new Tree<Integer>();
		
		tree.root = new TNode<Integer>(1);
		tree.root.setLeft(new TNode<Integer>(2));
		tree.root.setRight(new TNode<Integer>(3));
		tree.root.getLeft().setLeft(new TNode<Integer>(4));
		tree.root.getLeft().setRight(new TNode<Integer>(5));
		tree.root.getRight().setLeft(new TNode<Integer>(6));
		tree.root.getLeft().getRight().setRight(new TNode<Integer>(7));
		
		System.out.println("Diameter is : "+tree.findDiameter());
		System.out.println("Least common ancestor of 4 and 5 is : "+tree.lca(4, 5).data);
		System.out.println("Least common ancestor of 5 and 6 is : "+tree.lca(5, 6).data);
		tree.printAllPaths();
		
	}
}
