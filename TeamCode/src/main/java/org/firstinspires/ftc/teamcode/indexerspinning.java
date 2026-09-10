package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class indexerspinning {
    DcMotor indexer;
    public indexerspinning(HardwareMap hmap) {
        indexer = hmap.get(DcMotor.class, "indexer");
        indexer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        indexer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void indexerspin0() {
        indexer.setPower(0);
    }

    public void indexerspin1() {
        indexer.setPower(1);
    }
}
