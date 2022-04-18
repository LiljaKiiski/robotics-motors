// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
 
  TalonFX motor;

  public MotorSubsystem() {
    motor = new TalonFX(40);

    Thread printThread = new Thread(

    new Runnable(){

      @Override
      public void run() {
        System.out.println(motor.getSelectedSensorPosition());
        System.out.println(motor.getInverted());
        
        try {
          System.out.println(Thread.currentThread());
          Thread.sleep(100);
        } catch (Exception e) {
          e.printStackTrace();
        }
      };
    });
    printThread.start();
  }

  public void setMotorSpeed(double speed){
    System.out.println("setting speed to: " + speed);
    motor.set(ControlMode.PercentOutput, speed);
  }

  public void stopMotor(){
    motor.set(ControlMode.PercentOutput, 0);
  }

  public void setRotation(boolean inverted){
    motor.setInverted(inverted);
  }

  public boolean getRotation(){
    System.out.println("-----" + motor.getInverted());
    return motor.getInverted();
  }

  @Override
  public void periodic() {

  }
}