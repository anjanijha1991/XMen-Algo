package tree;
import java.util.*;

public class Tree<T> {
	TNode<T> root;
	private int diameter;
	
	public int findDiameter(){
		diameter = 0;
		maxHeight(root);
		return diameter - 2;
	}
	
	public int maxHeight(TNode node){
		if(node == null)
			return 0;
		int maxHeight_left = maxHeight(node.getLeft());
		int maxHeight_right = maxHeight(node.getRight());
		
		if(diameter < maxHeight_left + maxHeight_right + 1)
			diameter = maxHeight_left + maxHeight_right + 1;
		
		if(maxHeight_left > maxHeight_right)
			return maxHeight_left + 1;
		else
			return maxHeight_right + 1;
	}
	
	public TNode<T> lca(T t1,T t2){
		
		Stack<TNode<T>> S = new Stack<TNode<T>>();
		TNode<T> R = root;
		TNode<T> temp = null;
		TNode<T> t1_foundAncestor = null;
		TNode<T> t2_foundAncestor = null;

		while(R == null || ((t1_foundAncestor == null || R.data != t2) && 
				(t2_foundAncestor == null || R.data != t1))){
			
			if(R != null){
				// Aw-some way of Testing your application...
				// System.out.print(R.data+"  ");
				S.push(R);
				if(R.data == t1)
					t1_foundAncestor = R;
				else if(R.data == t2)
					t2_foundAncestor = R;
				R = R.getLeft();
			}
			else{
				R = S.peek();
				if(R.getRight() != null){
					R = R.getRight();
				}
				else{
					temp = S.pop();
					if(temp == t1_foundAncestor)
						t1_foundAncestor = S.peek();
					else if(temp == t2_foundAncestor)
						t2_foundAncestor = S.peek();
					while(!S.isEmpty() && S.peek().getRight() == temp){
						temp = S.pop();
						if(temp == t1_foundAncestor)
							t1_foundAncestor = S.peek();
						else if(temp == t2_foundAncestor)
							t2_foundAncestor = S.peek();
					}
				R = S.peek().getRight();
				}
			}
		}
		if(t1_foundAncestor == null)
			return t2_foundAncestor;
		else
			return t1_foundAncestor;
	}
	
	public void printAllPaths(){
		if(root == null)
			return;
		Stack<TNode> S = new Stack<TNode>();
		TNode temp = root;
		System.out.println("All Paths are as follows : ");
		while(true){
			if(temp != null){
				S.push(temp);
				temp = temp.getLeft();
			}
			else{
				temp = S.peek();
				if(temp.getRight() != null)
					temp = temp.getRight();
				else{
					// Print if you are at leaf nodes.
					if(temp.getLeft() == null && temp.getRight() == null)
						print((List<T>) S);
					temp = S.pop();
					while(!S.isEmpty() && temp == S.peek().getRight())
						temp = S.pop();
					if(S.isEmpty())
						break;
					temp = S.peek().getRight();
				}
			}
		}
	}
	
	public TNode PathwithGivenSum(int sum){
		
		
		return root;
	}
	
	
	private void print(List<T> l){
		for(int i = 0; i < l.size() ; i++)
			System.out.print(l.get(i)+" ");
		System.out.println();
	}
}


