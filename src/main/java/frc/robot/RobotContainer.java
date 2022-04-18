// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunMotorCommand;
import frc.robot.commands.SetMotorRotationCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private MotorSubsystem motorSubsystem;

  private Joystick joystick;
  private JoystickButton buttonA;
  private JoystickButton buttonB;
  private JoystickButton buttonX;

  public RobotContainer() {
    motorSubsystem = new MotorSubsystem();
    joystick = new Joystick(0);
    buttonA = new JoystickButton(joystick, 2);
    buttonB = new JoystickButton(joystick, 3);
    buttonX = new JoystickButton(joystick, 1);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    buttonA.whenPressed(new RunMotorCommand(motorSubsystem, 0.1));
    buttonB.whenPressed(new RunMotorCommand(motorSubsystem, 0));
    buttonX.whenPressed(new SetMotorRotationCommand(motorSubsystem, !motorSubsystem.getRotation()));
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
