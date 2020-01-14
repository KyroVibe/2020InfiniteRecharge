package frc.robot;

import org.team997coders.spartanlib.motion.pathfinder.TrajectoryIngredients;

import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.Trajectory.FitMethod;

public class Pathfinder {

  public static TrajectoryIngredients testPath = new TrajectoryIngredients("TestPath",
    new Trajectory.Config(FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_LOW, 0.02,
      Constants.Values.Drivetrain.MAX_VELOCITY,
      Constants.Values.Drivetrain.MAX_ACCELERATION,
      60),
      new Waypoint(3.0494663582157404, -0.705, 0.0),
      new Waypoint(8.02648665990959, -0.705, 0.0));

}