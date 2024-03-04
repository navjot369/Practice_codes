//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<Integer>[] graph = new ArrayList[K];
        for(int i = 0; i < K; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 1; i < N; i++) {
            int j = 0;
            while(j < dict[i-1].length() && j < dict[i].length()) {
                if(dict[i-1].charAt(j) != dict[i].charAt(j)) {
                    graph[(dict[i-1].charAt(j)-'a')].add((dict[i].charAt(j)-'a'));
                    break;
                }
                j++;
            }
        }
        
        int deg[] = new int[K];
        for(ArrayList<Integer> arr:graph) {
            for(int c:arr) {
                deg[c]++;
            }
        }
        
        String ans = "";
        for(int i = 0; i < K; i++){
            int j = 0;
            for(; j < K; j++) {
                if(deg[j] == 0) {
                    break;
                }
            }
            
            ans += (char)(j+'a');
            deg[j] = -1;
            for(int c:graph[j]) {
                deg[c]--;
            } 
        }
        System.out.println(ans);
        return ans;
    }
}
