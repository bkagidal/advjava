package com.lab.chap2;

import java.io.File;
import java.util.Scanner;

public class WordFrequency {

	private static int MAXWORDS = 50;

	public static void main(String[] args) {

		String word;
		String regex = "[^a-zA-Z0-9]";

		try {

			Scanner scan = new Scanner(new File("passage2.txt"));

			WordInfo[] wordtable = new WordInfo[50];
			int loc;
			int numword = 0;
			for (int i = 0; i < MAXWORDS; i++)
				wordtable[i] = new WordInfo("", 0); // Initialize with empty
													// String and 0 frequency

			/*
			 * get word from file search in table if it exists increase freq
			 * else add to table in proper place
			 */
			while (scan.hasNext()) {

				word = scan.next();
				// if(word!=""){
				word = word.replaceAll(regex, "").trim().toLowerCase().toString();

				if (!word.equals("")) {
					loc = binarySearch(word, wordtable, 0, numword - 1);

					if (word.compareTo(wordtable[loc].getWord()) == 0)
						wordtable[loc].incrFreq();
					else {
						if (numword < MAXWORDS) {
							addToList(word, wordtable, loc, numword - 1);
							++numword;
						} else {
							System.out.println(word + " Not added to list");
						}
						// System.out.println(word);
					}
				}

			}

			/*
			 * for(int i=0;i<numword;i++)
			 * swap(i,getSmallest(i,i+1,numword,wordtable),wordtable);
			 */

			for (int i = 0; i < numword; i++)
				System.out.println(wordtable[i].getWord() + " " + wordtable[i].getFreq());

			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void swap(int i, int j, WordInfo[] table) {
		String hold = table[i].getWord();
		table[i].setWord(table[j].getWord());
		table[j].setWord(hold);
	}

	public static int getSmallest(int lo, int k, int hi, WordInfo[] table) {

		int small = lo;

		for (int i = k; i < hi; i++) {
			if (table[i].getWord().compareToIgnoreCase(table[small].getWord()) < 0)
				small = i;
		}

		return small;

	}

	private static void addToList(String w, WordInfo[] table, int p, int hi) {

		for (int h = hi; h >= p; h--) {
			table[h + 1] = table[h];
		}

		table[p] = new WordInfo(w, 1);

		// table[h+1] = table[h];

	}

	public static int binarySearch(String key, WordInfo[] list, int lo, int hi) {
		// search for key from list[lo] to list[hi]
		// if found, return its location;
		// if not found, return the location in which it should be inserted
		// the calling program will check the location to determine if found
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int cmp = key.compareToIgnoreCase(list[mid].getWord());
			if (cmp == 0)
				return mid; // search succeeds
			if (cmp < 0)
				hi = mid - 1; // key is 'less than' list[mid].word
			else
				lo = mid + 1; // key is 'greater than' list[mid].word
		}
		return lo; // key must be inserted in location lo
	} // end binarySearc

}
