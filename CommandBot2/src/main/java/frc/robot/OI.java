/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import frc.robot.controllers.*;
import frc.robot.enums.ControllerType;
import frc.robot.properties.RobotMap;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private BaseController DriverControl;
  private BaseController OperatorControl;

  public OI() {
    ControllerInit(ControllerType.PS4, ControllerType.PS4);
  }

  public OI(ControllerType driveType, ControllerType operatorType) {
    ControllerInit(driveType, operatorType);
  }

  private void ControllerInit(ControllerType driveCtrlType, ControllerType operateCtrlType) {
    DriverControl = BaseController.CreateInstance(driveCtrlType, RobotMap.DriveJoystick);
    OperatorControl = BaseController.CreateInstance(operateCtrlType, RobotMap.OperateJoystick);
    ButtonActionInit();
  }

  private void ButtonActionInit() {

    // Driver buttons.
    DriverControl.ButtonY.whileHeld(new StartClimb());
    DriverControl.ButtonX.whileHeld(new RetractClimb());

    // Operator buttons.
    OperatorControl.ButtonA.whenPressed(new StoreHatch());
    OperatorControl.ButtonX.whenPressed(new LowerHatchArm());
    OperatorControl.ButtonB.whenPressed(new PickupHatch());
    OperatorControl.ButtonY.whenPressed(new DeliverHatch());
    OperatorControl.ButtonL1.whenPressed(new PlaceCargoInRocket());
    OperatorControl.ButtonR1.whenPressed(new PlaceCargoInShip());
    OperatorControl.ButtonOptionL.whenPressed(new ClearCargoSwitch());
  }

  public BaseController GetDriverControl() {
    return DriverControl;
  }

  public BaseController GetOperatorControl() {
    return OperatorControl;
  }
}
