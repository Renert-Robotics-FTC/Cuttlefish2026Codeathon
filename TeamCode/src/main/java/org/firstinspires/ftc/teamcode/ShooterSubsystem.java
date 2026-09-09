package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterSubsystem {
    public DcMotor shooterMotor;//The motor that is needed to spin

    public ShooterSubsystem(HardwareMap hardwareMap){
        shooterMotor = hardwareMap.get(DcMotor.class,"shooter");
    }

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