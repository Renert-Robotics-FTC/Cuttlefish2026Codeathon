package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotor intakeMotor;
    private DigitalChannel beamBreak;

    // Automation state
    private boolean autoIntakeEnabled = false;
    private boolean gamePieceDetected = false;

    public Intake(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        beamBreak = hardwareMap.get(DigitalChannel.class, "beamBreak");
        beamBreak.setMode(DigitalChannel.Mode.INPUT);
    }

    // --- Tier 1: basic spin ---
    public void spinForward() {
        intakeMotor.setPower(1.0);
    }

    public void spinReverse() {
        intakeMotor.setPower(-1.0);
    }

    public void stop() {
        intakeMotor.setPower(0.0);
    }

    // --- Beam break helper ---
    // Most beam breaks read LOW (false) when the beam IS broken (object present).
    // Flip this if yours reads the opposite way.
    public boolean isGamePieceDetected() {
        gamePieceDetected = !beamBreak.getState();
        return gamePieceDetected;
    }

    // --- Tier 3: automation toggle ---
    public void setAutoIntakeEnabled(boolean enabled) {
        autoIntakeEnabled = enabled;
    }

    public boolean isAutoIntakeEnabled() {
        return autoIntakeEnabled;
    }

    // Call this every loop when auto mode is on.
    // Runs intake until a game piece breaks the beam, then stops automatically.
    public void updateAutoIntake() {
        if (!autoIntakeEnabled) return;

        if (isGamePieceDetected()) {
            stop();
            autoIntakeEnabled = false; // done — piece is in
        } else {
            spinForward();
        }
    }
}