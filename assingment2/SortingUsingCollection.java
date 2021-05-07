package week3.assingment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

 static void main(String[] args) {

	
//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		List<String> st = new ArrayList<String>();
		st.add("HCL");
		st.add("Wipro");
		st.add("Aspire Systems");
		st.add("CTS");

//		get the length of the array
		System.out.println("Length of Array: " + st.size());

//		sort the array	 and iterate in reverse order
		Collections.sort(st, Collections.reverseOrder());

//		print the array  > //		Required Output: Wipro, HCL , CTS, Aspire Systems
		System.out.println("Reversed Output: " + st);

	}

}

