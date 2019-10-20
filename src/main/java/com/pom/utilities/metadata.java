package com.pom.utilities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface metadata {
	

	public String filepath() default Constants.REGFILEPATH ;
	public String testcasesheet() default Constants.REGTESTCASESHEET;
	public String testdatasheet() default Constants.REGTESTDATASHEET;
	
}
