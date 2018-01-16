package com.lab.chap2;

import java.io.File;
import java.util.Scanner;


public class Voting {
	
	
	public static void main(String[] args) {
		
		  final int MAXCAND = 7;
		  
		  Person[] persons = new Person[MAXCAND+1];
		  Votes vts = new Votes(0, 0);
		  
		  try{
			  
			  Scanner scan = new Scanner(new File("persons.txt"));
			  
			  for(int v=1;v<MAXCAND+1;v++)
				  persons[v] = new Person(scan.next(),0);
			  
			  processVotes(persons,vts);
			  printInfo(persons,MAXCAND+1,vts);
			  printWinner(persons,1,MAXCAND);
			  scan.close();
		  
		  }catch(Exception e){
			  e.printStackTrace();
		  }

	}
	
	public static void printWinner(Person[] p,int lo,int hi){
		
		int large =lo;
		for(int v=lo+1;v<=hi;v++){
			if(p[v].numvotes >  p[large].numvotes)
				large = v;
		}
		
		System.out.println("\nWinners :");
		for(int i=lo;i<hi;i++){
			if(p[i].numvotes == p[large].numvotes){
				System.out.println(p[i].name+" "+p[i].numvotes);
			}
		}
		
			
	}
	
	public static void printInfo(Person[] p,int n,Votes vts){
		
		System.out.println("Total Number of Votes         :"+ (vts.valid+vts.spoiled));
		System.out.println("Total Number of Valid Votes   :"+vts.valid);
		System.out.println("Total Number of spoiled Votes :"+vts.spoiled);
		System.out.println("\n");
		for(int i=1;i<n;i++)
			System.out.println(p[i].name+"    "+p[i].numvotes);
	}
	
	public static  void processVotes(Person[] p,Votes vts){
		
		Scanner scan = new Scanner(System.in);
		
		
		try{
			
			System.out.println("Enter numbers in 1 to 7 followed by 0 to terminate :");
			int v= scan.nextInt();

			while(v!=0){
				
				if(v<1 || v>7){
					++vts.spoiled;
				}else{
					++vts.valid;
					++p[v].numvotes;
				}
				
				v = scan.nextInt();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		scan.close();
	}
	

}



class Person{
	
	String name;
	int numvotes;
	
	Person(String name,int n){
		
		this.name = name;
		numvotes = n;
		
      }
	
}


class Votes{
	
	int valid;
	int spoiled;

	Votes(int v,int s){
		this.valid = v;
		this.spoiled = s;
	}
}
