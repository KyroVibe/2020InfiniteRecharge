package org.team997.util;

public class Utils {

  public static double deadband(double val, double min) {
    if (Math.abs(val) < min) return 0.0;
    else return val;
  }

  public static double clamp(double val, double min, double max) {
    if (val > max) return max;
    if (val < min) return min;
    return val;
  }

}