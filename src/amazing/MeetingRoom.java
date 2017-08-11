package amazing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/*There is a conference room. N people are joining the conference. 
 * You have the start time and end time of each of them visiting it. 
 * You are asked to determine the maximum number of people that can be inside the room. 

 Example – Four people are visiting the conference 
 Person A	B	C	D	
 Start (hour) 1	3	2	5	
 End (hour) 4	5	7	10 
 Answer will be – 3
 */
public class MeetingRoom {

	public static void main(String[] args) {

		HashMap<String, List<Integer>> personMap=new HashMap<String, List<Integer>>();
		personMap.put("A", Arrays.asList(1,4));
		personMap.put("B", Arrays.asList(3,5));
		personMap.put("C", Arrays.asList(2,7));
		personMap.put("D", Arrays.asList(5,10));
		
		List<String> meetingRoom = new ArrayList<>();
		Set<Entry<String, List<Integer>>> entrySet=personMap.entrySet();
		int maxCount=0;
		for(int i=1;i<25;i++)
		{
			Iterator<Entry<String, List<Integer>>> it=entrySet.iterator();
			while(it.hasNext())
			{
				Entry<String, List<Integer>> entry=it.next();
				String personKey=entry.getKey();
				List<Integer> inOutTime=entry.getValue();
				if(i==inOutTime.get(0))
				{
					meetingRoom.add(personKey);
				}
				
				if(i==inOutTime.get(1))
				{
					meetingRoom.remove(personKey);
				}
			}
			
			if(meetingRoom.size()>maxCount)
			{
				maxCount=meetingRoom.size();
			}
			//System.out.println("At Time "+i+" Number of people will be available in meeting room are : "+maxCount);
		}
		
		System.out.println("Number of people in Meeting Room MaxCount : "+maxCount);
	}

}
