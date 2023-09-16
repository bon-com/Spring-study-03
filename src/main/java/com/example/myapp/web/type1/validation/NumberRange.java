package com.example.myapp.web.type1.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NumberRangeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
	ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberRange {

	String message() default "";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	int min();
	int max();
}
