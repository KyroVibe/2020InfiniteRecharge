package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {

  public static XboxController gamepad1, gamepad2;
  public static JoystickButton buttonA;

  static {

    gamepad1 = new XboxController(0);
    gamepad2 = new XboxController(1);

    buttonA = new JoystickButton(gamepad2, 1);
    

  }

}
