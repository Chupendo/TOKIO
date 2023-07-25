/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tokio.school.swing.calculadora.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author andre
 */
public class OperationsUtils {

    public static String POINT_DECIMAL = ".";

    /**
     * Method that determine if a String is a number (with or without decimal)
     * or no
     *
     * @param numStr - String format wished x.x
     * @return true if num is a number, otherwere false
     */
    public static boolean isStringANumeric(String numStr) {

        return StringUtils.isNumeric(numStr.replace(POINT_DECIMAL, ""))
                && NumberUtils.isCreatable(numStr)
                && NumberUtils.isParsable(numStr);
    }

    public static Boolean isStringDecimalZero(String numStr) {
        //Dciaml 0{0,1}[1-9]{0,}([.][0-9]*)?$
        Pattern pattern = Pattern.compile("0{0,}([.][0]{1,})?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numStr);
        Boolean matchFound = matcher.find();
        return isStringANumeric(numStr) && !matchFound;
    }

    public static Boolean isStringDecimal(String numStr) {
        Pattern pattern = Pattern.compile("0{0,1}[1-9]{0,}([.][0-9]*)?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numStr);
        Boolean matchFound = matcher.find();
        return isStringANumeric(numStr) && !matchFound;
    }

    public static BigDecimal add(BigDecimal... nums) {
        if (nums == null) {
            return BigDecimal.ZERO;
        }
        return Stream.of(nums).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Method that subtract 0 to N number
     *
     * @param nums - BigDecimal[]
     * @return A BigDecima with the sum of Zero with N numbers or Zero if nums
     * is null
     *
     */
    public static BigDecimal subtract(BigDecimal... nums) {
        if (nums == null) {
            return BigDecimal.ZERO;
        }
        return Stream.of(nums).map(num -> num.abs()).reduce(BigDecimal.ZERO, BigDecimal::subtract);
    }

    /**
     * Method that convert a String in a BigDecimal
     *
     * @param num - String format wised x.x
     * @return a BigDecimal or null if num ins't a number
     */
    public static BigDecimal convertStringToBigDecimal(String num) {
        if (!isStringANumeric(num)) {
            return null;
        }
        return new BigDecimal(num, MathContext.DECIMAL32);
    }

    /**
     * Method that mulitply 0 to N number
     *
     * @param nums - BigDecimal[]
     * @return A BigDecima with the multiply of One with N numbers or Zero if
     * nums is null
     *
     */
    public static BigDecimal multiply(BigDecimal... nums) {
        if (nums == null) {
            return BigDecimal.ZERO;
        }
        return Stream.of(nums).reduce(BigDecimal.ONE, BigDecimal::multiply);
    }

    public static BigDecimal division(BigDecimal... nums) {
        if (nums == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal base = nums[0];
        if (nums.length < 2) {
            return base;
        } else {
            BigDecimal[] auxNums = Arrays.copyOfRange(nums, 1, nums.length);
            if (continsArrayZero(auxNums)) {
                return null;
            }
            return Stream.of(auxNums).reduce(base, (dividendo, divisor) -> dividendo.divide(divisor, 4, RoundingMode.CEILING));
        }

    }

    public static <T extends Number> Boolean continsArrayZero(T[] nums) {
        Stream.of(nums).forEach(System.out::println);
        return Stream.of(nums).anyMatch(num -> isZero(num.toString()));
    }

    /**
     * Method that determine if a String es Zero or no
     *
     * @param numStr - String format wised x
     * @return true if num is Zero (0), otherwere false
     */
    public static boolean isZero(String numStr) {
        return BigDecimal.ZERO.equals(numStr) || numStr.equals("0") || isStringDecimalZero(numStr);
    }
}
