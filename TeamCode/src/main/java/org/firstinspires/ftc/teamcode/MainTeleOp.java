package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() {
        // --- INIT ---
        Intake intake = new Intake(hardwareMap);
        boolean lastAState = false;

        waitForStart();

        // --- MAIN LOOP ---
        while (opModeIsActive()) {

            // ... your drivetrain code here ...

            // Intake logic
            boolean aPressed = gamepad1.a;

            if (aPressed) {
                intake.spinForward();
            } else if (gamepad1.b) {
                intake.spinReverse();
            } else if (!intake.isAutoIntakeEnabled()) {
                intake.stop();
            }

            if (gamepad1.right_bumper && !lastAState) {
                intake.setAutoIntakeEnabled(true);
            }
            lastAState = gamepad1.right_bumper;

            intake.updateAutoIntake();

            telemetry.addData("Beam Break", intake.isGamePieceDetected() ? "BLOCKED" : "clear");
            telemetry.update();
        }
    }
}