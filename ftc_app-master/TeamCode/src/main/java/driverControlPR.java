import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 299970 on 2/22/2018.
 */
@TeleOp(name = "Test", group = "anything")
@Disabled
public class driverControlPR extends OpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor rightLift;
    DcMotor leftLift;
    DcMotor rightIntake;
    DcMotor leftIntake;
    Servo colorSensorServo;
    ColorSensor stupidColorSensor;
    float leftY=0;
    float rightY=0;
    float rightX=0;
    float leftX=0;
    float leftFront= 0;
    float leftRear= 0;
    float rightFront=0;
    float rightRear=0;
    float excessLeft=0;
    float excessRight=0;
    int x = 0;
    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        rightLift = hardwareMap.dcMotor.get("rightLift");
        leftLift = hardwareMap.dcMotor.get("leftLift");
        rightIntake = hardwareMap.dcMotor.get("rightIntake");
        leftIntake= hardwareMap.dcMotor.get("leftIntake");
        colorSensorServo = hardwareMap.servo.get("colorSensorServo");
        stupidColorSensor = hardwareMap.colorSensor.get("stupidColorSensor");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        leftIntake.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
  /*if (gamepad1.right_trigger > .3)
        {
            frontLeft.setPower(.75);
            frontRight.setPower(-.75);//rotate clockwise
            backRight.setPower(-.75);
            backLeft.setPower(.75);
        }
        else if (gamepad1.left_trigger > .3)
        {
            frontRight.setPower(.75);//rotate counterclockwise
            frontLeft.setPower(-.75);
            backRight.setPower(.75);
            backLeft.setPower(-.75);
        }
        else if (Math.abs(gamepad1.left_stick_y) > .10)
        {
            frontLeft.setPower(gamepad1.left_stick_y);//joystick up and down
            frontRight.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);
            backRight.setPower(gamepad1.left_stick_y);
        }
        else if (Math.abs(gamepad1.right_stick_x) > .10)
        {
            frontLeft.setPower(-gamepad1.right_stick_x);//joystick left and right
            frontRight.setPower(gamepad1.right_stick_x);
            backLeft.setPower(gamepad1.right_stick_x);
            backRight.setPower(-gamepad1.right_stick_x);
        }
        else
        {
            frontRight.setPower(0);//robot stopped
            frontLeft.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);

        }*/

        leftY = gamepad1.left_stick_y;
        leftX = gamepad1.left_stick_x;
        rightY = gamepad1.right_stick_y;
        rightX = gamepad1.right_stick_x;


        if (leftY > .1 || leftY < -.1 || leftX > .1 || leftX < -.1)
        {
            leftFront = leftY + leftX;
            leftRear = leftY - leftX;
            if (leftFront > leftRear)
            {
                if (leftFront > 1)
                {
                    excessLeft = 1 - leftFront;
                }

            }
            else
            {
                if (leftRear > 1)
                {
                    excessLeft = 1 - leftRear;
                }
            }
            leftFront = leftY + leftX + excessLeft;
            leftRear = leftY - leftX + excessLeft;
            frontRight.setPower(leftFront);
            backRight.setPower(leftRear);
        }
        else
        {
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        if (rightY > .1 || rightY < -.1 || rightX > .1 || rightX < -.1)
        {
            leftFront = rightY - rightX;
            leftRear = rightY + rightX;
            if (rightFront > rightRear)
            {
                if (rightRear > 1)
                {
                    excessRight = 1 - rightFront;
                }
            }
            else
            {
                if (rightRear > 1)
                {
                    excessRight = 1 - rightRear;
                }
            }
            rightFront = rightY - rightX + excessRight;
            rightRear = rightY + rightX + excessRight;
            frontLeft.setPower(rightFront);
            backLeft.setPower(rightRear);

        }
        else
        {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        if (gamepad2.left_stick_y > .10) {
            leftLift.setPower(gamepad2.left_stick_y * 2);//lift down beth's controller left stick y
            rightLift.setPower(gamepad2.left_stick_y * 2);
        }
        if (gamepad2.left_stick_y < -.10) {
            leftLift.setPower(gamepad2.left_stick_y / 4);//lift up beth's controller left stick y
            rightLift.setPower(gamepad2.left_stick_y / 4);
        } else {
            leftLift.setPower(0);
            rightLift.setPower(0);

        }
        if (gamepad2.x)
        {
            rightIntake.setPower(.75);
            leftIntake.setPower(.75);
        }
        else if(gamepad2.y)
        {
            rightIntake.setPower(-.75);
            leftIntake.setPower(-.75);
        }
        else
        {
            rightIntake.setPower(0);
            leftIntake.setPower(0);
        }
        if (gamepad2.right_trigger > .3) {
            colorSensorServo.setPosition(.95);
        } else if (gamepad2.left_trigger > .3) {
            colorSensorServo.setPosition(.25);

        }

    }
}
