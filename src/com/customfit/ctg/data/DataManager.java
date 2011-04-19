/**
 * 
 */
package com.customfit.ctg.data;

import java.io.*;
import java.lang.reflect.*;
import java.net.URL;
import java.util.*;


/**
 * @author David
 *
 */
public class DataManager {
	
	/**
	 * 
	 * @return
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
	 */
	public static DataDriverInterface acquireDriver(String className) throws ClassNotFoundException
	{
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		classLoader.loadClass(className);
		return new FlatFileDriver();
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<String> listLoadedDataDrivers()
	{
		ArrayList<String> driverList = new ArrayList<String>();
		

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		//classLoader.loadClass()
		//clas	
		
		return driverList;
	}

	public <S> Iterable<S> load(Class<S> ifc) throws Exception {
		ClassLoader ldr = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> e = ldr.getResources("META-INF/services/" + ifc.getName());
		Collection<S> services = new ArrayList<S>();
		while (e.hasMoreElements()) {
			URL url = e.nextElement();
			InputStream is = url.openStream();
			try {
				BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while (true) {
					String line = r.readLine();
					if (line == null)
						break;
					int comment = line.indexOf('#');
					if (comment >= 0)
						line = line.substring(0, comment);
					String name = line.trim();
					if (name.length() == 0)
						continue;
					Class<?> clz = Class.forName(name, true, ldr);
					Class<? extends S> impl = clz.asSubclass(ifc);
					Constructor<? extends S> ctor = impl.getConstructor();
					S svc = ctor.newInstance();
					services.add(svc);
				}
			}
			finally {
				is.close();
			}
		}
		return services;
	}
}
