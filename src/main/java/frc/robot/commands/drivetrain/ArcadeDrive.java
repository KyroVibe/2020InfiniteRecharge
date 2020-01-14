package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase {

  public ArcadeDrive() {
    addRequirements(Drivetrain.getInstance());
  }

  @Override
  public void execute() {
    double forward = -OI.gamepad1.getRawAxis(Constants.Ports.OI.AXIS_LEFT_Y);
    double turn = OI.gamepad1.getRawAxis(Constants.Ports.OI.AXIS_RIGHT_X);

    double leftSpeed = forward + turn;
    double rightSpeed = forward - turn;

    Drivetrain.getInstance().setPercentSpeed(leftSpeed, rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("Arcade Drive has stopped");
  }

}