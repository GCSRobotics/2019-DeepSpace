/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  //Subsystem devices
  private final SpeedController frontLeftCIM = new PWMVictorSPX(0);
  private final SpeedController frontRightCIM = new PWMVictorSPX(1);

  private final DifferentialDrive dDrive;

  public DriveTrain(){
    // Configure drive motors
    addChild("Front Left CIM", (PWMVictorSPX) frontLeftCIM);
    addChild("Front Right CIM", (PWMVictorSPX) frontRightCIM);
    
    // Configure the DifferentialDrive to reflect the fact that all motors
    // are wired backwards (right is inverted in DifferentialDrive).
    frontLeftCIM.setInverted(true);

    dDrive = new DifferentialDrive(frontLeftCIM, frontRightCIM);
    dDrive.setSafetyEnabled(true);
    dDrive.setExpiration(0.1);
    dDrive.setMaxOutput(1.0);
 }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

 /**
   * Tank drive using a PS3 joystick.
   *
   * @param joy PS3 style joystick to use as the input for tank drive.
   */
  public void tankDrive(Joystick joy) {
    dDrive.tankDrive(joy.getY(), joy.getRawAxis(4));
  }

  /**
   * Tank drive using individual joystick axes.
   *
   * @param leftAxis Left sides value
   * @param rightAxis Right sides value
   */
  public void tankDrive(double leftAxis, double rightAxis) {
    dDrive.tankDrive(leftAxis, rightAxis);
  }


 /**
   * Tank drive using a PS3 joystick.
   *
   * @param joy PS3 style joystick to use as the input for tank drive.
   */
  public void arcadeDrive(Joystick joy) {
    dDrive.arcadeDrive(joy.getY(), joy.getRawAxis(4), true);
  }
 
    /**
   * Tank drive using individual joystick axes.
   *
   * @param leftAxis Left sides value
   * @param rightAxis Right sides value
   */
  public void arcadeDrive(double leftAxis, double rightAxis) {
    dDrive.arcadeDrive(leftAxis, rightAxis, true);
  }


  /**
   * Stop the drivetrain from moving.
   */
  public void stop() {
    dDrive.tankDrive(0, 0);
  }
}
