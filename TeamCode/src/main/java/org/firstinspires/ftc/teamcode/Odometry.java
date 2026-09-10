package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//tracks field pos (x,y) and heading of robot (hopefully)

public class Odometry {

    GoBildaPinpointDriver odometry;

    public Odometry(HardwareMap hardwareMap) {
       //get odometry sensor
        odometry = hardwareMap.get(
                GoBildaPinpointDriver.class,
                "odometry");
        //set where odometry pods are
        odometry.setOffsets(-120.0, -30.0, DistanceUnit.MM);
        odometry.setEncoderResolution(
                //set type of odometry pods
                GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
       //reset the starting position
        odometry.resetPosAndIMU();
    }
    //update odometry readings
    public void update() {
        odometry.update();
    }
    //get robots current x axis pos (millimetres)
    public double getXPosition() {
        return odometry.getPosX(DistanceUnit.MM);}
    //get robots current y position from odo sensor (millimetres)
    public double getYPosition() {
        return odometry.getPosY(DistanceUnit.MM);}

    //get the robots current heading in degrees relative to start direction
    public double Heading() {
        return odometry.getHeading(AngleUnit.DEGREES);}
}
//put in teleop code