package org.catchingplagiarists;
import java.io.*;
import java.util.*;

public class Maintester{

		    ArrayList<String> files = new ArrayList<String>();
		    public static void main(String[] args){
		        
		        String dirPath = "big_doc_set/";
		        if(args.length==0) dirPath = "big_doc_set/";
		        else{
		            dirPath = args[0];
		        }
		        //1. Create a new File object
		        File someDir = new File(dirPath);
		        //2. If it's a directory, .list() will return an array of Strings
		        // each of which is some file that exists in the directory.
		        String[] files = someDir.list();
		        
		        System.out.println("Listing directory contents for:\n"+someDir.getAbsolutePath());
		        NewHash myCount = new NewHash(files, dirPath);
		        myCount.countHits();   
		        
		        myCount.printTop();
		        
		    }
		
			    

	}


