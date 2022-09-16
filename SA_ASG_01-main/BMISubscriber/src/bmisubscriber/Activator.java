package bmisubscriber;

import bmipublisher.BMIRange;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	ServiceReference reference;

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BMI Subscriber Started...");
		
		reference = context.getServiceReference(BMIRange.class.getName());
		BMIRange range = (BMIRange) context.getService(reference);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BMI Subscriber Stopped...");
		
		context.ungetService(reference);
	}
	
	
	
}
