// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeDriveTrain;

public class TeleopDrive extends CommandBase {
  private final ArcadeDriveTrain m_arcadeDriveTrain;
  private final Joystick m_controller;

  public TeleopDrive(final ArcadeDriveTrain driveTrain, final Joystick controller) {
    m_arcadeDriveTrain = driveTrain;
    addRequirements(m_arcadeDriveTrain);

    m_controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_arcadeDriveTrain.arcadeDrive(m_controller.getY(), m_controller.getX());
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
