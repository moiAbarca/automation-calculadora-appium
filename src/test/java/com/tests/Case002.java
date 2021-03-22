package com.tests;

import org.testng.annotations.Test;
import com.pages.CalculatorPage;

public class Case002 {
	@Test(description = "Suma de 2 números")
	public void sumaNumeros() {
		CalculatorPage calculator = new CalculatorPage();
		String[] testList1 = {"5"};
		String[] testList2 = {"7"};
		calculator.ingresoNumeros(testList1, "suma");
		calculator.ingresoNumeros(testList2, "suma");
		calculator.resultado();
	}
}
