package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterSubsystem {
    //The motor that is needed to spin  
    public DcMotor shooterMotor;
    
    // HardwareMap lets us find the physical motor connected to the robot.
    public ShooterSubsystem(HardwareMap hardwareMap){
        shooterMotor = hardwareMap.get(DcMotor.class,"shooter");
    }
     // This method controls the direction of the shooter.
    //
    // forward = true  -> spin the shooter forward
    // back = true     -> spin the shooter backward
    // both false      -> stop the shooter
    //
    // We use booleans (true/false) to tell the subsystem what
    // the driver wants the shooter to do.
    public void shoot(boolean forward, boolean back){
        if(forward){
            shooterMotor.setPower(ConstantFile.ShooterConstants.powerForward);
        }else if(back){
            shooterMotor.setPower(ConstantFile.ShooterConstants.powerBackward);
        }else{
            shooterMotor.setPower(ConstantFile.ShooterConstants.noPower);
        }
    }

}
