/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.properties.Arm;

/**
 * Add your docs here.
 */
public class HatchArm extends Subsystem {
    // Define Motors used in sub system.
    private final SpeedController armMotor = new PWMVictorSPX(Arm.Motor);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public HatchArm() {
    // Configure dependant objects as children so details can be displayed on smart
    // dashboard
    addChild("Arm Motor", (PWMVictorSPX) armMotor);

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
}
