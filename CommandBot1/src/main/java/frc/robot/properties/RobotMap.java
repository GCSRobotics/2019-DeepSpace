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
    public static int HatchCamera = 0;
    public static int DriveCamera = 1;

    // Motor values.
    public static int LeftFrontMotor = 0;
    public static int LeftRearMotor = 1;
    public static int RightFrontMotor = 2;
    public static int RightRearMotor = 3;

    // Conveyor values.
    public static int ArmMotor = 4;
    public static int ConveyorMotor = 5;

    // Joystick values.
    public static int DriveJoystick = 0;
    public static int OperateJoyStick = 1;

    // Pickup values.
    public static int PickupButton = 1;
    public static int ShootButton = 2;
    public static int ClearButton = 3;
    public static int LowerArmButton = 4;
    public static int RaiseArmButton = 5;
    
    // Joystick axis arcade drive values.
    public static int ArcadeSpeedAxis = 1;
    public static int ArcadeRotationAxis = 4;

    // Joystick axis tank drive values.
    public static int TankLeftSpeedAxis = 1;
    public static int TankRightSpeedAxis = 5;

}
