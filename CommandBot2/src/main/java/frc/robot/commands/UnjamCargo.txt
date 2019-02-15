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

public class UnjamCargo extends Command {
  private BaseController controller = null;

  public UnjamCargo() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires (Robot.Intake);
    setTimeout(.5);
  }

  public UnjamCargo(BaseController controller)
  {
    requires(Robot.Intake);
    this.controller = controller;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (controller == null)
    {
      Robot.Intake.ReverseFullSpeed();
    }
    else
    {
      Robot.Intake.setSpeed((controller.GetTrigger_Left() + 1) / 2);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.Intake.Stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
