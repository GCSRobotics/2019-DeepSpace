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
import frc.robot.properties.Conveyor;

/**
 * Add your docs here.
 */
public class CargoConveyor extends Subsystem {

  // Define Motors used in sub system.
  private final SpeedController pickupMotor = new PWMVictorSPX(Conveyor.Motor);

  // Sensors?

  public CargoConveyor() {
    // Configure dependant objects as children so details can be displayed on smart dashboard
    addChild("Pickup Motor", (PWMVictorSPX) pickupMotor);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ForwardFullSpeed() {
    pickupMotor.set(1);
  }

  public void ReverseFullSpeed() {
    pickupMotor.set(-1);
  }

  public void ForwardHalfSpeed() {
    pickupMotor.set(0.5);
  }

  public void ReverseHalfSpeed() {
    pickupMotor.set(-0.5);
  }

  public void RunAtSpeed(int speed) {
    pickupMotor.set(speed);
  }

  public void FullStop() {
    pickupMotor.set(0);
  }

}
