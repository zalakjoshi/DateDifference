
This sample project takes two dates as input parameters from the sample data file (src/main/resource/inputDates.txt) 
and gives output as how many days between two dates.

1) Main class to run the application is com.ioof.datediff.DateDifference.java
2) Input is taken from the file inputDates.txt

you will see output like:

Earliest Date, Latest Date, Difference
01 01 2001,    10 01 2001,  9 Days
21 01 2000,    11 11 2000,  295 Days
30 04 1991,    16 03 1992,  321 Days
29 02 2008,    08 08 2008,  161 Days
20 01 1993,    25 06 1995,  886 Days

Cases attended
---------------

1.Error cases
	a)If any of the date contains letters(eg:ZZ 12 1990)
	b)If any of the date contains other format(eg: 20:10:2000)
	c)If any of the date is before 01 01 1900(eg: 01 01 1800)
	c)If any of the date is after 31 12 2010(eg: 10 10 2011)
	d)If any of the date is invalid(eg: 33 01 2001)
	
2. Success cases

	a) valid dates(01 01 2001, 10 01 2001)
	b) leap year check(29 02 2008, 08 08 2008)