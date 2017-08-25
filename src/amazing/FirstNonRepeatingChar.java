package amazing;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/*
 1) Scan the string from left to right and construct the count array.
 2) Again, scan the string from left to right and check for count of each
 character, if you find an element who's count is 1, return it.

 */public class FirstNonRepeatingChar {

	public static void main(String[] args) {

		String str = "abcdabcfabc";
		findFirstNRC(str);
		findFirstNRC2(str);
	}

	public static void findFirstNRC(String input) {
		char[] count = new char[256];
		for (int i = 0; i < input.length(); i++)
			count[input.charAt(i)]++;

		for (int i = 0; i < input.length(); i++) {
			if (count[input.charAt(i)] == 1) {
				System.out.println("OUTPUT is : " + input.charAt(i));
				break;
			}
		}

	}
	
	public static void findFirstNRC2(String input)
	{
		LinkedHashMap<Character,Integer> countMap=new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++)
		{
			if(countMap.containsKey(input.charAt(i)))
			{
				countMap.put(input.charAt(i), -1);
			}
			else
			{
				countMap.put(input.charAt(i), 1);
			}
		}
		
		
		Iterator<Entry<Character, Integer>> it=countMap.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Character, Integer> entry=it.next();
			if(entry.getValue()==1)
			{
				System.out.println("OUTPUT is : " + entry.getKey());
				break;
			}
		}
	}

}
