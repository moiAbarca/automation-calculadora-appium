package com.tests;

import org.testng.annotations.Test;
import com.pages.CalculatorPage;

public class Case003 {
	@Test(description = "Multiplicación de 4 números")
	public void Multiplicación() {
		CalculatorPage calculator = new CalculatorPage();
		String[] testList1 = {"12121211212122121212"};
		String[] testList2 = {"2323232232323232323232"};
		String[] testList3 = {"4545454545454545454545"};
		String[] testList4 = {"676767676767676767676767"};
		calculator.ingresoNumeros(testList1, "mult");
		calculator.ingresoNumeros(testList2, "mult");
		calculator.ingresoNumeros(testList3, "mult");
		calculator.ingresoNumeros(testList4, "");
		calculator.resultado();
	}
}
