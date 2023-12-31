// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.QuestionOneConstants;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.GyroElevator;
import frc.robot.commands.RaiseElevator;
import frc.robot.subsystems.ArcadeDriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gyroscope;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Joystick controller = new Joystick(4);

  // question 1
  private final ArcadeDriveTrain m_arcadeDriveTrain = new ArcadeDriveTrain(controller);

  // question 2
  private final Elevator m_Elevator = new Elevator();

  // question 4
  private final Gyroscope m_Gyroscope = new Gyroscope();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // question 2
    m_driverController.y().onTrue(new RaiseElevator(m_Elevator)); // jump button should be the top button, fight me

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(final int currProblem) {
    // currProblem is just know which question's command it should be using

    Command cmd = new CommandBase() {}; // if nothing happens, return an empty command
    if (currProblem == 1) {
      cmd = new DriveStraight(QuestionOneConstants.moveVel, QuestionOneConstants.turnVel, m_arcadeDriveTrain);
    } else if (currProblem == 4) {
      cmd = new GyroElevator(m_Gyroscope);
    }

    return cmd;
  }
}
