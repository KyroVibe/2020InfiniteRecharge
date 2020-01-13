package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class Intake implements Subsystem {

  private CANSparkMax motor;

  private Intake() {
    motor = new CANSparkMax(Constants.Ports.Intake.MOTOR_550, MotorType.kBrushless);
  }

}