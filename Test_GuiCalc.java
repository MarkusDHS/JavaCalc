package PraxisphaseCalcGradle;
import static org.junit.Assert.*;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import org.junit.Test;

public class TestGuiCalc {

	@Test
	public void test() throws HeadlessException{
		
//		GuiTaschenrechner Calc=new GuiTaschenrechner();
//		
//		Object b=new Object();
//		ActionEvent e = new ActionEvent(b, 0, "3");
//		Calc.actionPerformed(e);
//		ActionEvent f = new ActionEvent(b, 0, "erg");
//		Calc.actionPerformed(f);
//		
//		assertTrue(Calc.ergebnislabel.getText().contentEquals("3"));
		assertTrue(true);
		Rechnungen re=new Rechnungen();
		assertTrue(re.calculate(4,2,"+")==6);
		assertTrue("Skirr",re.calculate(2,2,"-")==0);
		assertTrue(re.calculate(4,2,"*")==8);
		assertTrue(re.calculate(2,2,"/")==1);
	}
}
