/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.enums.*;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static HatchArm Arm = new HatchArm();
  public static CargoIntake Intake = new CargoIntake();
  public static Drivetrain Drive = new Drivetrain();
  public static Electrical Electric = new Electrical();

  SendableChooser<ControllerType> driveCtrlChooser = new SendableChooser<>();
  SendableChooser<ControllerType> operateCtrlChooser = new SendableChooser<>();
  SendableChooser<DriveMode> teleChooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    DashboardInit();
  }

  private void DashboardInit() {

    // Driver Controller Choices
    driveCtrlChooser.setDefaultOption("PS4", ControllerType.PS4);
    driveCtrlChooser.addOption("Logitech", ControllerType.Logitech);
    SmartDashboard.putData("Drive Controller Type", driveCtrlChooser);

    // Operator Controller Choices
    operateCtrlChooser.setDefaultOption("PS4", ControllerType.PS4);
    operateCtrlChooser.addOption("Logitech", ControllerType.Logitech);
    SmartDashboard.putData("Operator Controller Type", driveCtrlChooser);

    // TeleOp Mode Selections
    teleChooser.setDefaultOption("Tank Drive", DriveMode.Tank);
    teleChooser.addOption("Arcade (Single Stick)",DriveMode.ArcadeSingle);
    teleChooser.addOption("Arcade (Double Stick)",DriveMode.ArcadeDouble);
    SmartDashboard.putData("TeleOp Mode - Disable/Enable to change", teleChooser);

    // Display Scheduled Commands
    SmartDashboard.putData(Scheduler.getInstance());

    // Subsystem Displays
    // SmartDashboard.putData("Electrical", Electric);
    SmartDashboard.putData("Drivetrain", Drive);
    SmartDashboard.putData("Intake", Intake);
    SmartDashboard.putData("Hatch Arm", Arm);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    Scheduler.getInstance().removeAll();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    teleopInit();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

    /**
   * This function is called once each time the robot enters operator mode. 
   */
@Override
  public void teleopInit() {
    Scheduler.getInstance().removeAll();

    OI oi = new OI(driveCtrlChooser.getSelected(), operateCtrlChooser.getSelected());
    
    DriveMode teleOpMode = teleChooser.getSelected();
    System.out.println("Teleop Init: DriveMode = " + teleOpMode);

    Drive.setDefaultCommand(new DriveWithController(oi.GetDriverControl(), teleOpMode));
    Intake.setDefaultCommand(new IntakeCargo(oi.GetOperatorControl()));
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
