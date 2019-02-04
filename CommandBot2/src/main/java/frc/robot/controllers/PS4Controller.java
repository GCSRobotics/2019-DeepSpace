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
public class PS4Controller extends BaseController {
    public Button ButtonPS;
    public Button ButtonPad;

    /**
     * Represents a digital button on an PS4Controller.
     */
    private enum buttons {
        Square(1), X(2), Circle(3), Triangle(4), 
        L1(5), R1(6), L2(7), R2(8), 
        Share(9), Option(10), 
        LStick(11), RStick(12), 
        PS(13), Pad(14);

        private final int value;
        buttons(int value) {
            this.value = value;
        }
    }

    protected PS4Controller(final int port) {
        super(port);

        //Define the Properties
        ButtonA = new JoystickButton(this, buttons.Square.value);
        ButtonX = new JoystickButton(this, buttons.X.value);
        ButtonB = new JoystickButton(this, buttons.Triangle.value);
        ButtonY = new JoystickButton(this, buttons.Circle.value);
        ButtonL1 = new JoystickButton(this, buttons.L1.value);
        ButtonR1 = new JoystickButton(this, buttons.R1.value);
        ButtonL2 = new JoystickButton(this, buttons.L2.value);
        ButtonR2 = new JoystickButton(this, buttons.R2.value);
        ButtonStickL = new JoystickButton(this, buttons.LStick.value);
        ButtonStickR = new JoystickButton(this, buttons.RStick.value);
        ButtonOptionL = new JoystickButton(this, buttons.Share.value);
        ButtonOptionR = new JoystickButton(this, buttons.Option.value);
        ButtonPS = new JoystickButton(this, buttons.PS.value);
        ButtonPad = new JoystickButton(this, buttons.Pad.value);
    }

    public double GetAxis_LeftX() {
        return this.getRawAxis(0);
    }

    public double GetAxis_LeftY() {
        return this.getRawAxis(1);
    }

    public double GetAxis_RightX() {
        return this.getRawAxis(2);
    }

    public double GetAxis_RightY() {
        return this.getRawAxis(5);
    }

    public double GetTrigger_Left(){
        return this.getRawAxis(3);
    }

    public double GetTrigger_Right(){
        return this.getRawAxis(4);
    }

}
