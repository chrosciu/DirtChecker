package com.chrosciu.dirtchecker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;
import org.aspectj.lang.annotation.Pointcut;

import com.chrosciu.dirtchecker.iface.DirtCheckable;

interface DirtCheckableInternal extends DirtCheckable {
	
	public void markAsDirty();
	
}

class DirtCheckableImpl implements DirtCheckableInternal {
	
	private boolean dirty = false;
	
	public void markAsDirty() {
		dirty = true;
	}
	
	public boolean isDirty() {
		return dirty;
	}
	
}

@Aspect
public class DirtCheckingAspect {
	
	@DeclareMixin("@com.chrosciu.dirtchecker.annotation.Model *")
	public static DirtCheckableInternal dirtCheckable() {
		return new DirtCheckableImpl();
	}
	
	@Pointcut("execution((@com.chrosciu.dirtchecker.annotation.Model *).new(..))")
	public void modelConstructorExecution() {}
	
	@Pointcut("set(@com.chrosciu.dirtchecker.annotation.Immutable * @com.chrosciu.dirtchecker.annotation.Model *.*)")
	public void setModelImmutableFieldValue() {}
	
	@After("setModelImmutableFieldValue() && this(dirtCheckable) && !cflow(modelConstructorExecution())") 
	public void afterSetModelFieldValue(JoinPoint jp, DirtCheckableInternal dirtCheckable) {
		dirtCheckable.markAsDirty();
	}

}
