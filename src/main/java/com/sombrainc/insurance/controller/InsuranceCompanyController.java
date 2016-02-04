package com.sombrainc.insurance.controller;

import java.util.List;
import java.util.Scanner;

import com.sombrainc.insurance.entity.InsuranceCompany;
import com.sombrainc.insurance.service.InsuranceCompanyService;
import com.sombrainc.insurance.util.Constant.Connect;

public class InsuranceCompanyController {

	private static final Scanner scanner = new Scanner(System.in);
	private final InsuranceCompanyService service = new InsuranceCompanyService();

	public List<InsuranceCompany> chooseSource() {
		System.out.println("Input own source or choose existing");
		System.out.println("1. detelefoongids.nl");
		System.out.println("Input number of source or url:");
		String line = scanner.nextLine();
		String url;
		if (Connect.SOURCE.equals(line)) {
			url = Connect.DIRECTORYURL;
		} else {
			url = line;
		}
		return service.parse(url);
	}

	public void save(List<InsuranceCompany> list) {
		System.out.println("Input output file name with extension(xls or xlsx):");
		String filename = scanner.nextLine();
		service.saveToXLS(list, filename);
	}
}
