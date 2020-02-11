/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import org.team997coders.spartanlib.math.MathUtils;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  /**
   * Creates a new ArcadeDrive.
   */
  double left, right;
  public ArcadeDrive() {
    //System.out.println("sadness");
    addRequirements(DriveTrain.getInstance());
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forward = -OI.getInstance().gamepad1.getRawAxis(1);
    double turn = OI.getInstance().gamepad1.getRawAxis(4);

    forward = MathUtils.deadband(forward, 0.1);
    turn = MathUtils.deadband(turn, 0.1);

    forward *= 0.2;
    turn *= 0.2;

    left = forward + turn;
    right = forward - turn;
    
    // DriveTrain.getInstance().simpleAccelControl(left, right);
    DriveTrain.getInstance().setMotors(left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.getInstance().setMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
