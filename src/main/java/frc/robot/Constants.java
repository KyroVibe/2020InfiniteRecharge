package frc.robot;

public final class Constants {

  public static class Ports {

    public static final int

      SHOOTER_MOTOR_1 = 8,
      SHOOTER_MOTOR_2 = 9,

      //Hopper things
      upperHopperMotor1 = 4, 
      upperHopperMotor2 = 5,
      lowerHopperMotor1 = 6,
      lowerHopperMotor2 = 7,
      hopperfrontIR = 0,
      hopperbackIR = 1,

      //Drivetrain things
      motorFrontLeft = 1,
      motorBackLeft = 2,
      motorFrontRight = 3,
      motorBackRight = 4,
      ultrasonicChannel = 0,

      //climber things
      climberMotorPort = 10,
      climberPistonPort = 0,

      buttonA = 1,
      buttonB = 2,
      buttonX = 3,
      buttonY = 4;
      
  }

  public static class Values {     

    public static final double
        voltageToFeet = (12 * 0.0098), //9.8mV per inch with a 5V input.

        shooterOutput = 1.0, // TODO: replace with actual

        visionTurningP = 0.028,
        visionTurningI = 0.01,
        visionTurningD = 0.06,
        visionTolerance = 1,
        visionTimeout = 2000, //in ms

        visionLimelightAngle = 10; //angle the limelight is tilted at. In degrees up from the floor.
  }

}
