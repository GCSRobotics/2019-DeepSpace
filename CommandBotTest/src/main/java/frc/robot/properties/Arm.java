/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.properties;

import frc.robot.Robot;

/**
 * Defines properties of the Hatch Arm.
 */
public class Arm {
    public static int Motor = Robot.getPreferences().getInt("HatchMotor-PWM", 5);
}
