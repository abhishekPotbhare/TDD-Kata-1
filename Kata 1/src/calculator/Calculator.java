package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

	public static int counter = 0;

	public static int add(String string) throws Exception {
		int sum = 0;
		++counter;
		if (string.isEmpty()) {
			return 0;
		} else if (string.startsWith("//")) {

			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);

			m.matches();
			String delimiter = m.group(1);
			String number = m.group(2);
			String[] split = number.split(Pattern.quote(delimiter));
			ArrayList<Integer> list = new ArrayList<Integer>();

			for (String s : split) {
				list.add(Integer.parseInt(s));
			}

			List<Integer> collect = list.stream().filter(i -> i < 0).collect(Collectors.toList());

			if (!collect.isEmpty()) {
				throw new Exception("Negatives not allowed: " + collect.toString());
			} else {

				for (Integer i : list) {
					if (i <= 1000) {
						sum += i;

					}
				}

				return sum;
			}

		}

		else {

			String[] split = string.split(",|\n");

			for (String s : split) {
				int temp = Integer.parseInt(s);
				if (temp <= 1000) {
					sum = sum + temp;
				}
			}

			return sum;

		}
	}

}
