/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.properties;

import frc.robot.Robot;

/**
 * Defines properties of the Cargo Conveyor.
 */
public class Drive {
    public static int LeftFrontCIM = Robot.getPreferences().getInt("LeftFrontCIM-PWM", 0);
    public static int LeftRearCIM = Robot.getPreferences().getInt("LeftRearCIM-PWM", 1);
    public static int RightFrontCIM = Robot.getPreferences().getInt("RightFrontCIM-PWM", 2);
    public static int RightRearCIM = Robot.getPreferences().getInt("RightRearCIM-PWM", 3);
}