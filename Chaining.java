public class Chaining{
	static class Node{
		int data;
		Node next;
		Node(int k){
			this.data=k;
			this.next=null;
		}
	}
	private static Node [] a;
	Chaining(){
		a= new Node[10];
		for(int i=0;i<10;i++){
			a[i]=new Node(0);
		}
	}
	//sentinel node stored in array
	public static void insert(int k ){
		// no duplicate values we need to check so at end we insetrt and not at first
		int y=hash(k);
		if (a[y].next==null){
			a[y].next=new Node(k);
			return;
		}
		Node current=a[y].next;
		while(current.next!=null){
			if(current.data==k){
				System.out.println("element already present");
				return;
			}
			current=current.next;
		}
		current.next=new Node(k);

	}
	public static void delete(int k){
		//check empty
		// k is the value to be deleted
		int y= hash(k);
		if(a[y].next==null){
			System.out.println("element not present");
			return;
		}
		if(k==a[y].next.data){
			a[y].next=a[y].next.next;
			return;
		}
		Node current= a[y].next;
		Node previous=null;
		while (current.next!=null && current.data!=k){
			previous=current;
			current=current.next;
		}
		previous.next=current.next;
		return;

	}
	public static int hash(int k){
		return k%9;
	}
	public static void search(int k){
		int y= hash(k);
		if(a[y].next==null){
			System.out.println("element not present");
		}
		Node current=a[y].next;
		while(current!=null){
			if(current.data==k){
				System.out.println("element found");
				return;
			}
			current=current.next;
		}
		System.out.println("element not found");
		return;
	}
	public static void print( int k){
		
		int y=k;
		if(a[y].next==null){
			System.out.println("element not found with this key ");
			return;
		}
		Node current=a[y].next;
		while(current!=null){
			System.out.println(current.data+" ");
			current=current.next;
		}
		return;
	}
	public static void printHashTable(){
		for(int i=0;i<a.length;i++){
			
			
				Node current=a[i].next;
				while (current!=null){
					System.out.print(current.data+" ");
					current=current.next;
				
			}
			System.out.println(" ");
		}
		
	}
	public static void main(String[] args) {
		Chaining a= new Chaining();
		a.insert(0);
		a.insert(1);
		a.insert(2);
		a.insert(11);
		a.insert(13);
		a.insert(4);
		a.insert(6);
		a.insert(7);
		a.insert(9);
		a.insert(1);
		a.delete(1);
		a.delete(1);
		a.search(4);
		a.printHashTable();

	}
}