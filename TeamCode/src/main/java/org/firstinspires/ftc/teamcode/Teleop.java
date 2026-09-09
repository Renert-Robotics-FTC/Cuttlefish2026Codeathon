package org.firstinspires.ftc.teamcode;
//imports
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Main Teleop")
public class Teleop extends LinearOpMode{


    @Override
    public void runOpMode(){
        //create subsystem objects here
        boolean shootForward = false;
        boolean shootBack = false;
        ShooterSubsystem otherSystem = new ShooterSubsystem(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            //put loop code here
            shootForward = gamepad1.a;
            shootBack = gamepad1.b;
            otherSystem.shoot(shootForward, shootBack);


        }

    }


}
