// i am writing sinle code for linear probind and double hashing
// just convert hash2 to 1 for linear probing
public class LinearProbing{
	int [] a;
	int [] deleted;// 1 when element deleted
	//int [] inserted;// where elements are presently there
	LinearProbing(){
		a= new int[13];
		for(int i=0;i<13;i++){
			a[i]=-1;
		}
		deleted= new int[13];
		for(int i=0;i<13;i++){
			deleted[i]=0;
		}
		//inserted= new int[13];	
	}
	public static int hash1(int x){
		return x%13;
	}
	public static int hash2(int x){
		return (8-(x%8));
	}


	public void insert(int k){
		int y=hash1(k);
		int x= hash2(k);
		if(a[y]==-1){
			a[y]=k;
			deleted[y]=0;
			return;
		}
		else{
			y=(y+x)%13;
			while(deleted[y]!=1 && a[y]!=-1 ){
				y=(y+x)%13;

			}
			a[y]=k;// updating the array
			deleted[y]=0; // removing tombstone
		}
	}
	public void print(){
		for(int i=0;i<13;i++){
			System.out.print(a[i]+ " ");
		}
	}
	public void delete( int k){
		int y=hash1(k);
		int x= hash2(k);
		if(a[y]==k){
			// if yth element is to be deleted
			 // setting he array back to -1
			deleted[y]=1;// adding tombstone
		}
		else{
			//moving along the array
			y=(y+x)%13;
			while(a[y]!=k){
				if(a[y]==-1){
					break;
				}
				y=(y+x)%13;
			}
			
			deleted[y]=1;
		}
	}
	public boolean search(int k){
		int y=hash1(k);
		int x= hash2(k);
		if(a[y]==k && deleted[y]==0){
			return true;
		}
		else{
			//moving along the array
			y=(y+x)%13;
			while(a[y]!=k){
				if(a[y]==-1){
					return false;
				}
				y=(y+x)%13;
			}
			
		}
		if(deleted[y]==1){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		
		LinearProbing a= new LinearProbing();
		a.insert(18);
		a.insert(41);
		a.insert(22);
		a.insert(44);
		a.insert(59);
		a.insert(32);
		a.insert(31);
		a.insert(73);
		a.print();
		a.delete(73);
		a.print();
		System.out.println(a.search(73));
		System.out.println(a.search(59));

	}
}