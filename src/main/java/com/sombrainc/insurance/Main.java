package com.sombrainc.insurance;

import com.sombrainc.insurance.controller.InsuranceCompanyController;

public class Main {
	public static void main(String[] args) {
		InsuranceCompanyController controller = new InsuranceCompanyController();
		controller.save(controller.chooseSource());
	}
}
