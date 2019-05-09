package com.ioof.datediff;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {

	private static final String DATE_REGEX = "(0?[1-9]|[12][0-9]|3[01])\\s(0?[1-9]|1[012])\\s((19|20)\\d\\d)";

	private static final HashSet<Integer> MONTHS_HAVING_30_DAYS = new HashSet<>();
	static {
		MONTHS_HAVING_30_DAYS.add(4);
		MONTHS_HAVING_30_DAYS.add(6);
		MONTHS_HAVING_30_DAYS.add(9);
		MONTHS_HAVING_30_DAYS.add(11);
	}

	public static boolean validate(String date) {

		Pattern pattern = Pattern.compile(DATE_REGEX);
		Matcher matcher = pattern.matcher(date);
		boolean isValid = false;
		if (matcher.matches()) {
			isValid = true;
			int dd = Integer.parseInt(matcher.group(1));
			int mm = Integer.parseInt(matcher.group(2));
			int yy = Integer.parseInt(matcher.group(3));

			if (MONTHS_HAVING_30_DAYS.contains(mm) && dd == 31) {
				isValid = false;
			} else if (mm == 2) {
				if (dd > 29 || (yy % 4 != 0 && dd == 29)) {
					isValid = false;
				}
			}

			if (yy > 2010) {
				isValid = false;
			}
		}
		return isValid;
	}

	public static int getTotalDaysOfMonth(int month, int year) {
		if (MONTHS_HAVING_30_DAYS.contains(month)) {
			return 30;
		} else if (month == 2) {
			if (year % 4 == 0) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 31;
		}
	}
}