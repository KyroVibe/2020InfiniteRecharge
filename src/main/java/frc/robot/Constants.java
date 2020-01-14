package frc.robot;

/**
 * Pathfinder units are in meters.
 * Everything else is in inches or feet or something american.
 */
public final class Constants {

  public static class Ports {

    public static class OI {
      public static final int

        AXIS_LEFT_Y = 1,
        AXIS_RIGHT_X = 4;

    }

    public static class Drivetrain {
      public static final int

        LEFT_FX_1 = 1,
        LEFT_FX_2 = 2,
        RIGHT_FX_1 = 3,
        RIGHT_FX_2 = 4;

    }

    public static class Intake {
      public static final int

        MOTOR_550 = 5;
      
    }

    public static class Shooter {
      public static final int

        MOTOR_NEO = 6;

    }

  }

  public static class Values {
    public static final int

      CANBUS_TIMEOUT = 10;

    public static class Drivetrain {
      public static final double

        WHEEL_DIAMETER = 5,
        GEARING_FACTOR = 9 / 70,
        INPUT_PERCENT_DEADBAND = 0.05,

        MAX_VELOCITY = 4.3,
        MAX_ACCELERATION = 4.572;

    }

  }

}