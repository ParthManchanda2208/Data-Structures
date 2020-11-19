public class CircularLinkedList{
	class Node{
		int data;
		Node next;
		Node(int k){
			this.data=k;
			this.next=null;
		}
	}
	Node head;
	int size;
	CircularLinkedList(){
		this.head=null;
		size=0;
	}
	public void enQueue(int k){
		/*instead of seeting new node at first place will tae O(n) time i e=repace head data woth
		k and add new node  containing head original data at next*/
		Node a= new Node(k);
		if(head==null){
			head=a;
			head.next=head;
			size+=1;
		}
		else{
			int temp=head.data;

			head.data=k;

			a.next=head.next;
			head.next=a;
			a.data=temp;
			size+=1;

		}
	}
	public int deQueue(){
		int x;
		if(head==null){
			System.out.println("empty queue");
			return -1;
		}
		else{
			Node current=head;
			Node previous=null;
			while(current.next!=head){
				previous=current;
				current=current.next;
			}
			if(previous==null){
				x=head.data;
				head=null;
				
			}
			else{
				x=current.data;
				previous.next=current.next;
			}

		}
		size-=1;
		return x;

	}
	public void printx(){
		if(head==null){
			System.out.println("empty");}
		else{
			Node current=head;

			while(current.next!=null){
				if(current.next==head){
					System.out.print(current.data+" ");
					return;
				}
				else{System.out.print(current.data+" ");
				current=current.next;}
				
			}
		}


	}

	public boolean isEmpty(){
		return size==0;
	}
	public static void main(String[] args) {
		CircularLinkedList a= new CircularLinkedList();
		System.out.println(a.isEmpty());
		a.enQueue(1);
		System.out.println(a.deQueue());
		a.enQueue(2);
		a.enQueue(3);
		a.enQueue(5);
		a.enQueue(1);





















































































		
		System.out.println(a.deQueue());
		System.out.println(a.isEmpty());
		System.out.println(a.deQueue());
		a.enQueue(1);
		a.printx();
		a.deQueue();
		a.deQueue();
		System.out.println("");
		a.printx();
		




	}
	
		}
