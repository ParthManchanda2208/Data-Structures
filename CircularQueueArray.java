import java.util.*;
public class CircularQueueArray{
	ArrayList<Integer> a;
	static int f,r,size;
	CircularQueueArray(int size){
		this.f=this.r=-1;
		this.size=size;
		a=new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			a.add(-10000);
		}

	}
	public static boolean isEmpty(){
		if(f==r){
			return true;
		}
		return false;
	}
	public void enQueue(int k){
		if(f==r){
			f=(f+1)%size;
			
				a.set(f,k);
				r=(f+1)%size;
			
				
			
		}
		else if(f==0 && r==size-1){
			System.out.println("queue full");
			return;
		}
		else if((r==(f-1)%(size-1))){
			System.out.println("queue full");
			return;
		}
		/*else if(r==size-1 && f!=0 ){
			
			a.set(r,k);
			r=(r+1)%(size);
		}*/
		else{
			
			a.set(r,k);
			r=(r+1)%size;		}


	}

	public int deQueue(){
		int x;
		
		if(a.isEmpty()){
			System.out.println("queue is empty");
			return -1;
		}
		x=a.get(f);
		 /*if(f==r-1){
			f=f+1;
			r=f;
		}*/ //deleting if one elemet only check while testing

		if(f==size-1){
			f=0;
		}
		else{
			f=(f+1)%size;

		}

		return x;
	}
	public void displayQueue(){
		if(a.isEmpty()){
			System.out.println("queue empty");
			return;
		}
		if(f<r){
			for(int i=f;i<r;i++){
				System.out.print(a.get(i)+" ");
			}
			System.out.println(" ");
			return;
		}
		else if (f>r){
			for(int i=f;i<=size-1;i++){
				System.out.print(a.get(i)+" ");
			}
			for(int j=0;j<r;j++){
				System.out.print(a.get(j));

			}
			System.out.println(" ");
			return;
		}
	}
	public static void main(String[] args) {
		CircularQueueArray q= new CircularQueueArray(6);
		System.out.println(q.isEmpty());
		q.enQueue(14); 
		System.out.println(q.isEmpty());
		
    q.enQueue(22);
    
    q.enQueue(13); 
    q.enQueue(-6);
    q.displayQueue(); 
    q.enQueue(-4);
    q.enQueue(-3);
    q.displayQueue();
    q.deQueue();
    q.enQueue(-3);  
      
    q.displayQueue(); 
  
    int z= q.deQueue(); 
    q.displayQueue();

  
    
    
  
    
	}
}