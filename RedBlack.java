public class RedBlack{
	static class Node{
		int key;
		int value;
		Node left,right,parent;
		boolean black;
		public Node(int key,int value){
			this.key=key;
			this.value=value;
			left=right=parent=null;
			black=false;
			
		}
	}
	Node root;
	int size;
	RedBlack(){
		this.root=null;
		this.size=0;
	}
	public int height(){
		return height(this.root);
	}
	public int height(Node a){
		if(a==null){
			return 0;
		}
		int ld=height(a.left);
		int rd=height(a.right);
		if(ld>rd){
			return ld+1;
		}
		return rd+1;
	}
	public int blackNodes(Node a){
		if(a==null){
			return 0;
		}
		int l= blackNodes(a.left);
		int r= blackNodes(a.right);
		if(l!=r){
			System.out.println(" wrong tree");
			return -1;
		}
		if(a.black){
			l++;
		}
		return l+1;		
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
		y.parent=w;
		if(s=="left"&&w!=null){
			w.left=y;
		}
		else if(w!=null&&s=="right"){
			w.right=y;
		}// assigning originals z parent child to y
		return y;
	}
	public Node rightRotate(Node z){
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
		y.parent=w;
		if(s=="left"&&w!=null){
			w.left=y;
		}
		else if(w!=null &&s=="right"){
			w.right=y;
		}
		return y;
	}
	public void insert(int k,int v){
		Node a= new Node(k,v);
		if(root==null){
			root=a;
			root.black=true;
			size++;
			return;
		}
		insert(a);
	}
	public void insert( Node a){
		Node x=root;
		Node y=null;
		while(x!=null){
			if(x.key<a.key){
				y=x;
				x=x.right;
			}
			else if(x.key>a.key){
				y=x;
				x=x.left;
			}
			
		}
		if(y.key>a.key){
			y.left=a;
			a.parent=y;
			size+=1;
		}
		else if(y.key<a.key){
			y.right=a;
			a.parent=y;
			size+=1;
		}
		correctInsert(y,a);
	}
	public void correctInsert(Node y,Node a){
		if(y.black){
			return;
		}
		else{
			correctDoubleRedInsert(y,a);
		}
		// y is the node above inserted node
	}
	
	public void correctDoubleRedInsert(Node y,Node a){
		if (y.parent==null){
			
			this.root.black=true;
			this.root=y;
			return;
		}
		
		else{
			if(y.parent.left==y){
				if(y.parent.right==null || y.parent.right.black){

					if(y.key>a.key){
						y.black=true;
						y.parent.black=false;
						if(y.parent.left!=null){
							y.parent.left.black=false;
						}
						
						y=y.parent;
						y=rightRotate(y);
						if(y.parent==null){
							this.root=y;
							this.root.black=true;
						}
						return;
						
					}
					else{
						y.black=true;
						y.parent.black=false;
						if(y.parent.right!=null){
							y.parent.right.black=false;
						}
						
						y=y.parent;

						y.left=leftRotate(y.left);
						y=rightRotate(y);
						if(y.parent==null){
							this.root=y;
							this.root.black=true;
						}
					}

					

				}
				else{
					y.parent.black=false;
					y.black=true;
					y.parent.right.black=true;
					correctDoubleRedInsert(y.parent,y);
				}
			}
			else{
				if(y.parent.left==null ||y.parent.left.black){
					if(y.key<a.key){
						y.black=true;
						y.parent.black=false;
						if(y.parent.left!=null){
							y.parent.left.black=false;
						}
						y=y.parent;
						y=leftRotate(y);
						if(y.parent==null){
							this.root=y;
							this.root.black=true;
						}
						return;
					}
					else{
						y.black=true;
						y.parent.black=false;
						if(y.parent.left!=null){
							y.parent.left.black=false;
						}
						y=y.parent;

						y.right=rightRotate(y.right);
						y=leftRotate(y);
						if(y.parent==null){
							this.root=y;
							this.root.black=true;
						}

					}

				}
				else{
					y.parent.black=false;
					y.black=true;

					y.parent.left.black=true;
					correctDoubleRedInsert(y.parent,y);
				}
			}
		}
	}
	public void preOrder(Node root){
		if(root==null){
			return;
		}
		System.out.println(root.key+" "+ root.black);
		preOrder(root.left);
		preOrder(root.right);

	}
	public void search(Node root){
		`
	}
	public static void main(String[] args) {
		RedBlack a= new RedBlack();
		a.insert(7,2);
		a.insert(2,3);
		a.insert(3,4);
		a.insert(4,2);
		a.insert(-1,3);
		a.insert(-6,4);
		a.insert(-9,2);
		a.insert(10,3);
		a.insert(0,4);
		
		
		a.preOrder(a.root);
	}
}