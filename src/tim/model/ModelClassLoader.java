package tim.model;

import java.util.HashMap;

public class ModelClassLoader extends ClassLoader {
	private HashMap<String, Class> classes = new HashMap<String, Class>();
	
	public synchronized Class loadClass (String className, boolean resolve) {
	         Class result; 
	         byte classData[]; 
	         System.out.println(" >>>>>> Load class : "+className); 
	         /* Check our local cache of classes */ 
	         result = (Class)classes.get(className); 
	         if (result != null) { 
	             System.out.println(" >>>>>> returning cached result."); }
	         
	             return result; 
	}
}
