package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Class specifically made to idle the climb motor efficiently.
 */
public class ClimbIdle extends Command
{
    public ClimbIdle()
    {
        requires(Robot.Climb);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}