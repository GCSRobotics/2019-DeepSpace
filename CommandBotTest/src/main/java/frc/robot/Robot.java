/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.DriveWithJoystick;
import frc.robot.enums.DriveMode;
import frc.robot.subsystems.CargoConveyor;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Electrical;
import frc.robot.subsystems.HatchArm;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // Define the subsystems
  public static Electrical electrical;
  public static DriveTrain drivetrain;
  public static CargoConveyor conveyor;
  public static HatchArm arm;

  // Define operator controls
  public static OI oi;

  SendableChooser<Command> autonChooser = new SendableChooser<>();
  SendableChooser<Command> teleChooser = new SendableChooser<>();
  Command autonomousCommand;
  Command teleOpCommand;
  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // Initialize Subsystems
    electrical = new Electrical();
    drivetrain = new DriveTrain();
    conveyor = new CargoConveyor();
    arm = new HatchArm();

    // Initialize Operator Interface
    oi = new OI();

    DashboardInit();
  }

  private void DashboardInit() {
    //Auton Mode Selections
    autonChooser.setDefaultOption("Tank Drive", new DriveWithJoystick(DriveMode.Tank));
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Autono Mode - Disable/Enable to change", autonChooser);

    //TeleOp Mode Selections
    teleChooser.setDefaultOption("Tank Drive", new DriveWithJoystick(DriveMode.Tank));
    teleChooser.addOption("Arcade (Single Stick)", new DriveWithJoystick(DriveMode.ArcadeSingle));
    teleChooser.addOption("Arcade (Double Stick)", new DriveWithJoystick(DriveMode.ArcadeDouble));
    SmartDashboard.putData("TeleOp Mode - Disable/Enable to change", teleChooser);

    //Display Scheduled Commands
    SmartDashboard.putData(Scheduler.getInstance());

    //Subsystem Displays
    SmartDashboard.putData("Electrical", electrical);
    SmartDashboard.putData("Drivetrain", drivetrain);
    SmartDashboard.putData("Conveyor", conveyor);
    SmartDashboard.putData("Hatch Arm", arm);

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
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // schedule the autonomous command (example)
    autonomousCommand = autonChooser.getSelected();
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
    System.out.println("Teleop Init: Command = " + autonomousCommand);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    Scheduler.getInstance().removeAll();

    teleOpCommand = teleChooser.getSelected();
    if (teleOpCommand != null) {
      drivetrain.setDefaultCommand(teleOpCommand);
    }

    System.out.println("Teleop Init: Command = " + teleOpCommand);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    Scheduler.getInstance().removeAll();

    //Add Commands to test with
    SmartDashboard.putData("Drive With Joystick", new DriveWithJoystick());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
