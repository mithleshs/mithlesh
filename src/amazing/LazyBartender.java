package amazing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LazyBartender {

	public static void main(String[] args) {

		List<String> drinks=Arrays.asList("D1","D2","D3","D4","D5","D6","D7","D8","D9");
		HashMap<String, List<String>> custDrinkOrderMap=new HashMap<String, List<String>>();
		custDrinkOrderMap.put("CUST1", Arrays.asList("D3","D7","D5","D2","D9"));
		custDrinkOrderMap.put("CUST2", Arrays.asList("D5"));
		custDrinkOrderMap.put("CUST3", Arrays.asList("D2","D3"));
		custDrinkOrderMap.put("CUST4", Arrays.asList("D4"));
		custDrinkOrderMap.put("CUST5", Arrays.asList("D3","D4","D3","D5","D7","D4"));
		
		calculatePossibleDrinks(drinks, custDrinkOrderMap);
		
		
	}
	
	public static void calculatePossibleDrinks(List<String> drinks,HashMap<String, List<String>> custDrinkOrderMap)
	{
		Map<String, Integer> topOrderMap=new HashMap<String, Integer>();
		Iterator<Entry<String, List<String>>> it=custDrinkOrderMap.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String, List<String>> current=it.next();
			List<String> value=current.getValue();
			
			for(int i=0;i<value.size();i++)
			{
				if(topOrderMap.containsKey(value.get(i)))
				{
					topOrderMap.put(value.get(i),topOrderMap.get(value.get(i))+1);
				}
				else
				{
					topOrderMap.put(value.get(i),1);
				}
			}
		}
		
		System.out.println("Possible number of drinks are :");
		Set<String> drinkSet=topOrderMap.keySet();
		for (Iterator iterator = drinkSet.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("Drink Order count for "+string+" is : "+topOrderMap.get(string));
		}
	}

}
