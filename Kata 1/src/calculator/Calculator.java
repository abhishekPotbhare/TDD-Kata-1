package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

	public static int add(String string) {
		int sum = 0;
		if (string.isEmpty()) {
			return 0;
		} else if (string.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
			m.matches();
			String delimiter = m.group(1);
			String number = m.group(2);
			String[] split = number.split(delimiter);
			ArrayList<Integer> list = new ArrayList<Integer>();

			for (String s : split) {
				list.add(Integer.parseInt(s));
			}
			
			 //filter(LessThan(0),list);
			
			List<Integer> collect = list.stream().filter(i -> i<0).collect(Collectors.toList());

			   if(!collect.isEmpty()) {
				   throw new RuntimeException("Negatives not allowed: "+collect.toString());
			   }
			   else {for (String s : split) {
				sum += Integer.parseInt(s);
			}

			return sum;
			   }
		} else {

			String[] split = string.split(",|\n");

			for (String s : split) {
				sum += Integer.parseInt(s);
			}
			return sum;

		}
	}

}
