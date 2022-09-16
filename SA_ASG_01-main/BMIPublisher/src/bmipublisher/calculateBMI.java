package bmipublisher;

import java.text.DecimalFormat;

import centimeterpublisher.CentimeterCalculator;
import centimeterpublisher.CentimeterConverter;

public class calculateBMI implements BMIRange {
	
	CentimeterConverter centimeterConverter = new CentimeterCalculator();
	DecimalFormat dformat = new DecimalFormat("0.00");

	@Override
	public double CalBMI(double height, double weight) {
		// TODO Auto-generated method stub
		double h = centimeterConverter.CnetiToMeter((float)height);
		double ans = (weight / (h * h));
		
		String s = dformat.format(ans);
		return ans = Double.parseDouble(s);
	}

	@Override
	public String checkCatogary(double bmi) {
		// TODO Auto-generated method stub
		if (bmi < 16) {
			return "Severely Underweight";
			
		} else if(bmi >= 16 && bmi < 18.5){
			return "Underweight";
			
		}else if(bmi >= 18.5 && bmi < 25){
			return "Normal";
			
		}else if(bmi >= 25 && bmi < 30){
			return "Overweight";
			
		}else if(bmi >= 30 && bmi < 35){
			return "Moderately Obese";
			
		}else if(bmi >= 35 && bmi < 40){
			return "Severely Obese";
			
		}else if(bmi >= 40){
			return "Morbidly Obese";
			
		}else {
			return "ER";
		}
	}

	@Override
	public String checkNormalWeight(double height) {
		// TODO Auto-generated method stub
		if (height < 149) {
            return "40kg - 52kg";
        } else if ((height > 148)  && (height < 152)) {
            return"41kg - 54kg";
            
        } else if ((height > 151)  && (height < 154)) {
            return"45kg - 56kg";
            
        } else if ((height > 153)  && (height < 157)) {
            return"45kg - 59kg";
            
        } else if ((height > 156)  && (height < 160)) {
            return"47kg - 61kg";
            
        } else if ((height > 159)  && (height < 162)) {
            return"47kg - 63kg";
            
        } else if ((height > 161)  && (height < 165)) {
        	return"50kg - 65kg";
            
        } else if ((height > 164)  && (height < 167)) {
            return"52kg - 65kg";
            
        } else if ((height > 166)  && (height < 170)) {
            return"52kg - 68kg";
            
        } else if ((height > 169) && (height < 172)) {
            return"54kg - 70kg";
            
        } else if ((height > 171) && (height < 177)) {
            return"56kg - 72kg";
            
        } else if ((height > 176)  && (height < 180)) {
            return"59kg - 75kg";
            
        } else if ((height > 179)  && (height < 182)) {
            return"59kg - 77kg";
            
        } else if ((height > 181)  && (height < 185)) {
            return"63kg - 81kg";
            
        } else if ((height > 184)  && (height < 187)) {
            return"63kg - 84kg";
            
        } else if ((height > 186)  && (height < 190)) {
            return"65kg - 86kg";
            
        } else if ((height > 189) && (height < 193)) {
            return"68kg - 88kg";
            
        } else {
            return"70kg - 90kg";
        }
	}

}
