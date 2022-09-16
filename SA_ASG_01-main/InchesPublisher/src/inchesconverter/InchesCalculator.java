package inchesconverter;

public class InchesCalculator implements InchesConverter {

	float ans;
	
	@Override
	public float InchToMeter(float val) {
		// TODO Auto-generated method stub
		ans = (float) ((val *2.54)/100);
		return ans;
	}

	@Override
	public float InchToCenti(float val) {
		// TODO Auto-generated method stub
		ans = (float) (val *2.54);
		return ans;
	}

	@Override
	public float InchToFeet(float val) {
		// TODO Auto-generated method stub
		ans = val / 12;
		return ans;
	}

	@Override
	public float InchToMiles(float val) {
		// TODO Auto-generated method stub
		ans = val / 63360;
		return ans;
	}

}
