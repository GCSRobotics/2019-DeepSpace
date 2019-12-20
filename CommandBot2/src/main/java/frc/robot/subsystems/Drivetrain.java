/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.properties.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private static final WPI_VictorSPX RearRightMotor = new WPI_VictorSPX(RobotMap.RightRearMotor);
  private static final WPI_VictorSPX FrontRightMotor = new WPI_VictorSPX(RobotMap.RightFrontMotor);
  private static final WPI_VictorSPX RearLeftMotor = new WPI_VictorSPX(RobotMap.LeftRearMotor);
  private static final WPI_VictorSPX FrontLeftMotor = new WPI_VictorSPX(RobotMap.LeftFrontMotor);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final SpeedControllerGroup speedControllerGroupLeft = 
    new SpeedControllerGroup(FrontLeftMotor, RearLeftMotor);
  private final SpeedControllerGroup speedControllerGroupRight = 
    new SpeedControllerGroup(FrontRightMotor, RearRightMotor);
  private final DifferentialDrive robotDrive = 
    new DifferentialDrive(speedControllerGroupLeft, speedControllerGroupRight);

  public Drivetrain() {
    super("Drivetrain");
    addChild((WPI_VictorSPX) RearLeftMotor);
    addChild((WPI_VictorSPX) RearRightMotor);
    addChild((WPI_VictorSPX) FrontLeftMotor);
    addChild((WPI_VictorSPX) FrontRightMotor);
    addChild((SpeedControllerGroup) speedControllerGroupLeft);
    addChild((SpeedControllerGroup) speedControllerGroupRight);
    addChild((DifferentialDrive) robotDrive);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**
   * Tank drive using individual joystick axes.
   *
   * @param leftSpeedAxis Left sides value
   * @param rightSpeedAxis Right sides value
   */
  public void tankDrive(double leftSpeedAxis, double rightSpeedAxis) {
    robotDrive.tankDrive(leftSpeedAxis, rightSpeedAxis);
  }


 /**
   * Tank drive using a PS3 joystick.
   *
   * @param joy PS3 style joystick to use as the input for tank drive.
   */
  public void arcadeDrive(Joystick joy) {
    robotDrive.arcadeDrive(joy.getY(), joy.getRawAxis(4), true);
  }
 
    /**
   * Tank drive using individual joystick axes.
   *
   * @param speedAxis Left sides value
   * @param rotationAxis Right sides value
   */
  public void arcadeDrive(double speedAxis, double rotationAxis) {
    robotDrive.arcadeDrive(speedAxis, rotationAxis, true);
  }

  public void arcadeDrive(double speedAxis, double rotationAxis, boolean squared) {
    robotDrive.arcadeDrive(speedAxis, rotationAxis, squared);
  }


  /**
   * Stop the drivetrain from moving.
   */
  public void stop() {
    robotDrive.tankDrive(0, 0);
  }}
