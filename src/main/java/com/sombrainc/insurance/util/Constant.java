package com.sombrainc.insurance.util;

public class Constant {

	public static class Connect {
		public static final String DIRECTORYURL = "http://www.detelefoongids.nl/autoverzekering/4-1/?what=autoVerzekering&encodedRefinement=mainheading~auto-verzekeringen&page=1&forceSearchType=true&mostDominantHeading=Verzekering&sortBy=Dalpha&searchType=YP_SEARCH";
		public static final String USERAGENT = "Mozilla";
		public static final int TIMEOUT = 5000;
		public static final String SOURCE = "1";
	}
	
	public static class Company {
		public static final String SHEET = "Insurance";
		public static final String NUM = "#";
		public static final String NAME = "Name";
		public static final String ADDRESS = "Address";
		public static final String CITY = "City";
		public static final String PHONE = "Phone";
	}
	
	public static class Extension {
		public static final String XLS = "xls";
		public static final String XLSX = "xlsx";
	}
}
