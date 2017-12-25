package com.lab.chap1.sort;

public class SortStrings {

	public static void main(String[] args) {
		
		String[] names={"Hima","Bala","Saatvik","Bhanu","Kinnu","Deepti"};
		
		insertionSort3(names, 0, names.length-1);
		
		for(int i=0;i<names.length;i++)
		System.out.println(names[i]);
	}
	
	public static void insertionSort3(String[] list,int lo,int hi){
		
		for(int h=lo+1;h<=hi;h++){
			
			String key = list[h];
			int k=h-1;
			while(k>=lo && key.compareToIgnoreCase(list[k])<0){
				list[k+1]=list[k];
				k--;
			}
			
			list[k+1]=key;
		}
		
	}

}
