package frc.robot;

import frc.robot.commands.DriveWithController;
import java.util.Scanner;
class Tester
{
    public static void main(String[] args)
    {
        while (true){
            
            double rawAxis = 1.0;
            double brakeAxis = 1.0;
            System.out.println(DriveWithController.formatSpeed(rawAxis, brakeAxis));
        }
        

    }
}