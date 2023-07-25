package com.tokio.school.calculator.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class OperationsUtils {
	
	public static final String POINT_DECIMAL = ".";
	/**
	 * Method that determine if a String is a number (with or without decimal) or no 
	 * 
	 * @param num - String format wished x.x
	 * @return true if num is a number, otherwere false
	 */
	public static boolean isNumeric(String num){
		return StringUtils.isNumeric(num.replace(POINT_DECIMAL,""));
	}
	
	/**
	 * Method that convert a String in a BigDecimal
	 * 
	 * @param num - String format wised x.x
	 * @return a BigDecimal or null if num ins't a number
	 */
	public static BigDecimal convertStringToBigDecimal(String num) {
		if(!isNumeric(num)) {
			return null;
		}
		return new BigDecimal(num, MathContext.DECIMAL32);
	}
	
	/**
	 * Method that determine if a String es Zero or no
	 * 
	 * @param num - String format wised x
	 * @return true if num is Zero (0), otherwere false
	 */
	public static boolean isZero(String numStr) {
		return BigDecimal.ZERO.equals(numStr) || numStr.equals("0");
	}
	/**
	 * Check if strig has perfom 0.00000....
	 * 
	 * @param numStr - Sttirng
	 * @return true is a Number Float Zero or false in otherwere
	 * 
	 */
	public static boolean isDecimalZero(String numStr){

		Stream<Character> cStream = numStr.replace(POINT_DECIMAL, "").chars().mapToObj(i->(char)i);
		return isZero(numStr) || !cStream.anyMatch(n->!Objects.equals('0', n));
	}
	/**
	 * Method that determine if a String is a decimal or no
	 * 
	 * @param num - String format wised x.x
	 * @return true if num is Decimla (0), otherwere false
	 */
	public static boolean isStringADececimal(String num) {
		if(!isNumeric(num)) {
			return false;
		}			
		return num.contains(POINT_DECIMAL);
	}
	
	/**
	 * Method that sum 0 to N number
	 * 
	 * @param nums - BigDecimal[]
	 * @return A BigDecima with the sum of Zero with N numbers or Zero if nums is null
	 * 
	 */
	public static BigDecimal add(BigDecimal... nums) {
		if(nums==null) {
			return BigDecimal.ZERO;
		}
		return Stream.of(nums).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	/**
	 * Method that subtract 0 to N number
	 * 
	 * @param nums - BigDecimal[]
	 * @return A BigDecima with the sum of Zero with N numbers or Zero if nums is null
	 * 
	 */
	public static BigDecimal subtract(BigDecimal... nums) {
		if(nums==null) {
			return BigDecimal.ZERO;
		}
		return Stream.of(nums).map(num->num.abs()).reduce(BigDecimal.ZERO,BigDecimal::subtract);
	}
	
	/**
	 * Method that mulitply 0 to N number
	 * 
	 * @param nums - BigDecimal[]
	 * @return A BigDecima with the multiply of One with N numbers or Zero if nums is null
	 * 
	 */
	public static BigDecimal multiply(BigDecimal... nums) {
		if(nums==null) {
			return BigDecimal.ZERO;
		}
		return Stream.of(nums).reduce(BigDecimal.ONE,BigDecimal::multiply);
	}
	
	public static BigDecimal division(BigDecimal... nums) {
		if(nums==null) {
			return BigDecimal.ZERO;
		}

		BigDecimal base = nums[0];
		if(nums.length<2) {
			return base;
		}else {
			BigDecimal[] auxNums = Arrays.copyOfRange(nums, 1, nums.length);
			if(continsArrayZero(auxNums)) {
				return null;
			}
			return Stream.of(auxNums).reduce(base,(dividendo,divisor)->dividendo.divide(divisor,4,RoundingMode.CEILING));
		}
		
	}
	
	public static <T extends Number> Boolean continsArrayZero(T[] nums) {
		Stream.of(nums).forEach(System.out::println);
		return Stream.of(nums).anyMatch(num->isZero(num.toString()));
	}
	
}
