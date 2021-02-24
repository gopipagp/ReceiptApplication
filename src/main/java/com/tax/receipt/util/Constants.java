package com.tax.receipt.util;

import java.util.regex.Pattern;

public class Constants {
	public static final String INPUT_FILE_PATH = "input";

	public static Pattern EXEMPTED_PATTERN = Pattern.compile("pills|chocolate|book|wine");
	public static Pattern IMPORTED_PATTERN = Pattern.compile("importe");
	public static Pattern QUANTITY_PATTERN = Pattern.compile("^[\\d+]+");
	public static Pattern NAME_PATTERN = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
	public static Pattern PRICE_PATTERN = Pattern.compile("\\d+.\\d+$");

	public static String ITEM_FORMATTER = "%1$-40s %2$6.2f %n";
	public static String TAX_FORMATTER = "%1$-40s %2$6.2f %n";
	public static String TOTAL_FORMATTER = "%1$-40s %2$6.2f %n%n";
}