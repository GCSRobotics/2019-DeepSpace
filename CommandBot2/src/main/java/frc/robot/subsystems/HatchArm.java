/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.properties.RobotMap;

/**
 * Add your docs here.
 */
public class HatchArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final SpeedController armMotor = new PWMVictorSPX(RobotMap.ArmMotor);
  private final DigitalInput limitSwitch = new DigitalInput(0);


  public HatchArm() {
    super("Hatch Arm");
    addChild((PWMVictorSPX) armMotor);
    // armLimiter.setLimitsRaw(lower, upper); Ask about this!!
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Extend() {
    armMotor.set(1);
  }

  public void Retract() {
    armMotor.set(-1);
  }

  public void Stop() {
    armMotor.set(0);
  }

  public boolean isLimitSwitchTriggered()
  {
    return limitSwitch.get();
  }
}
