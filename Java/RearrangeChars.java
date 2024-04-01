//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class RearrangeChars {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = 1;
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Solution
{
    public static class Info implements Comparable<Info> {
        char c;
        int t;
        
        public Info(char c, int t) {
            this.c = c;
            this.t = t;
        }
        
        @Override
        public int compareTo(Info i) {
            return i.t - this.t;
        }
    }
	public static String rearrangeCharacters(String str) {
	    PriorityQueue<Info> pq = new PriorityQueue<>();
	    int arr[] = new int[26];
	    for(int i = 0; i < str.length(); i++) {
	        arr[str.charAt(i)-'a']++;
	    }
	    for(int i = 0; i < 26; i++) {
	        if(arr[i] > 0) {
	            pq.add(new Info((char)(i+(int)'a'), arr[i]));
	        }
	    }
        System.out.println(Arrays.toString(arr));
        // System.out.println(pq.toString()
	    
	    String ans = "";
        Info temp = new Info('0', 0);
	    while(!pq.isEmpty()) {
        System.out.println(pq.peek().c);
	        Info info = pq.poll();
            if(temp.t > 0) pq.add(temp);
	        if(ans.length() > 0 && ans.charAt(ans.length()-1) == info.c) {
	            return "-1";
	        }
	        ans += info.c;
	        info.t--;
	        temp = info;
	    }
	    return ans;
	    
	}
}