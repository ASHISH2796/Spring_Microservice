/**
 * 
 */
package com.ashish.microservice.limitsservice.bean;

/**
 * @author Ashish Gupta
 *
 */
public class Limits {

	private int minimum;
	private int maximum;
	
	
	/**
	 * @param minimum
	 * @param maximum
	 */
	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}
	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}
	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
