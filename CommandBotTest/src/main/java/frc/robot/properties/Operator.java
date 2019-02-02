/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.properties;

import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Operator {
    public static int DriveJoystick = Robot.getPreferences().getInt("Drive-Joystick", 0);
    public static int OperateJoyStick = Robot.getPreferences().getInt("Operate-JoyStick", 1);

    public static int PickupButton = Robot.getPreferences().getInt("Pickup-Button", 1);
    public static int ShootButton = Robot.getPreferences().getInt("Shoot-Button", 2);
    public static int ClearButton = Robot.getPreferences().getInt("Clear-Button", 3);
    public static int LowerArmButton = Robot.getPreferences().getInt("LowerArm-Button", 4);
    public static int RaiseArmButton = Robot.getPreferences().getInt("RaiseArm-Button", 5);
    
    public static int ArcadeSpeedAxis = Robot.getPreferences().getInt("ArcadeSpeed-Axis", 1);
    public static int ArcadeRotationAxis = Robot.getPreferences().getInt("ArcadeRotation-Axis", 4);

    public static int TankLeftSpeedAxis = Robot.getPreferences().getInt("TankLeftSpeed-Axis", 1);
    public static int TankRightSpeedAxis = Robot.getPreferences().getInt("TankRightSpeed-Axis", 5);

}
