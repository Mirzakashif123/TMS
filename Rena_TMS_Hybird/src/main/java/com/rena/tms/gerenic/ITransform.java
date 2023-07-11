package com.rena.tms.gerenic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * This Class is devloped for using RetryIListeners in suite of TestNG.xml file 
 * @author Budarpu Madhusudhan
 *
 */
public class ITransform implements IAnnotationTransformer {
/**
 * This Method is developed for Transforming RetryListeners
 */
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(com.rena.tms.gerenic.RetryImplementation.class);
	}
}
