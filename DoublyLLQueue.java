public class DoublyLLQueue{
	static class Node{
		int data;
		Node prev;
		Node next;
		Node(int data){
			this.next=this.prev=null;
			this.data=data;
		}
	}
	
	Node head;
	Node tail;
	int size;
	DoublyLLQueue(){
		head=new Node(0);
		head.next=head;
		head.prev=head;
		tail=new Node(0);
		tail.next=tail.prev=tail;
	}

	public void insertFront(int k){
		Node a= new Node(k);
		if(isEmpty()){
			head.next=a;
			
			tail.prev=a;
		}
		else{
			a.next=head.next;
			head.next.prev=a;
			head.next=a;
			a.prev=head;
		}
		size+=1;
	}
	public void insertRear(int k){
		Node a = new Node(k);
		if(isEmpty()){
			head.next=a;
			tail.prev=a;
		}
		else{
			a.prev=tail.prev;
		tail.prev.next=a;
		tail.prev=a;
		a.next=tail;
		}
		size+=1;
		
	}
	public int deleteFront(){
		int x;
		if(head.next==null){
			System.out.println("empty");
			return -1;
		}
		else{
			x=head.next.data;
			head.next=head.next.next;
			head.next.prev=head;
			size-=1;
		}
		return x;
	}
	public int deleteRear(){
		int x;
		if(head.next==null){
			System.out.println("empty");
			return -1;
		}
		else{
			x=tail.prev.data;
			tail.prev=tail.prev.prev;
			tail.prev.next=tail;
			size-=1;
		}
		return x;

	}
	public int getFront(){
		
		if(head.next==null){
			System.out.println("stack is empty");
			return -1;
		}
		
			return(head.next.data);
		
		
	}
	public int getRear(){
		
		if(tail.prev==null){
			System.out.println("stack is empty");
			return -1;
		}
		
			return(tail.prev.data);
		
		
	}
	public boolean isEmpty(){
		return head.next==null;
	}
	public int size(){
	return size;
	}

	public static void main(String[] args) {
		DoublyLLQueue a= new DoublyLLQueue();
		a.insertFront(2);
		a.insertFront(1);
		a.insertFront(0);
		a.insertFront(6);
		a.insertRear(20);
		System.out.println(a.getRear());
		System.out.println(a.getFront());
		a.insertRear(5);
		System.out.println(a.deleteRear());
		System.out.println(a.size());
		System.out.println(a.deleteFront());
		System.out.println(a.size());

	}
}