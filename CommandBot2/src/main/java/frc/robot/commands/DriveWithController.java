/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.controllers.BaseController;
import frc.robot.enums.*;

public class DriveWithController extends Command {
  DriveMode driveMode;
  BaseController driveStick;

  public DriveWithController(BaseController driveCtrl) {
    this(driveCtrl, DriveMode.ArcadeDouble); // default to Arcade Double stick
    requires(Robot.Drive);
  }

  public DriveWithController(BaseController driveCtrl, DriveMode mode) {
    requires(Robot.Drive);
    this.driveStick = driveCtrl;
    this.driveMode = mode;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    var power = 3.0;
    var multiple = .75;

    // If the left bumper is held, do not limit the power of the motors.
    if(driveStick.ButtonL1.get()) multiple = 1;


    double speed = Math.pow(formatSpeed(driveStick.GetAxis_LeftY(), driveStick.GetTrigger_Right()), power) * multiple;
    double rotation;

    switch (driveMode) {
    case ArcadeSingle:
      rotation = Math.pow(driveStick.GetAxis_LeftX(), power) * multiple;

      Robot.Drive.arcadeDrive(speed, rotation, false);
      break;
    case ArcadeDouble:
      rotation = Math.pow(driveStick.GetAxis_RightX(), power) * multiple;
      Robot.Drive.arcadeDrive(speed, rotation, false);
      break;
    case Tank:
      double rightSpeed = Math.pow(formatSpeed(driveStick.GetAxis_RightY(), driveStick.GetTrigger_Right()), power) * multiple;
      Robot.Drive.tankDrive(speed, rightSpeed);
      break;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // always running.
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  /**
   * Modifies the value of an axis to account for other factors.
   * 
   * @param rawAxis   The axis to modify.
   * @param brakeAxis The axis of the break trigger.
   * @return The modified axis.
   */
  private static double formatSpeed(double rawAxis, double brakeAxis) {
    var speed = rawAxis;
    var modifier = brakeAxis;

    if (speed > 0) {
      speed -= modifier * .50;
      if (speed < 0)
        speed = 0;
    } else if (speed < 0) {
      speed += modifier * .50;
      if (speed > 0)
        speed = 0;
    }

    return speed;
  }
}
// ¯\_(ツ)_/¯ 
// GOOD JOB MOUNTAIN LLAMA