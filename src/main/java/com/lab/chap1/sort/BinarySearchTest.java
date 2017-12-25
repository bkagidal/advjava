package com.lab.chap1.sort;

public class BinarySearchTest {

	public static void main(String[] args) {
	   
		int[] num={23,46,55,66,78,90,97,100};
		
	   int ans = binarySearch(90,num,0,num.length-1);
	   System.out.println(ans);
	   int ans1 = binarySearch(24,num,0,num.length-1);
	   System.out.println(ans1);
	   System.out.println(binarySearch(99,num,0,num.length-1));
	   System.out.println(binarySearch(46,num,0,num.length-1));
	}
	
	public static int binarySearch(int key,int[] list,int lo,int hi){
		
		
		
		while(lo <= hi){
			int mid =(lo+hi)/2;
			if(key == list[mid])
				return list[mid];
			
			if(key < list[mid]) 
				hi=mid-1;
			else 
				lo=mid+1;
		}
		
		return -1;
	}

}
