package amazing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 Given string a and string b, find all the occurences of the anagrams of a in b.
 complexity is O(n).abstract*/

public class FindAnagrams {

	public static void main(String[] args) {

		String b = "BACDGABCDA";
		String a = "ABCD";
		
		Set<String> answer = findAnagrams(a, b);
		
		for (Iterator iterator = answer.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	    
	}

	public static Set<String> findAnagrams(String a, String b) {
		Set<String> answer = new HashSet<String>();

		char[] aCounter = new char[300];
		char[] bCounter = new char[300];

		// count number of each letter in String a
		for (char c : a.toCharArray()) {
			aCounter[c]++;
		}
		
		int left=0;
		int right=0;
		
		while(right<b.length()){
			
			bCounter[b.charAt(right)]++;
			
			if(right-left+1==a.length())
			{
				if(isSame(aCounter, bCounter))
				{
					answer.add(b.substring(left, right+1));
					System.out.println("Found at index : "+left);
				}
				
				// moving window to right
				bCounter[b.charAt(left)]--;
				left++;
			}
			
			right++;
		}

		return answer;
	}
	
	public static boolean isSame(char[] aCounter,char[] bCounter){
		for(int i=0;i<=299;i++)
		{
			if(aCounter[i]!=bCounter[i])
			{
				return false;
			}
		}
		
		return true;
	} 
}
