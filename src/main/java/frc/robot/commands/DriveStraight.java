// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeDriveTrain;

public class DriveStraight extends CommandBase {
  /** Creates a new DriveStraight. */

  private long m_endTime;
  private boolean turned;

  private final double m_moveVel;
  private final double m_turnVel;
  private final ArcadeDriveTrain m_driveTrain;

  public DriveStraight(final double moveVel, final double turnVel, final ArcadeDriveTrain driveTrain) {

    m_driveTrain = driveTrain;
    m_moveVel = moveVel;
    m_turnVel = turnVel;
    turned = false;

    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {m_endTime = System.currentTimeMillis() + 10000;} // give it the end time

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (System.currentTimeMillis() != m_endTime) {
      m_driveTrain.arcadeDrive(m_moveVel, 0);
    } else if (!turned) {
      m_driveTrain.arcadeDrive(m_turnVel, 1);
      turned = true;
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
