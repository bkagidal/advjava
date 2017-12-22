package com.lab.sort;

public class MergeTest {

	public static void main(String[] args) {
		
		int[] A={20,35,46,57,60,65};
		int[] B={5,22,37,63};
		
		int cs = A.length+B.length;
		int[] C = new int[cs];
		
		merge(A,A.length,B,B.length,C);
		
		System.out.println("Sorted Elements :");
			for(int i=0;i<C.length;i++)
				System.out.print(C[i]+" ");
		
		
	}
	
	public static void merge(int[] A,int as,int[] B,int bs, int[] C){
		
		int i=0;
		int j=0;
		int k=-1;
		while(i<as && j < bs){
			if(A[i]<B[j])
				C[++k] = A[i++];
			else
				C[++k] = B[j++];
		}
		
		if(i == as){
			
			for( ;j<bs;j++) 
				C[++k] = B[j++];
			
		}else{
			for( ;i<as;i++) 
				C[++k] = A[i++];
		}
			
			
	}

}
