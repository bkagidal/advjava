package com.lab.sort;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordFrequency {

	public static void main(String[] args) {
		
		int MaxWords=50;
		try{
			
			File file = new File("/Users/himavarshakagidala/git/AdvJava/advjava/src/main/java/passage.txt");
			PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
			Scanner scanFile = new Scanner(new FileReader(file));
			String[] wordslist = new String[MaxWords];
			int[] frequency = new int[MaxWords];
			
			for(int v=0;v<MaxWords;v++){
				wordslist[v]="";
				frequency[v]=0;
			}
			
			String word;
			int numWords=0;
			while(scanFile.hasNext()){
				word=scanFile.next().replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase().toString();
				
				int loc = binarySearch(word,wordslist,0,numWords-1);
				
				if(word.compareTo(wordslist[loc]) == 0)
					   ++frequency[loc];
				else{
						if(numWords < MaxWords){
							addWord(word,wordslist,frequency,loc,numWords-1);
							++numWords;
						}else{
							System.out.println(word + " Not added to list");
						}
				}
					
				
				
			}
			
			for(int v=0;v<numWords;v++)
				System.out.println(wordslist[v]+" "+frequency[v]);
			
			printResults(out, wordslist, frequency, numWords);
			
			scanFile.close();
			out.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void printResults(PrintWriter out,String[] list,int[] freq,int n){
		out.printf("\nWords             Frequency\n\n");
		for(int v=0;v<n;v++)
			 out.printf("%-20s %2d\n", list[v], freq[v]);
		
		
	}
	public static void addWord(String word,String[] list,int[] freq,int p,int numWords){
		
		for(int h=numWords;h>=p;h--){
			list[h+1]=list[h];
			freq[h+1] = freq[h];
		}
		
		list[p] = word;
		freq[p]=1;
		
	}
	
	public static int binarySearch(String key,String[] list,int lo,int hi){
		
		while(lo<=hi){
			int mid = (lo+hi)/2;
			
			int cmp = key.compareTo(list[mid]);
			
			if(cmp == 0)
				return mid;
			else if(cmp<0)
				hi = mid-1;
			else
				lo=mid+1;
		}
		
		return lo;
	}
	
	public static String getWord(Scanner scan){
		while(scan.hasNext()){
			return scan.next().replaceAll("[^a-zA-Z0-9]", "").trim().toString();
		}
		return null;
	}

}
