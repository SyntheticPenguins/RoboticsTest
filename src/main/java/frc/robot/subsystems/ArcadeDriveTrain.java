// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.TeleopDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArcadeDriveTrain extends SubsystemBase {

  private final CANSparkMax leftMotorOne = new CANSparkMax(0, MotorType.kBrushless);
  private final CANSparkMax leftMotorTwo = new CANSparkMax(2, MotorType.kBrushless);

  
  private final CANSparkMax rightMotorOne = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax rightMotorTwo = new CANSparkMax(2, MotorType.kBrushless);

  private final MotorControllerGroup rightMCG = new MotorControllerGroup(rightMotorOne, rightMotorTwo);
  private final MotorControllerGroup leftMCG = new MotorControllerGroup(leftMotorOne, leftMotorTwo);

  private final DifferentialDrive driveTrain = new DifferentialDrive(leftMCG, rightMCG);

  private final Joystick m_controller;

  public ArcadeDriveTrain(final Joystick controller) {
    rightMotorOne.setInverted(true);
    rightMotorTwo.setInverted(true);

    m_controller = controller;

    setDefaultCommand(new TeleopDrive(this, m_controller)); // joystick control command
  }

  public void arcadeDrive(final double moveVel, final double turnVel) {
    driveTrain.arcadeDrive(moveVel, turnVel);
  }
}
