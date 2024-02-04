package codabook.agecalculator.glue;

import codabook.agecalculator.AgeCalculator;
import codabook.agecalculator.app.AgeCalculatorApp;
import codabook.agecalculator.ifce.AgeCalculatorIfce;
/*************************************************************************************************
*
* COMPANION CODE FOR THE BOOK “Component Oriented Development & Assembly – CODA Using Java”
* 
* @author – Piram Manickam, Sangeetha S, Subrahmanya S V
* @see -  http://www.codabook.com
* 
* <br><br><b>CODE CONTRIBUTORS</b> – <p>- Vishal Verma, Shikhar Johari, Soumya Bardhan, Rohit Jain,
* Karthika Nair, Vibhuti Pithwa, Vaasavi Lakshmi</p>

**************************************************************************************************/
public class AgeCalculatorGlue {

	public static void main(String[] args) {
		AgeCalculatorIfce ageCalculator = new AgeCalculator();
		AgeCalculatorApp.setAgeCalculator(ageCalculator);
		AgeCalculatorApp.main(null);

	}

}
