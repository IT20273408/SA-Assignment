package mainconverter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import bmipublisher.BMIRange;
import designsubscriber.DesignMenu;
import lengthconverter.LengthConverter;

public class Activator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	ServiceRegistration registration ;
	
	@SuppressWarnings("rawtypes")
	private static ServiceTracker weightTracker, lengthTracker, BMITracker;
	
	private static DesignMenu designMenu;
	private static LengthConverter lengthConverter;
	private static BMIRange bmiRange;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service Started...");
		
		Converter converter = new ConverterMain();
		registration = context.registerService(Converter.class.getName(), converter, null);
		
		weightTracker = new ServiceTracker(context, DesignMenu.class.getName(), null);
		lengthTracker = new ServiceTracker(context, LengthConverter.class.getName(), null);
		BMITracker = new ServiceTracker(context, BMIRange.class.getName(), null);
		
		converter.Start();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Service Stopped...");
		registration.unregister();		
	}
	
	public static boolean weightClicker() {
		weightTracker.open();
		designMenu = (DesignMenu) weightTracker.getService();
		
		if (designMenu != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean lengthClicker() {
		lengthTracker.open();
		lengthConverter = (LengthConverter) lengthTracker.getService();
		
		if (lengthConverter != null) {
			return true;
			
		} else {
			return false;
		}
	}
	
	public static boolean BMICliker() {
		BMITracker.open();
		bmiRange = (BMIRange) BMITracker.getService();
		
		if(bmiRange != null) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
