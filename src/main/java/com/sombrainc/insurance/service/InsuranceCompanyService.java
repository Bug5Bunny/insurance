package com.sombrainc.insurance.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sombrainc.insurance.entity.InsuranceCompany;
import com.sombrainc.insurance.util.Constant.Company;
import com.sombrainc.insurance.util.Constant.Connect;
import com.sombrainc.insurance.util.Constant.Extension;

public class InsuranceCompanyService {

	public List<InsuranceCompany> parse(String url) {
		Document doc;
		List<InsuranceCompany> list = new ArrayList<>();
		try {
			doc = Jsoup.connect(url).userAgent(Connect.USERAGENT).timeout(Connect.TIMEOUT).get();
			String title = doc.title();
			Elements cities = doc.select("span.city");
			Elements addresses = doc.select("span.street");
			Elements companyName = doc.select("h4.name");
			Elements phones = doc.getElementsByAttributeValue("itemprop", "telephone");
			System.out.println(title);
			for (int i = 0; i < cities.size(); i++) {
				list.add(new InsuranceCompany(companyName.get(i).text(), addresses.get(i).text(), cities.get(i).text(),
						phones.get(i).text()));
				System.out.println(list.get(i).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void saveToXLS(List<InsuranceCompany> list, String filename) {
		Workbook wb = null;
		if (Extension.XLS.endsWith(filename)) {
			wb = new HSSFWorkbook();
		} else {
			wb = new XSSFWorkbook();
		}
		Sheet sheet = wb.createSheet(Company.SHEET);
		Row row = sheet.createRow((short) 0);
		row.createCell(0).setCellValue(Company.NUM);
		row.createCell(1).setCellValue(Company.NAME);
		row.createCell(2).setCellValue(Company.ADDRESS);
		row.createCell(3).setCellValue(Company.CITY);
		row.createCell(4).setCellValue(Company.PHONE);
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((short) i + 1);
			row.createCell(0).setCellValue(i + 1);
			row.createCell(1).setCellValue(list.get(i).getCompanyName());
			row.createCell(2).setCellValue(list.get(i).getAddress());
			row.createCell(3).setCellValue(list.get(i).getCity());
			row.createCell(4).setCellValue(list.get(i).getPhone());
		}
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				wb.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
