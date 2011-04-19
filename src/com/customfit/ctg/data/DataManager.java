/**
 * 
 */
package com.customfit.ctg.data;

//import java.io.*;
//import java.lang.reflect.*;
//import java.net.URL;
import java.util.*;


/**
 * The DataManager is a utility class with static methods that can be used
 * to access data drivers.
 * @author David
 */
public class DataManager extends ClassLoader {
	
	/**
	 * Returns a new FlatFileDriver object. 
	 * @return A new FlatFileDriver object.
	 */
	public static FlatFileDriver acquireFlatFileDriver()
	{
		return new FlatFileDriver();
	}
	
	/**
	 * You specify a Java class name and this function will return the class 
	 * if it extends DataDriverInterface.
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static DataDriverInterface acquireDriver(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		ClassLoader ldr = Thread.currentThread().getContextClassLoader();
		Class<?> unknown = ldr.loadClass(className);
		Class<? extends DataDriverInterface> known = unknown.asSubclass(DataDriverInterface.class);
		Object curious = known.newInstance();
		return (DataDriverInterface)curious;
	}
	
	/**
	 * 
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 */
	public static List<String> listLoadedDataDrivers() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException
	{
		ArrayList<String> driverList = new ArrayList<String>();
		driverList.add("com.customfit.ctg.data.FlatFileDriver");
		return driverList;
	}

//	public static <S> Iterable<S> load(String className, Class<S> ifc) throws Exception {
//	//public <S> Iterable<S> load(String ifc) throws Exception {
//		ClassLoader ldr = Thread.currentThread().getContextClassLoader();
//		Enumeration<URL> e = ldr.getResources("META-INF/services/" + ifc.getName());
//		//Enumeration<URL> e = ldr.getResources("bin/com/customfit/ctg/data/" + className + ".class");
//		Collection<S> services = new ArrayList<S>();
//		while (e.hasMoreElements()) {
//			URL url = e.nextElement();
//			InputStream is = url.openStream();
//			try {
//				BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//				while (true) {
//					String line = r.readLine();
//					if (line == null)
//						break;
//					int comment = line.indexOf('#');
//					if (comment >= 0)
//						line = line.substring(0, comment);
//					String name = line.trim();
//					if (name.length() == 0)
//						continue;
//					Class<?> clz = Class.forName(name, true, ldr);
//					Class<? extends S> impl = clz.asSubclass(ifc);
//					//Class<? extends S> impl = clz.getInterfaces();
//					//Class<?>[] ifaces = clz.getInterfaces();
//					//for (Class<?> iface : ifaces)
//					//{
//					//	if (iface.)
//					//}
//					Constructor<? extends S> ctor = impl.getConstructor();
//					S svc = ctor.newInstance();
//					services.add(svc);
//				}
//			}
//			finally {
//				is.close();
//			}
//		}
//		return services;
//	}
}
