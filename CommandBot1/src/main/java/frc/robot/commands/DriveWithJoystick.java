/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.enums.*;
import frc.robot.properties.*;

public class DriveWithJoystick extends Command {
  DriveMode driveMode;

  public DriveWithJoystick() {
    this(DriveMode.ArcadeDouble);  //default to Arcade Double stick
  }
  public DriveWithJoystick(DriveMode mode) {
    requires(Robot.Drive);
    driveMode = mode;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Joystick driveStick = OI.DriverStick;
    switch(driveMode)
    {
      case ArcadeSingle : Robot.Drive.arcadeDrive(driveStick.getY(), driveStick.getX());
        break;
      case ArcadeDouble : Robot.Drive.arcadeDrive(driveStick.getRawAxis(RobotMap.ArcadeSpeedAxis), driveStick.getRawAxis(RobotMap.ArcadeRotationAxis));
        break;
      case Tank : Robot.Drive.tankDrive(driveStick.getRawAxis(RobotMap.TankLeftSpeedAxis), driveStick.getRawAxis(RobotMap.TankRightSpeedAxis));
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
}
