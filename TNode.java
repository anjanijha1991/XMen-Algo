package tree;

public class TNode<T> {
	T data;
	private TNode<T> left;
	private TNode<T> right;
	
	public TNode(T t){
		data = t; left=  null; right = null;
	}
	public void setLeft(TNode<T> l){
		left = l;
	}
	public void setRight(TNode<T> l){
		right = l;
	}
	public TNode<T> getLeft(){
		return left;
	}
	public TNode<T> getRight(){
		return right;
	}
	
	public String toString(){
		return data.toString();
	}
	public T add(T b){
		return (T) (Integer)( (Integer)data + (Integer)b );
	}
}
