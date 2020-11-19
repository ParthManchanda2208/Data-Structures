import java.util.*;

// add parent to all
public class BinarySearchTreeParent{
	static class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		Node(int data){
			this.data=data;
			this.parent=null;
			this.left=this.right=null;
		}
	}
	Node root;
	BinarySearchTreeParent(){
		root=null;
	}
	public void insert(int k){
		
		if(this.root==null){
			this.root= new Node(k);
			return ;

		}
		else{
		Node x=this.root;
		Node y=null;
		while(x!=null){
			y=x;
			if(x.data>k){
				x=x.left;
			
			}
			else{
				x=x.right;
			}
		}
		Node d= new Node(k);
		if(y.data>d.data){
			y.left=d;
			d.parent=y;
		}
		else{
			y.right=d;
			d.parent=y;
		}
	}
		
	return;
}
	public void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		return;
	}
	/*returns node if present else returns null*/
	public int sum(Node head){
	if (head==null){
		return 0;
	}
	return sum(head.left)+sum(head.right)+head.data;
}
	public int height(Node head){
		if(head==null){
			return 0;
		}
		int ld=height(head.left);
		int rd= height(head.right);
		return Math.max(ld,rd)+1;
	}
	public void bfs(Node b){
		ArrayList<Node> a= new ArrayList<Node>();
		a.add(b);
		while(a.size()>0){
			System.out.print(a.get(0).data+" ");
			Node temp= a.get(0);
			a.remove(0);
			if(temp.left!=null){
				a.add(temp.left);
			}
			if (temp.right!=null){
				a.add(temp.right);
			}
			
		}
		System.out.println(" ");
		return;
	}
	public void delete(int key){
		
		Node a= search(this.root,key);

		if(a.left==null){
			changeRef(a,a.right);
			return;
		}
		if(a.right==null){
			changeRef(a,a.left);
			return;
		}
		else{
			Node b=findMinimumSucc(a);
		a.data=b.data;
		if(b.right!=null){
			Node x=b.right;
			changeRef(b,null);	
			if(b.parent.data>b.right.data){
				b.parent.left=b.right;

			}
			else{
				b.parent.right=b.right;
			}
		}
		else{
			changeRef(b,null);
		}
		
		}
		
}
	public Node search(Node a,int k){
		if (a==null){
			return null;
		}
		if(a.data>k){
			return search(a.left,k);
		}
		if(a.data<k){
			return search(a.right,k);
		}
		return a;	
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
	public Node successor(int k){
		Node a= search(this.root,k);
		Node b=findMinimumSucc(a);
		Node y;
		if(b!=null){
			return b;
		}
		
		else{
			y= a.parent;
		while(y.left!=a){
			a=y;
			y=y.parent;
		}
	}
		return y;
	}
	public Node findMinimumPre(Node head){
		if(head.left==null){
			return null;
		}
		Node current=head.left;
		while(current.right!=null){
			current=current.right;
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
		if(b!=null){
			b.parent=y;
		}
		return;
	}
	public Node predecessor(int k){
		Node a = search(root,k);
		Node b=findMinimumPre(a);
		Node y;
		if(b!=null){
			return b;
		}
		else{
		y= a.parent;
		while(y.right!=a){
			a=y;
			y=a.parent;
		}
	}
		return y;
	}
	
	public void spiralTraversal(Node head){
		
		if (head == null) 
            return; // NULL check 
  
        // Create two stacks to store alternate levels 
        // For levels to be printed from right to left 
        Stack<Node> s1 = new Stack<Node>();  
        // For levels to be printed from left to right 
        Stack<Node> s2 = new Stack<Node>();  
  
        // Push first level to first stack 's1' 
        s1.push(head); 
  
        // Keep printing while any of the stacks has some nodes 
        while (!s1.empty() || !s2.empty()) { 
            // Print nodes of current level from s1 and push nodes of 
            // next level to s2 
            while (!s1.empty()) { 
                Node temp = s1.peek(); 
                s1.pop(); 
                System.out.print(temp.data + " "); 
  
                // Note that is right is pushed before left 
                if (temp.right != null) 
                    s2.push(temp.right); 
  
                if (temp.left != null) 
                    s2.push(temp.left); 
            } 
  
            // Print nodes of current level from s2 and push nodes of 
            // next level to s1 
            while (!s2.empty()) { 
                Node temp = s2.peek(); 
                s2.pop(); 
                System.out.print(temp.data + " "); 
  
                // Note that is left is pushed before right 
                if (temp.left != null) 
                    s1.push(temp.left); 
                if (temp.right != null) 
                    s1.push(temp.right); 
            } 
        } 
        return;
	}	
	
	public static void main(String[] args) {
		BinarySearchTreeParent x= new BinarySearchTreeParent();
		
		x.insert(8);
		x.insert(3);
		x.insert(10);
		x.insert(1);
		x.insert(6);
		x.insert(4);
		x.insert(7);
		x.insert(14);
		x.insert(13);
		x.insert(15);
		
		x.bfs(x.root);
		
		x.delete(14);
		x.bfs(x.root);

		
	}
		
}