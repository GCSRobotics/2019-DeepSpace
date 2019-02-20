package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.controllers.BaseController;
import frc.robot.Robot;

public class IntakeCargo extends Command {
    private BaseController controller;

    public IntakeCargo(BaseController controller) {
        requires(Robot.Intake);
        this.controller = controller;
    }

    @Override
    protected void initialize() {
        Robot.Intake.initializeCounter();
    }

    @Override
    protected void execute() {
        double forwardSpeed = 0;
        double backwardSpeed = -((controller.GetTrigger_Left() + 1) / 2);
        
        if (!Robot.Intake.isSwitchSet()) {
            forwardSpeed = (controller.GetTrigger_Right() + 1) / 2;
        }
        double finalSpeed = forwardSpeed + backwardSpeed;

        Robot.Intake.setSpeed(finalSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}