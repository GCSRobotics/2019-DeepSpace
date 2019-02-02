/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.properties;

/**
 * Holder class for robot control values.
 */
public class RobotMap {
    // Camera values.
    public static final int HatchCamera = 0;
    public static final int DriveCamera = 1;

    // Motor values.
    public static final int LeftFrontMotor = 0;
    public static final int LeftRearMotor = 1;
    public static final int RightFrontMotor = 2;
    public static final int RightRearMotor = 3;

    // Conveyor values.
    public static final int ArmMotor = 4;
    public static final int ConveyorMotor = 5;

    // Joystick values.
    public static final int DriveJoystick = 0;
    public static final int OperateJoyStick = 1;

    // Joystick button values.
    public static final int ButtonY = 0;
    public static final int ButtonX = 1;
    public static final int ButtonA = 2;
    public static final int ButtonB = 3;
    public static final int ButtonL1 = 4;
    public static final int ButtonR1 = 5;
    public static final int ButtonL2 = 6;
    public static final int ButtonR2 = 7;

    // Pickup values.
    public static final int PickupButton = 1;
    public static final int ShootButton = 2;
    public static final int ClearButton = 3;
    public static final int LowerArmButton = 4;
    public static final int RaiseArmButton = 5;
    
    // Joystick axis arcade drive values.
    public static final int ArcadeSpeedAxis = 1;
    public static final int ArcadeRotationAxis = 4;

    // Joystick axis tank drive values.
    public static final int TankLeftSpeedAxis = 1;
    public static final int TankRightSpeedAxis = 5;

}
