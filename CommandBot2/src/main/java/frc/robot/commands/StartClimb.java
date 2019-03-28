package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class StartClimb extends Command
{
    public StartClimb()
    {
        requires(Robot.Climb);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.Climb.moveForward();
    }

    @Override
    protected void interrupted() {
        // System.out.println("\nWe were interrupted!!!\n");
        // end();
    }

    // @Override
    // protected void end() {
    //     Robot.Climb.stop();
    // }


    
}