package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ClimbIdle;
import frc.robot.properties.RobotMap;

public class Climb extends Subsystem
{
    private static final PWMVictorSPX climbMotor = new PWMVictorSPX(RobotMap.ClimMotor);

    public void initDefaultCommand()
    {
        setDefaultCommand(new ClimbIdle());
    }

    public Climb()
    {
        super("Climb");
        this.addChild(climbMotor);
    }

    /**
     * Sets the speed of the motor.
     * <i><b>THIS MOTOR SHOULD NEVER BE RUN BACKWARDS!!</b></i>
     * 
     * @param speed The speed at which to set the motor, from 1.0 to 0.0.
     */
    public void setSpeed(double speed)
    {
        if(speed > 1.0 || speed < 0)
        {
            System.out.println("Speed " + speed + " is out of range.");
            speed = 0;
        }

        climbMotor.set(speed);
    }

    public void moveForward()
    {
        setSpeed(.3);
    }

    public void stop()
    {
        setSpeed(0);
    }


}