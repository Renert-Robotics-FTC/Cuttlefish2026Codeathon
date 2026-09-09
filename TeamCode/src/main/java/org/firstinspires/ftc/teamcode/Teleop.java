package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

// Controls: Left Stick Y is forward and backward
// Left stick X, is left and right strafe
// Right stick X is robot rotation

@TeleOp(name = "Main Teleop")
public class Teleop extends LinearOpMode {


    @Override
    public void runOpMode(){
        //create subsystem objects here
        boolean shootForward = false;
        boolean shootBack = false;
        ShooterSubsystem otherSystem = new ShooterSubsystem(hardwareMap);
        DcMotorEx pivotMotor = hardwareMap.get(DcMotorEx.class, "pivotMotor");
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);
        PivotSubsystem pivotSubsystem = new PivotSubsystem(pivotMotor);
     


        waitForStart();

        while (opModeIsActive()) {
            //put loop code here
            shootForward = gamepad1.left_bumper;
            shootBack = gamepad1.right_bumper;
            otherSystem.shoot(shootForward, shootBack);
            double straight = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            if (gamepad1.a) {
                pivotSubsystem.goToCore();
            }
            if (gamepad1.b) {
                pivotSubsystem.goToIntake();
            }
            if (gamepad1.y) {
                pivotSubsystem.goToNode();
            }

            driveSubsystem.updateInputs(straight, strafe, turn);
            driveSubsystem.update();
            pivotSubsystem.updatePivot();
        }
    }
}