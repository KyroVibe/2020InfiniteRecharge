package frc.robot;

import org.opencv.core.Point;
import org.team997coders.spartanlib.motion.pathfinder.GenerationOverlord;
import org.team997coders.spartanlib.motion.pathfinder.TrajectoryIngredients;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.*;
import jaci.pathfinder.Waypoint;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Robot extends TimedRobot {

  private Command m_autonomousCommand;

  Command autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {

    //GenerationOverlord.getInstance().addIngredient();

    new TrajectoryIngredients("name", null, new Waypoint(3.0494663582157404, -0.705, 0.0));

    CommandScheduler.getInstance().cancelAll();

    m_chooser.setDefaultOption("Do Nothing", new InstantCommand(() -> System.out.println("Doing Nothing")));
  }

  @Override
  public void robotPeriodic() { }

  @Override
  public void disabledInit() { }

  @Override
  public void disabledPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
