package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

// Controls: Left Stick Y is forward and backward
// Left stick X, is left and right strafe
// Right stick X is robot rotation

@TeleOp(name = "Main Teleop")
public class Teleop extends LinearOpMode {

    boolean indexing = false;
    @Override
    public void runOpMode(){
        Odometry odo = new Odometry(hardwareMap);



        waitForStart();

        while (opModeIsActive()) {

            odo.update();
            telemetry.addData("X", odo.getXPosition());
             telemetry.addData("Y", odo.getYPosition());
                telemetry.addData("Heading", odo.Heading());
                    telemetry.update();
        }
    }
}

