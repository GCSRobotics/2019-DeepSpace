package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ClimbIdle;
import frc.robot.properties.RobotMap;

public class Climb extends Subsystem
{
    private static final SpeedController climbMotor = new PWMVictorSPX(RobotMap.ClimMotor);

    public void initDefaultCommand()
    {
        setDefaultCommand(new ClimbIdle());
    }

    public Climb()
    {
        super("Climb");
        this.addChild((PWMVictorSPX)climbMotor);
    }

    /**
     * Sets the speed of the motor.
     * 
     * @param speed The speed at which to set the motor, from 1.0 to 0.0.
     */
    public void setSpeed(double speed)
    {
        System.out.println("Setting speed to " + speed);
        climbMotor.set(speed);
    }

    public void moveForward()
    {
        System.out.println("moveForward() called.");
        setSpeed(.7);
    }

    public void moveReverse()
    {
        System.out.println("moveReverse() called.");
        setSpeed(-.3);
    }

    public void stop()
    {
        System.out.println("stop() called.");
        setSpeed(0);
    }
}