
import java.util.*;


public class ArrayListDemo {

	public static void main(String[] args) {	
		//List allows duplicate values, stores values in the order given/added
		//Dynamic Arrays, can shrink or increase size dynamically unlike normal arrays
		ArrayList<String> atmp = new ArrayList<String>();
		atmp.add("hgdf");
		
		ArrayList<String> al = new ArrayList<String>();
		al.addAll(atmp);
		al.add("BCD");
		al.add("A1");
		al.add("A2");
		al.add("A2");
		
		dArrayList("Original ArrayList: ", al);
		
		Collections.reverse(al);
		
		dArrayList("After Reversing: ",al);
		System.out.println("-------------------------");
	
		Collections.shuffle(al);
		
		dArrayList("After Shuffling ",al);
	}
	
	static void dArrayList(String str, ArrayList<String> al)
	{
		System.out.println("------------------------------");
		System.out.println(str);
		Iterator<String> itr = al.iterator();
		//using Iterator, we can traverse only in forward direction
		for(;itr.hasNext();)
		{
			String tStr = itr.next(); //returns Object
			System.out.println(tStr+" ");
		}
	}

}
