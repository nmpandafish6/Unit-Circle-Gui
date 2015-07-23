package org.nico.math.generic;

/**
 *
 * @author mallory
 */
public class MathUtil {

    /**
     * @param value
     * @return value*value
     */
    public static double sqr(double value){
        return value*value;
    }
    
    /**
     * @param slope
     * @return The slope in degrees. The range is -90 to 90.
     */
    public static double slopeToEulerAngle(double slope){
        return Math.toDegrees(Math.atan(slope));
    }
    
    /**
     * @param rise
     * @param run
     * @return The slope in degrees. The range is -180 to 180.
     */
    public static double slopeToEulerAngle2(double rise, double run){
        return Math.toDegrees(Math.atan2(rise,run));
    }
    
    /**
     * @param angle
     * @return The angle as a corresponding slope.
     */
    public static double eulerAngleToSlope(double angle){
        return Math.tan(Math.toRadians(angle));
    }
    
    public static boolean isEven(long value){
        return (value % 2 == 0);
    }
    
    public static boolean isOdd(long value){
        return (value % 2 != 0);
    }   
    
    public static boolean isInteger(double value){
        return (Math.floor(value) == value);
    }
}
