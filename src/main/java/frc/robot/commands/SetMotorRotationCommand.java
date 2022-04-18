// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorSubsystem;

public class SetMotorRotationCommand extends CommandBase {
  MotorSubsystem motorSubsystem;
  boolean done = false;
  boolean inverted;

  public SetMotorRotationCommand(MotorSubsystem motorSubsystem, boolean inverted) {
    this.motorSubsystem = motorSubsystem;
    this.inverted = inverted;
    System.out.println("NEW COMMAND!!!!!!!!");
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    motorSubsystem.setRotation(inverted);
    done = true;
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return done;
  }
}
