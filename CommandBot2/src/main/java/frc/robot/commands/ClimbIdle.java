package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class specifically made to idle the climb motor efficiently.
 */
public class ClimbIdle extends Command
{
    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}