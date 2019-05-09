package com.ioof.datediff;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import com.ioof.datediff.DateValidator;

public class DateDifference {
	private static final Logger LOGGER = Logger.getLogger(DateDifference.class
			.getName());

	public static void main(String[] args) {
		// Read the input file
		String inputPath = getFilePath();
		List<String> dateValues = null;
		try {
			dateValues = FileUtils.readLines(new File(inputPath));
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			return;
		}

		if (dateValues != null && !dateValues.isEmpty()) {
			System.out.println("Earliest Date, Latest Date, Difference");
			for (String dates : dateValues) {

				String dateArr[] = dates.split(",");
				if (dateArr == null || dateArr.length != 2) {
					System.out.println(dates + ", Invalid Input");
					continue;
				}

				String output = showTotalDays(dateArr[0].trim(),
						dateArr[1].trim());
				if (output != null) {
					System.out.println(output);
				}

			}
		}
	}

	public static String showTotalDays(String firstDate, String secondDate) {

		if (DateValidator.validate(firstDate)
				&& DateValidator.validate(secondDate)) {
			// Find earliest and latest date
			String firstDateDateArr[] = firstDate.split(" ");
			String secondDateArr[] = secondDate.split(" ");

			int dayOfFirstDate = Integer.parseInt(firstDateDateArr[0]);
			int monthOfFirstDate = Integer.parseInt(firstDateDateArr[1]);
			int yearOfFirstDate = Integer.parseInt(firstDateDateArr[2]);

			int dayOfSecondDate = Integer.parseInt(secondDateArr[0]);
			int monthOfSecondDate = Integer.parseInt(secondDateArr[1]);
			int yearOfSecondDate = Integer.parseInt(secondDateArr[2]);

			boolean isSecondDateEarliest = false;

			// Find Difference between date
			if (yearOfSecondDate < yearOfFirstDate) {
				isSecondDateEarliest = true;
			} else if (yearOfSecondDate == yearOfFirstDate) {
				if (monthOfSecondDate < monthOfFirstDate) {
					isSecondDateEarliest = true;
				} else if (monthOfSecondDate == monthOfFirstDate
						&& dayOfSecondDate < dayOfFirstDate) {
					isSecondDateEarliest = true;
				}
			}

			int dayDiff1 = 0;
			for (int yy = 1900; yy <= yearOfFirstDate; yy++) {

				if (yy < yearOfFirstDate) {
					dayDiff1 += 365;
					continue;
				}

				for (int mm = 1; mm <= monthOfFirstDate; mm++) {

					if (mm < monthOfFirstDate) {
						dayDiff1 += DateValidator.getTotalDaysOfMonth(mm, yy);
						continue;
					}

					for (int dd = 1; dd < dayOfFirstDate; dd++) {
						dayDiff1++;
					}
				}
			}

			int dayDiff2 = 0;
			for (int yy = 1900; yy <= yearOfSecondDate; yy++) {

				if (yy < yearOfSecondDate) {
					dayDiff2 += 365;
					continue;
				}

				for (int mm = 1; mm <= monthOfSecondDate; mm++) {

					if (mm < monthOfSecondDate) {
						dayDiff2 += DateValidator.getTotalDaysOfMonth(mm, yy);
						continue;
					}

					for (int dd = 1; dd < dayOfSecondDate; dd++) {
						dayDiff2++;
					}
				}
			}

			// Find Difference between date
			int differenceOfDays = dayDiff2 - dayDiff1;
			if (isSecondDateEarliest) {
				String temp = firstDate;
				firstDate = secondDate;
				secondDate = temp;

				differenceOfDays = dayDiff1 - dayDiff2;
			}

			return (firstDate + ",    " + secondDate + ",  " + differenceOfDays + " Days");
		} else {
			return "Invalid Date";
		}
	}

	private static String getFilePath() {
		String inputPath = "src\\main\\resource\\inputDates.txt";
		return inputPath;
	}
}
