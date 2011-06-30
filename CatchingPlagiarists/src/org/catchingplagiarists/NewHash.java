package org.catchingplagiarists;

import java.util.*;
import java.io.*;
public class NewHash{
    TinyObj[] hashes = new TinyObj[4000000];
    TinyObj[] fittedHashes;
    Scanner S;
    LinkedList<String> queue;
    String chunk = "";
    int count = 0;
    String[] filesNames;
    int[][] hits;
    public NewHash(String[] files, String dirPath){
        filesNames = files;
        for(int i=0; i<filesNames.length; i++){
            
            if(!filesNames[i].startsWith(".") && !filesNames[i].startsWith("_")){
                try{
                    S = new Scanner(new File(dirPath+filesNames[i]));
                }
                catch(FileNotFoundException ex){
                    System.out.println("File Not Found");
                }
                queue = new LinkedList<String>();

                while(S.hasNext()){
                    String temp = S.next();
                    String nxt = temp.toUpperCase().replaceAll("[^A-Z]","");
                    queue.add(nxt);
                    if(queue.size() == 6){
                        queue.removeFirst();
                        for(String s: queue){
                            chunk = chunk+s;
                        }
                        int hashchunk = chunk.hashCode();
                        TinyObj data = new TinyObj(hashchunk, i);
                        hashes[count] = data;
                        count++;
                        chunk = "";
                        
                    }
                    
                }
                S.close();
            }
        }
        fittedHashes = new TinyObj[count];
        for(int i = 0; i<count; i++){
            fittedHashes[i] = hashes[i];
        }
        Arrays.sort(fittedHashes);
        
        
    }
    public int[][] countHits(){
        int length = filesNames.length;
        hits = new int[length][length];
        //int numSame;
        int j = 0;
        int i = 0;
        while(j<fittedHashes.length){
            i = j+1;
            
            while(i<fittedHashes.length &&fittedHashes[i].getHash() == fittedHashes[j].getHash()){
                i++;
            }
            if(i == fittedHashes.length) return hits;
            for(int k = j; k< i; k++){
                for(int l = k+1; l <i; l++){
                    int firstFile = fittedHashes[k].getFile();
                    int secondFile = fittedHashes[l].getFile();
                    hits[firstFile][secondFile]++;
                    hits[secondFile][firstFile]++;
                    //System.out.println("got a hit "+firstFile+" & "+secondFile);
                }
            }
            j=i;
            if(i == fittedHashes.length) return hits;
        }

        return hits;
    }
    public void countDups(){
       int count =0;
       for(int i=1; i<fittedHashes.length; i++){
           if(fittedHashes[i-1].getHash()==fittedHashes[i].getHash()){
               int fileA = fittedHashes[i-1].getFile();
               int fileB = fittedHashes[i].getFile();
               count++;
               System.out.println("HIT!  Between:"+filesNames[fileA]+" and "+filesNames[fileB]);
           }
       }

       System.out.println("total of "+count+" hits");
   } 
    // Prints all hit counts above 100
    public void printTop(){
        for(int i = 0; i<hits.length; i++){
            for(int k = i; k < hits[0].length; k++){
                if(!(i == k)){
                    int hitCount = hits[i][k];
                    if(hitCount > 100) System.out.println("The number of hits between "+filesNames[i]+" and "+filesNames[k]+" = "+hits[i][k]);
                }
            }
        }
        
    }
    public void print(){
    	for(int i = 0; i<hits.length; i++){
             for(int k = i; k < hits[0].length; k++){
                 if(!(i == k)){
                     System.out.println("The number of hits between "+filesNames[i]+" and "+filesNames[k]+" = "+hits[i][k]);
                 }
             }
         }
    }
    //Must have already called countHits
    public String toString(){
    	String allComps = "";
    	for(int i = 0; i<hits.length; i++){
             for(int k = i; k < hits[0].length; k++){
                 if(!(i == k)){
                     allComps = allComps +"\n The number of hits between "+filesNames[i]+" and "+filesNames[k]+" = "+hits[i][k];
                 }
             }
         }
    	return allComps;
    }
    
    public String toStringTops(){
    	String allComps = "";
    	for(int i = 0; i<hits.length; i++){
            for(int k = i; k < hits[0].length; k++){
                if(!(i == k)){
                    int hitCount = hits[i][k];
                    if(hitCount > 100) allComps = allComps +"\n The number of hits between "+filesNames[i]+" and "+filesNames[k]+" = "+hits[i][k];
                }
            }
        }
        return allComps;
    }
}