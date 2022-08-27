/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0){
	        
	        
	        int num = sc.nextInt();
	        
	        System.out.println(min(num));
	        
	        
	    }
	}
	
	public static int min(int n){
	    
	    if(n == 0) return 0;
	    
	    else if(n >= 100) return n/100 + min(n%100);
	    
	    else if(n >= 50) return n/50 + min(50);
	    
	    else if(n >= 10) return n/10 + min(n%10);
	    
	    else if(n >= 5) return n/5 + min(n%5);
	    
	    else if(n >= 2) return  n/2 + min(n%2);
	    
	    else return n;
	}
}
