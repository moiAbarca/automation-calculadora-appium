package com.tests;

import org.testng.annotations.Test;
import com.pages.CalculatorPage;

public class Case004 {
	@Test(description = "División de un número por una coma")
	public void DivisiónPorComa() {
		CalculatorPage calculator = new CalculatorPage();
		String[] testList1 = {"12"};
		String[] testList2 = {""};
		calculator.ingresoNumeros(testList1, "mult");
		calculator.ingresoNumeros(testList2, "coma");
		calculator.resultado();
	}
}
