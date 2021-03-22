package com.tests;

import org.testng.annotations.Test;
import com.pages.CalculatorPage;

public class Case005 {
	@Test(description = "Sucesión de varias operaciones matemáticas ")
	public void SucecionOperaciones() {
		CalculatorPage calculator = new CalculatorPage();
		String[] testList1 = {"12"};
		String[] testList2 = {"456678"};
		String[] testList3 = {"6778678"};
		String[] testList4 = {"309"};
		String[] testList5 = {"111"};
		calculator.ingresoNumeros(testList1, "mult");
		calculator.ingresoNumeros(testList2, "div");
		calculator.ingresoNumeros(testList3, "suma");
		calculator.ingresoNumeros(testList4, "resta");
		calculator.ingresoNumeros(testList5, "");
		calculator.resultado();
	}
}
