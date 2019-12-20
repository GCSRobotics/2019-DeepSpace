package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ClimbIdle;
import frc.robot.properties.RobotMap;

public class Cannon extends Subsystem
{
    Compressor c = new Compressor(0);
    Solenoid fireSolenoid = new Solenoid(0);
    DoubleSolenoid loadSolenoid = new DoubleSolenoid(1,2);


    public Cannon(){
        loadSolenoid.set(DoubleSolenoid.Value.kOff);
        fireSolenoid.set(false);
    }

    public void initDefaultCommand()
    {
        //setDefaultCommand(new ClimbIdle());
    }

    public void OpenLoadSolenoid()
    {
        loadSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void CloseLoadSolenoid()
    {
        loadSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void OpenFireSolenoid()
    {
        fireSolenoid.set(true);
    }

    public void CloseFireSolenoid(){
        fireSolenoid.set(false);
    }
}