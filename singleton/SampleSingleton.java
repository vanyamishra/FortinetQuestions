/**
 * Singleton Implementation
 * @author vanyamishra
 */
package singleton;

public class SampleSingleton {

	// Creating an instance of the singleton class
	private static SampleSingleton instance = new SampleSingleton();

	// Declaring the constructor as private to prevent another class from
	// instantiating the class
	private SampleSingleton() {

	}

	public static SampleSingleton getInstance() {
		return instance;
	}
}
