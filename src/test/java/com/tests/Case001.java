package com.tests;

import org.testng.annotations.Test;
import com.pages.CalculatorPage;

public class Case001 {
	@Test(description = "División de 2 números")
	public void División() {
		CalculatorPage calculator = new CalculatorPage();
		String[] testList1 = {"7"};
		String[] testList2 = {"0"};
		calculator.ingresoNumeros(testList1, "div");
		calculator.ingresoNumeros(testList2, "");
		calculator.resultado();
	}
}
