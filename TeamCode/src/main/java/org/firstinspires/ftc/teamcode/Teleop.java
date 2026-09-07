package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// Controls: Left Stick Y is forward and backward
// Left stick X, is left and right strafe
// Right stick X is robot rotation
@TeleOp(name = "Main Teleop")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            double straight = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            driveSubsystem.updateInputs(straight, strafe, turn);
            driveSubsystem.update();
        }
    }
}