package com.lab.chap2;

public class WordInfo {
	
	private String word;
	private int freq;
	
	WordInfo(){
		word="";
		freq=0;
	}
	
	WordInfo(String w,int f){
		this.word = w;
		this.freq = f;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	public void incrFreq(){
		++freq;
	}

}
