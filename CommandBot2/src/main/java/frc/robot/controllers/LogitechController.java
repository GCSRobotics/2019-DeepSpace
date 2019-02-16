/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllers;

import edu.wpi.first.wpilibj.buttons.*;

/**
 * Handle input from PS4 controllers connected to the Driver Station.
 */
public class LogitechController extends BaseController {
    /**
     * Represents a digital button on an XBox Controller.
     */
    private enum buttons {
        A(1), X(3), B(2), Y(4), LB(5), RB(6), Back(7), Start(8), LStick(9), RStick(10);

        private final int value;

        buttons(int value) {
            this.value = value;
        }
    }

    protected LogitechController(final int port) {
        super(port);

        // Define the Properties
        ButtonA = new JoystickButton(this, buttons.A.value);
        ButtonX = new JoystickButton(this, buttons.X.value);
        ButtonB = new JoystickButton(this, buttons.B.value);
        ButtonY = new JoystickButton(this, buttons.Y.value);
        ButtonL1 = new JoystickButton(this, buttons.LB.value);
        ButtonR1 = new JoystickButton(this, buttons.RB.value);
        // ButtonL2 = new JoystickButton(this, buttons.LT.value);
        // ButtonR2 = new JoystickButton(this, buttons.RT.value);
        ButtonStickL = new JoystickButton(this, buttons.LStick.value);
        ButtonStickR = new JoystickButton(this, buttons.RStick.value);
        ButtonOptionL = new JoystickButton(this, buttons.Back.value);
        ButtonOptionR = new JoystickButton(this, buttons.Start.value);
    }

    public double GetAxis_LeftX() {
        return this.getRawAxis(0);
    }

    public double GetAxis_LeftY() {
        return this.getRawAxis(1);
    }

    public double GetAxis_RightX() {
        return this.getRawAxis(4);
    }

    public double GetAxis_RightY() {
        return this.getRawAxis(5);
    }

    public double GetTrigger_Left() {
        return this.getRawAxis(2);
    }

    public double GetTrigger_Right() {
        return this.getRawAxis(3);
    }

}
