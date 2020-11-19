import java.util.*;
public class AVLTreeRecursiveTry{
	static class Node{
		int data;
		Node left;
		Node right;
		int height;
		Node parent;
		Node(int data){
			this.data=data;
			left=right=parent=null;
			height=1;
		}
	}
	Node root;
	AVLTreeRecursiveTry(){
		root=null;
	}
	public int balanceFactor(Node x){
		if(x==null){
			return 0;
		}
		return height(x.left)-height(x.right);
	}
	public int height(Node a){
		if(a==null){
			return 0;
		}
		return a.height;
	}
	public Node rightRotate(Node z){
		// here root is grandfather
		Node y= z.left;
		String s="left";
		if( z.parent!=null &&z.parent.right==z ){
			s="right";
		}
		Node w=z.parent;
		Node t3= y.right;
		y.right=z;
		z.left=t3;
		
			z.parent=y;
		
		if(t3!=null){
			t3.parent=z;
		}
		// setting parent pointers above
		z.height=Math.max(height(z.left),height(z.right))+1;
		y.height=Math.max(height(y.left),height(y.right))+1;
		y.parent=w;
		if(s=="left"&&w!=null){
			w.left=y;
		}
		else if(w!=null &&s=="right"){
			w.right=y;
		}
		return y;

	}
	public Node leftRotate(Node z){
		Node y=z.right;
		String s="left";
		if( z.parent!=null &&z.parent.right==z  ){
			s="right";
		}
		Node w=z.parent;
		Node t3= y.left;
		y.left=z;
		
		z.right=t3;
		
			z.parent=y;
		
		if(t3!=null){
			t3.parent=z;
		}
		
		z.height=Math.max(height(z.left),height(z.right))+1;
		y.height=Math.max(height(y.left),height(y.right))+1;
		y.parent=w;
		if(s=="left"&&w!=null){
			w.left=y;
		}
		else if(w!=null&&s=="right"){
			w.right=y;
		}// assigning originals z parent child to y

		return y;
	}
	public Node search(int k){
		if (this.root==null){
			return null;
		}
		Node current =this.root;
		while(current!=null){
			if(current.data==k){
				return current;
			}
			if(current.data>k){
				current=current.left;
			}
			else{
				current=current.right;
			}
			
		}
		return null;
	}
	
	public void insert(int k){
		Node a= new Node (k);
		if(this.root==null){
			this.root=new Node(k);
			return ;
		}
		
		Node x=this.root;
		Node y=x;
		while(x!=null){
			if(x.data<k){
				y=x;
				
				
				x=x.right;
			}
			else if(x.data>k){
				y=x;
				
				x=x.left;
			}
		}
		Node t= new Node(k);
		if(y.data<k){
			y.right=t;	
			t.parent=y;
			y.height=Math.max(height(y.left),height(y.right))+1;
		}
		else{
			y.left=t;
			t.parent=y;
			y.height=Math.max(height(y.left),height(y.right))+1;
		}
		rebalance(y,k);

		
	}
	public void rebalance(Node y,int k){
		while(Math.abs(balanceFactor(y))<=1){
			if(y.parent==null){

				break;
			}
			y=y.parent;

			y.height=Math.max(height(y.left),height(y.right))+1;
		}
		
		if(Math.abs(balanceFactor(y))>1){
			rebalanceNode(y,k);
		return;
		}
		
	}
	public void rebalanceNode(Node r,int k){
		int c= balanceFactor(r);
		if(c <-1){
			if(k>r.right.data){
					if(r.parent==null){
						
						r=leftRotate(r);
						this.root=r;
						return;
					}
					r=leftRotate(r);
					return;
			}
			else{
				// taking if else conditon below to update root
				if(r.parent==null){
						r.right=rightRotate(r.right);
					r=leftRotate(r);
						this.root=r;
						return;
					}
					r.right=rightRotate(r.right);
				r=leftRotate(r);
				return;
				
			}
		}
		else if(c>1){
			if(k<r.left.data){
				if(r.parent==null){
						r=rightRotate(r);
						this.root=r;
						return;
					}
					r=rightRotate(r);
					return;
				
			}		
				else{
					if(r.parent==null){
						r.left=leftRotate(r.left);
				r=rightRotate(r);
						this.root=r;
						return;
					}
					r.left=leftRotate(r.left);
				r=rightRotate(r);
				return;
		}
		}
	}
	public Node findMinimumSucc(Node head){
		if(head.right==null){
			return null;
		}
		Node current=head.right;
		while(current.left!=null){
			current=current.left;
		}
		return current;
	}
	public static void changeRef(Node a,Node b){
		Node y=a.parent;
		if(a.parent.left==a){
			a.parent.left=b;
		}
		else{
			a.parent.right=b;
		}
		if(b!=null && y!=null){
			b.parent=y;
		}
	}
	public void delete(int k){
		if(this.root==null){
			return ;
		}
		Node a= search(k);
		Node y=a.parent;
		if(a.left==null){

			changeRef(a,a.right);
			y.height=Math.max(height(y.left),height(y.right))+1;
			rebalanceDelete(y,k);
			return;
		}
		if(a.right==null){
			changeRef(a,a.left);
			y.height=Math.max(height(y.left),height(y.right))+1;
			rebalanceDelete(y,k);
			
		}

	
	else{
			Node b=findMinimumSucc(a);

		a.data=b.data;
		Node m=b.parent;
			changeRef(b,b.right);
			m.height=Math.max(height(m.left),height(m.right))+1;
			rebalanceDelete(m,k);
			return;
		}
	
}
public void rebalanceDelete(Node y,int k){
		while(y.parent!=null){
			if(y.parent==null){

				break;
			}
			if(Math.abs(balanceFactor(y))>1){
			rebalanceNodeD(y,k);
		}
			y=y.parent;

			y.height=Math.max(height(y.left),height(y.right))+1;
		}
	
		
		if(Math.abs(balanceFactor(y))>1){
			rebalanceNodeD(y,k);
		}

		}
	
	public void rebalanceNodeD(Node y,int k){
		Node r=y;
		if(height(r.right)>height(r.left)){
			if(height(r.right.left)>height(r.right.right)){
				r.right=rightRotate(r.right);
				if(r.parent==null){
					r=leftRotate(r);
					this.root=r;
					return;
				}
				r=leftRotate(r);
				return;
			}
			else{
				if(r.parent==null){
					r=leftRotate(r);
					this.root=r;
					return;
				}
				r=leftRotate(r);
				return;


			}

		}
		else{
			if(height(r.left.left)<height(r.left.right)){
				r.left=leftRotate(r.left);
				if(r.parent==null){
					r=rightRotate(r);
					this.root=r;
					return;
				}
				r=rightRotate(r);
				return;
			}
			else{
				if(r.parent==null){
					r=rightRotate(r);
					this.root=r;
					return;
				}
				r=rightRotate(r);
				return;
			}
		}
		
}
public void preOrder(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.data+ " ");
		preOrder(root.left);
		preOrder(root.right);
		return;
	}
public static void main(String[] args) {
		AVLTreeRecursiveTry a= new AVLTreeRecursiveTry();
		a.insert(10);
		a.insert(20);
	
		a.insert(25);
		a.insert(30);
		a.insert(5);
		a.insert(6);
		a.insert(4);
		a.preOrder(a.root);
		System.out.println(" ");
		a.delete(20);


		
		a.preOrder(a.root);
	}


}


