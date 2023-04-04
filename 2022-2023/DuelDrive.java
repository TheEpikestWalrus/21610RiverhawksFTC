package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name="Drive", group="Main")

public class DuelDrive extends LinearOpMode {
     
        public DcMotor fl = null ;
        public DcMotor fr = null;
        public DcMotor bl = null;
        public DcMotor br = null;
        public DcMotor lift = null;
        public Servo claw = null;
        double x = 1.0;
        double servoPos = 0.2;

  @Override 
  public void runOpMode() {

        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        lift = hardwareMap.get(DcMotor.class, "lift");

//⚠Uncomment me for claw controlls
        claw = hardwareMap.get(Servo.class, "claw");
        
        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction.REVERSE);

        // Initialization positions
        
//⚠Uncomment me for claw controlls
        claw.setPosition(0.2);

        waitForStart();
        while (opModeIsActive()) {
           
          
           ///////MOVEMENT//////
        
            if (gamepad1.y) {
                x = 1;
            }
            else if (gamepad1.a) {
                x = .5;
            }
            else if (gamepad1.b) {
                x = 0.75;
            }
            else if (gamepad1.x) {
                x = .25;
            }
            
            if(gamepad1.dpad_down){ //MOVE BACKWARD
                    fl.setPower(x);
                    fr.setPower(x);
                    bl.setPower(x);
                    br.setPower(x);  
            }
            else if(gamepad1.dpad_up){ //MOVE FORWARD
                fl.setPower(-x);
                fr.setPower(-x);
                bl.setPower(-x);
                br.setPower(-x);  
            }
            else if(gamepad1.dpad_right){ //MOVE RIGHT
                fl.setPower(-x);
                fr.setPower(x);
                bl.setPower(x);
                br.setPower(-x);  
            }
            else if(gamepad1.dpad_left){ //MOVE LEFT 
                fl.setPower(x);
                fr.setPower(-x);
                bl.setPower(-x);
                br.setPower(x);
            }
            else if(gamepad1.dpad_left && gamepad1.dpad_up){ //MOVE DIAGONAL FORWARD LEFT 
                fl.setPower(x);
                fr.setPower(0);
                bl.setPower(x);
                br.setPower(0);
            }
            else if(gamepad1.dpad_right && gamepad1.dpad_up){ //MOVE DIAGONAL FORWARD RIGHT 
                fl.setPower(0);
                fr.setPower(x);
                bl.setPower(0);
                br.setPower(x);
            }
            else if(gamepad1.dpad_left && gamepad1.dpad_down){ //MOVE DIAGONAL BACKWARDS LEFT 
                fl.setPower(-x);
                fr.setPower(0);
                bl.setPower(-x);
                br.setPower(0);
            }
            else if(gamepad1.dpad_right && gamepad1.dpad_down){ //MOVE DIAGONAL BACKWARDS RIGHT 
                fl.setPower(0);
                fr.setPower(-x);
                bl.setPower(0);
                br.setPower(-x);
            }
            else if(gamepad1.left_bumper){ //SPIN LEFT 
                fl.setPower(-x);
                fr.setPower(x);
                bl.setPower(-x);
                br.setPower(x);
            }
            else if(gamepad1.right_bumper){ //SPIN RIGHT 
                fl.setPower(x);
                fr.setPower(-x);
                bl.setPower(x);
                br.setPower(-x);
            }
            else{ //STOP 
                fl.setPower(0);
                fr.setPower(0);
                bl.setPower(0);
                br.setPower(0);
            }
            
            //////////////////////////// Gunner Controls ////////////////////////////
        
            if(gamepad2.dpad_up) {           //When gamepad 2 dpad is pressed up, lift up
               lift.setPower(-0.5);
            } else if(gamepad2.dpad_down){   // when pressed down, lift down
               lift.setPower(0.5);
            } else {                         // otherwise, don't move plz
               lift.setPower(0);
            }
           
//⚠Uncomment me for claw controlls

            if(gamepad2.x){                // x opens claw
              servoPos = servoPos + 0.001;
              claw.setPosition(servoPos);
            }
            
            if(gamepad2.b){                // b closes claw
              servoPos = servoPos - 0.001;
              claw.setPosition(servoPos);
            }

        }
    }
}
       
