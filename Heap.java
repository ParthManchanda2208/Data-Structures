public class Heap{
	private int[] heap;
	private int size;
	private int maxsize;
	Heap(int maxsize){
		this.maxsize=maxsize;
		heap= new int[maxsize];
		size=0;

	}
	public static int parent(int i){
		return (i)/2;
		// returns index of parent
	}
	public static int leftChild(int i){
		return 2*i+1;
	}
	public static int rightChild(int i){
		return 2*i+2;
	}
	public void swap(int i,int j){
		int temp=this.heap[j];
		this.heap[j]=this.heap[i];
		this.heap[i]=temp;
		return;
	}
	public void insert(int k){
		if(size<maxsize){
			this.heap[size]=k;
			int current=size;
			size+=1;
			while(current>=0 && this.heap[current]<this.heap[parent(current)] ){
				swap(current,parent(current));
				current=parent(current);
			}
		}
		else{
			System.out.println("full");
			return;
		}
	}
	public void heapify(int i){
		// we swap with smaller child
		
		int l=leftChild(i);
		int r=rightChild(i);
		int min=i;
		if(l<size && r<size){
			if(this.heap[l]<this.heap[min]){
				min=l;
			}
			if(this.heap[r]<this.heap[min]){
				min=r;
			}
			if(min==r){
				swap(min,i);
				heapify(r);
			}
			else{
				swap(min,i);
				heapify(l);
			}

		}
		else if (l<size && r>=size){
			if(this.heap[l]<this.heap[min]){
				min=l;
			}
			swap(min,i);
			heapify(l);
		}
		else if(r<size && l>=size){
			if(this.heap[r]<this.heap[min]){
				min=r;
			}
			swap(min,i);
			heapify(r);
		}
		else{
			return;
		}
	}
	public int deleteMin(){
		int x=-1;
		if(size>0){
			x=this.heap[0];
			swap(0,size-1);
			this.heap[size-1]=0;
			size-=1;
		heapify(0);
		return x;
		}
		else{
			return -1;
		}
	}
	public void heapifyheapsort(int[] arr, int n,int i){
		int smallest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] <arr[smallest])
            smallest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] <arr[smallest])
            smallest = r;
 
        // If largest is not root
        if (smallest != i) {
            int swap=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=swap;
 
            // Recursively heapify the affected sub-tree
            heapifyheapsort(arr, n, smallest);
        }
	}
	public int[] heapSort(int[] arr){
		int n= arr.length;
		for(int i=n/2;i>=0;i--){
			heapifyheapsort(arr,n,i);
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");

		}
		System.out.println("");
		for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            
            heapifyheapsort(arr, i, 0);
        }
		return arr;
		
	}
	public void print() 
    { 
        for (int i = 0; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + this.heap[i] 
                             + " LEFT CHILD : " + this.heap[2 * i+1] 
                             + " RIGHT CHILD :" + this.heap[2 * i + 2]); 
            System.out.println(); 
        } 
    } 
	public static void main(String[] arg) 
    {  	Heap minHeap = new Heap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.deleteMin()); 
        minHeap.print();
        int[] a= {5,3,17,10,84,19,6,22,9};
        a=minHeap.heapSort(a);
        for(int i=0;i<a.length;i++){
        	System.out.println(a[i]);
        }
    } 
}