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
    this(driveCtrl, DriveMode.ArcadeDouble);  //default to Arcade Double stick
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
    switch(driveMode)
    {
      case ArcadeSingle : 
        if(driveStick.ButtonR2.get()){
          Robot.Drive.arcadeDrive(driveStick.GetAxis_LeftY()/2, driveStick.GetAxis_LeftX()/2);

        } else {
          Robot.Drive.arcadeDrive(driveStick.GetAxis_LeftY(), driveStick.GetAxis_LeftX());
        }
        break;
      case ArcadeDouble : 
        if(driveStick.ButtonR2.get()){
          Robot.Drive.arcadeDrive(driveStick.GetAxis_LeftY()/2, driveStick.GetAxis_RightX()/2);

        } else {
          Robot.Drive.arcadeDrive(driveStick.GetAxis_LeftY(), driveStick.GetAxis_RightX());
        }
        break;
      case Tank : 
      if(driveStick.ButtonR2.get()){
        Robot.Drive.tankDrive(driveStick.GetAxis_LeftY()/2, driveStick.GetAxis_RightY()/2);

      } else {
        Robot.Drive.tankDrive(driveStick.GetAxis_LeftY(), driveStick.GetAxis_RightY());
      }
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
