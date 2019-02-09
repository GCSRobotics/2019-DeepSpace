package frc.robot;

import frc.robot.commands.DriveWithController;
class Tester
{
    public static void main(String[] args)
    {
        while (true){
            
            double rawAxis = .0000000000000001;
            double brakeAxis = 0.0;
            System.out.println(DriveWithController.formatSpeed(rawAxis, brakeAxis));
        }
        
        

    }
}