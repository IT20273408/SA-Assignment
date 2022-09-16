package bmipublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BMI Producer Started...");
		
		BMIRange range = new calculateBMI();
		registration = context.registerService(BMIRange.class.getName(), range, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BMI Producer Stopped...");
		
		registration.unregister();
	}
}
