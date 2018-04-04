import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 299970 on 2/23/2018.
 */
@TeleOp (name = "PRdrive")
@Disabled
public class PRdrive  extends OpMode
{
   DcMotor frontRight;
   DcMotor frontLeft;
   DcMotor backLeft;
   DcMotor backRight;
   DcMotor rightIntake;
   DcMotor leftIntake;
   DcMotor leftLift;
   DcMotor rightLift;
   Servo colorSensorServo;
   ColorSensor stupidColorSensor;
    @Override
    public void init() {
       frontLeft=hardwareMap.dcMotor.get("frontLeft");
       frontRight=hardwareMap.dcMotor.get("frontRight");
       backLeft=hardwareMap.dcMotor.get("backLeft");
       backRight=hardwareMap.dcMotor.get("backRight");
       rightIntake=hardwareMap.dcMotor.get("rightIntake");
       leftIntake=hardwareMap.dcMotor.get("leftIntake");
       leftLift=hardwareMap.dcMotor.get("leftLift");
       rightLift=hardwareMap.dcMotor.get("rightLift");
       colorSensorServo=hardwareMap.servo.get("colorSensorServo");
       stupidColorSensor=hardwareMap.colorSensor.get("stupidColorSensor");


    }

    @Override
    public void loop() {
     {
         frontLeft.setPower(1);
         frontRight.setPower(1);
         backRight.setPower(1);
         backLeft.setPower(1);
     }
    }
}
