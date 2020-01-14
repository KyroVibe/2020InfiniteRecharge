package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.team997.util.Utils;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

/**
 * Theta is in degrees.
 * Omega is in rpms.
 */
public class Drivetrain implements Subsystem {

  private TalonFX leftMotor1, leftMotor2, rightMotor1, rightMotor2;

  private Drivetrain() {
    leftMotor1 = initMotor(Constants.Ports.Drivetrain.LEFT_FX_1, true);
    leftMotor2 = initMotor(Constants.Ports.Drivetrain.LEFT_FX_2, false);
    rightMotor1 = initMotor(Constants.Ports.Drivetrain.RIGHT_FX_1, true);
    rightMotor2 = initMotor(Constants.Ports.Drivetrain.RIGHT_FX_2, false);

    leftMotor1.setInverted(true);
    leftMotor2.setInverted(true);
    rightMotor1.setInverted(false);
    rightMotor2.setInverted(false);

    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);
  }

  private TalonFX initMotor(int port, boolean setupEncoder) {

    TalonFX motor = new TalonFX(port);
    motor.configFactoryDefault(Constants.Values.CANBUS_TIMEOUT);
    // StatorCurrentLimitConfiguration confA = new StatorCurrentLimitConfiguration(true, 50, 70, 100);
    SupplyCurrentLimitConfiguration confB = new SupplyCurrentLimitConfiguration(true, 40, 60, 100);
    // motor.configStatorCurrentLimit(confA, Constants.Values.CANBUS_TIMEOUT);
    motor.configSupplyCurrentLimit(confB, Constants.Values.CANBUS_TIMEOUT);

    if (setupEncoder) {
      motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 10);
      motor.setSelectedSensorPosition(0, 0, 10);
    }

    return motor;
  }

  public void setPercentSpeed(double left, double right) {
    leftMotor1.set(ControlMode.PercentOutput, Utils.deadband(left, 0.05));
    rightMotor1.set(ControlMode.PercentOutput, Utils.deadband(right, 0.05));
  }

  public void resetLeftEncoder() { leftMotor1.setSelectedSensorPosition(0, 0, 10); }
  public void resetRightEncoder() { rightMotor1.setSelectedSensorPosition(0, 0, 10); }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drivetrain/Left Theta", getLeftTheta());
    SmartDashboard.putNumber("Drivetrain/Right Theta", getRightTheta());
    SmartDashboard.putNumber("Drivetrain/Left Omega", getLeftOmega());
    SmartDashboard.putNumber("Drivetrain/Right Omega", getRightOmega());
    SmartDashboard.putNumber("Drivetrain/Left Position", getLeftPosition());
    SmartDashboard.putNumber("Drivetrain/Right Position", getRightPosition());
    SmartDashboard.putNumber("Drivetrain/Left Velocity", getLeftVelocity());
    SmartDashboard.putNumber("Drivetrain/Right Velocity", getRightVelocity());
    SmartDashboard.putNumber("Drivetrain/Temperature/Left Master", leftMotor1.getTemperature());
    SmartDashboard.putNumber("Drivetrain/Temperature/Left Follower", leftMotor2.getTemperature());
    SmartDashboard.putNumber("Drivetrain/Temperature/Right Master", rightMotor1.getTemperature());
    SmartDashboard.putNumber("Drivetrain/Temperature/Right Follower", rightMotor2.getTemperature());
  }

  public double getLeftTheta() { return leftMotor1.getSelectedSensorPosition(0) * Constants.Values.Drivetrain.GEARING_FACTOR; }
  public double getRightTheta() { return rightMotor1.getSelectedSensorPosition(0) * Constants.Values.Drivetrain.GEARING_FACTOR; }
  public double getLeftOmega() { return leftMotor1.getSelectedSensorVelocity(0) * Constants.Values.Drivetrain.GEARING_FACTOR * 10; }
  public double getRightOmega() { return rightMotor1.getSelectedSensorVelocity(0) * Constants.Values.Drivetrain.GEARING_FACTOR * 10; }
  public double getLeftPosition() { return getLeftTheta() * Constants.Values.Drivetrain.WHEEL_DIAMETER; }
  public double getRightPosition() { return getRightTheta() * Constants.Values.Drivetrain.WHEEL_DIAMETER; }
  public double getLeftVelocity() { return getLeftOmega() * Constants.Values.Drivetrain.WHEEL_DIAMETER; }
  public double getRightVelocity() { return getRightOmega() * Constants.Values.Drivetrain.WHEEL_DIAMETER; }

  private static Drivetrain instance;
  public static Drivetrain getInstance() { return instance == null ? (instance = new Drivetrain()) : instance; }
}
