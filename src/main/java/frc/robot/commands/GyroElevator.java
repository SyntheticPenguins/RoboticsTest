// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gyroscope;
import frc.robot.Constants.QuestionFourConstants;


import java.util.Arrays;

public class GyroElevator extends CommandBase {
  private final Gyroscope m_gyro;
  private boolean ideal;

  public GyroElevator(final Gyroscope gyro) {
    m_gyro = gyro;
    addRequirements(m_gyro);

    ideal = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Arrays.equals(m_gyro.getOrientation(), QuestionFourConstants.idealOrientation)) {
      ideal = true; // this is the angle we want
    } else {
      ideal = false; // this is not the angle we want;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Ideal Orientation Achieved: ", ideal);
    System.out.print("Ideal orientation achieved: " + ideal);

    if (ideal) {
        new Elevator().raise(); // raise the elevator
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
