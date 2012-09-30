import java.util.LinkedList;


public class Main {
	public static void main(String[]args){
	//int[] a = {9,8,7,1,3,4,10};
		
		
	int[] a = {10,9,8,7,6,5,4,3,2,1};
	
	int tmp;
	boolean swp = false;
	
	do{
		swp = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i] > a[j]){
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					swp = true;
					System.out.println(a[j]);
				}
				
			}
			System.out.println(a[i]);
		}
		
		
	}while(swp);
	
	System.out.println();
	}
}
