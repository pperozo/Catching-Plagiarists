package org.catchingplagiarists;

public class TinyObj implements Comparable<Object>{
	 public int hash;
	 public int file;
	 public String chunk;

	 public TinyObj(){ hash=-1; file=-1; }

	 public TinyObj(int h, int f, String c){ hash=h; file=f; chunk=c;}
	 public TinyObj(int h, int f){ hash=h; file=f; chunk=null;}
	 
	 public int compareTo(Object other){
	     if(other==null){
	         System.out.println("HEY!!!! NULL OBJECT!!!! in file "+file+", "+chunk);
	        }
	     TinyObj o = (TinyObj)other;
	     if(this.hash>o.hash) return 1;
	     else if( this.hash == o.hash) return 0;
	     else return -1;
	  }
	  public int getHash(){
	      return hash;
	    }
	  public int getFile(){
	      return file;
	    }
	}