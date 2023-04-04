package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="SimpleAuto", group="Robot")

public class SimpleAuto extends LinearOpMode {

    /* Declare OpMode members. */
    public DcMotor fl = null ;
    public DcMotor fr = null;
    public DcMotor bl = null;
    public DcMotor br = null;
    
    private ElapsedTime     runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        // Initialize the drive system variables.
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        
        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.REVERSE);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 1.5 seconds
        fl.setPower(-0.5);
        fr.setPower(-0.5);
        bl.setPower(-0.5);
        br.setPower(-0.5);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elpsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Back off from cone
        fl.setPower(0.5);
        fr.setPower(0.5);
        bl.setPower(0.5);
        br.setPower(0.5);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.25)) {
            telemetry.addData("Path", "Leg 1: %4.1f S Elpsed", runtime.seconds());
            telemetry.update();
        }
        
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}

 
