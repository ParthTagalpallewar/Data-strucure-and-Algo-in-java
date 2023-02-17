
/* package codechef; // don't place package name! */

import java.util.*;


/* Name of the class has to be "Main" only if the class is public. */
class program
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
	        
            int a = 5;
            int b = 2;
            String str1 = "abcdd";
            String str2 = "ac";
	        
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        
	        for(int i=0; i<a; i++){
	            char curr = str1.charAt(i);
	            
	            map.put(curr, map.getOrDefault(curr, 0)+1);
	        }
	        for(int i=0; i<b; i++){
	            char curr = str2.charAt(i);
	            
	            map.put(curr, map.getOrDefault(curr, 0)+1);
	        }
	        
	        int one_count = 0;
	        boolean all_even = true;
	        
	        
	        if(a+b % 2 == 0){
	           for(Map.Entry<Character, Integer> entry: map.entrySet()){
	                if(entry.getValue()% 2 == 1){
	                    all_even = false;
	                    break;
	                }
	            }
	            
	            String ans = all_even ? "YES" : "NO";
	            System.out.println(ans);
	            
	        }else{
	            
                int odd_count = 0;

	            for(Map.Entry<Character, Integer> entry: map.entrySet()){
	                
                    if(entry.getValue() % 2 == 1){
                        odd_count += 1;
                    }


	            }
	            
	            String ans = (odd_count > 1) ? "NO" : "YES";
	            System.out.println(ans);
	        }
	  
	        
	    }
	
}
