/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private static final PWMVictorSPX RearRightMotor = new PWMVictorSPX(3);
  private static final PWMVictorSPX FrontRightMotor = new PWMVictorSPX(2);
  private static final PWMVictorSPX RearLeftMotor = new PWMVictorSPX(1);
  private static final PWMVictorSPX FrontLeftMotor = new PWMVictorSPX(0);
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
    addChild((PWMVictorSPX) RearLeftMotor);
    addChild((PWMVictorSPX) RearRightMotor);
    addChild((PWMVictorSPX) FrontLeftMotor);
    addChild((PWMVictorSPX) FrontRightMotor);
    addChild((SpeedControllerGroup) speedControllerGroupLeft);
    addChild((SpeedControllerGroup) speedControllerGroupRight);
    addChild((DifferentialDrive) robotDrive);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
