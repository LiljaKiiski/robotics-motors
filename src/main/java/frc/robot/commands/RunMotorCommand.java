// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MotorSubsystem;

public class RunMotorCommand extends CommandBase {
  
  MotorSubsystem motorSubsystem;
  boolean done = false;
  double speed;

  public RunMotorCommand(MotorSubsystem motorSubsystem, double speed) {
    this.motorSubsystem = motorSubsystem;
    this.speed = speed;
    addRequirements(motorSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    motorSubsystem.setMotorSpeed(speed);
    done = true;
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return done;
  }
}
