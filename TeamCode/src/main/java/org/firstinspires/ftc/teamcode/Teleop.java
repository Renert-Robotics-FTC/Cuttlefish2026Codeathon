package org.firstinspires.ftc.teamcode;
//imports
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Main Teleop")
public class Teleop extends LinearOpMode {

boolean indexing = false;
    @Override
    public void runOpMode(){
        //create subsystem objects here
        indexerspinning indexer = new indexerspinning(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            gamepad1.a = indexing;
            if (indexing){
                indexer.indexerspin1();


            } else{
                indexer.indexerspin0();
            }


        }

    }


}
