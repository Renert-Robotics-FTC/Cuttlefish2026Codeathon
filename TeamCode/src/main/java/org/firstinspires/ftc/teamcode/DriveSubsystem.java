package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem {
    final DcMotor FR;
    final DcMotor BR;
    final DcMotor FL;
    final DcMotor BL;


    private double straight;
    private double turn;
    private double strafe;

    public DriveSubsystem(HardwareMap hardwareMap) {
        FR = hardwareMap.get(DcMotor.class, "FR");
        BR = hardwareMap.get(DcMotor.class, "BR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        BL = hardwareMap.get(DcMotor.class, "BL");

        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        BL.setDirection(DcMotor.Direction.REVERSE);
        FL.setDirection(DcMotor.Direction.REVERSE);
    }

    public void updateInputs(double newStraight, double newStrafe, double newTurn) {
        straight = newStraight;
        strafe = newStrafe;
        turn = newTurn;

    }
    public void update() {
        double bottomnumber = Math.max(
                1.0,
                Math.abs(straight) + Math.abs(strafe) + Math.abs(turn)
        );
        double speedcapfactor = 1.0 / bottomnumber;
        BL.setPower((straight + strafe + turn) * speedcapfactor);
        FL.setPower((straight - strafe + turn) * speedcapfactor);
        BR.setPower((straight - strafe - turn) * speedcapfactor);
        FR.setPower((straight + strafe - turn) * speedcapfactor);

    }
}