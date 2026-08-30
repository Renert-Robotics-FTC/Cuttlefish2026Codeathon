package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class DriveSubsystem {
    final DcMotor backleftmotor;
    final DcMotor backrightmotor;
    final DcMotor frontrightmotor;
    final DcMotor frontleftmotor;

    public DriveSubsystem(HardwareMap hardwareMap) {
        backleftmotor = hardwareMap.get(DcMotor.class, "BL");
        backrightmotor = hardwareMap.get(DcMotor.class,"BR");
        frontrightmotor = hardwareMap.get(DcMotor.class,"FR");
        frontleftmotor = hardwareMap.get(DcMotor.class,"FL");

    }
}