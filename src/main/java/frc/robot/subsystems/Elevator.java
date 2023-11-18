// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.QuestionTwoConstants;

public class Elevator extends SubsystemBase {
  private final CANSparkMax leftMotor = new CANSparkMax(0, MotorType.kBrushless);  
  private final CANSparkMax rightMotor = new CANSparkMax(1, MotorType.kBrushless);

  private final DifferentialDrive elevator = new DifferentialDrive(leftMotor, rightMotor);

  private boolean raised;

  public Elevator() {
    rightMotor.setInverted(true);
  }

  public boolean isRaised() {
    return raised; // gettr for extended
  }

  public void raise() {
    elevator.arcadeDrive(QuestionTwoConstants.pwr, 0);
    raised = true;
  }

  public void lower() {
    elevator.arcadeDrive(QuestionTwoConstants.pwr * -1, 0);
    raised = false;
  }
}
