package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class Shooter implements Subsystem {

  private CANSparkMax motor;
  private CANEncoder encoder;
  private CANPIDController controller;

  private Shooter() {
    motor = new CANSparkMax(Constants.Ports.Shooter.MOTOR_NEO, MotorType.kBrushless);
    encoder = motor.getEncoder();
    encoder.setPosition(0.0);
    controller = motor.getPIDController();
  }

}