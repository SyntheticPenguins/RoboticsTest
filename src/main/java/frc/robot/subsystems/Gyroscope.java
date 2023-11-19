// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

public class Gyroscope extends SubsystemBase {
  private final WPI_PigeonIMU m_gyro = new WPI_PigeonIMU(0);

  private double[] m_ypr = {0, 0, 0};

  public Gyroscope() {
    m_gyro.setYaw(0.0); // simply reset the yaw
  }

  @Override
  public void periodic() {
    // check constantly to update ypr

    m_gyro.getYawPitchRoll(m_ypr);

    m_ypr[0] %= 90; // yaw won't always be in the range -90 - 90, but we want to check the orientation, not the total amount the yaw has changed relative to the starting; therefore we must use mod 90
  }

  public double[] getOrientation() {return m_ypr;} // gettr for m_ypr
}
