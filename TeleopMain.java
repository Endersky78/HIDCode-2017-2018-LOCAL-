package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleopMain", group="Iterative Opmode")
public class TeleopMain extends OpMode
{

    public DcMotor frontLeftW = null;
    public DcMotor frontRightW = null;
    public DcMotor backLeftW = null;
    public DcMotor backRightW = null;
    public DcMotor arm = null;
    public CRServo wristL = null;
    public CRServo wristR = null;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        frontLeftW = hardwareMap.get(DcMotor.class, "FL");
        frontRightW = hardwareMap.get(DcMotor.class, "FR");
        backLeftW = hardwareMap.get(DcMotor.class, "BL");
        backRightW = hardwareMap.get(DcMotor.class, "BR");
        arm = hardwareMap.get(DcMotor.class, "arm");
        wristL = hardwareMap.get(CRServo.class, "WL");
        wristR = hardwareMap.get(CRServo.class, "WR");

        frontLeftW.setDirection(DcMotor.Direction.REVERSE);
        backLeftW.setDirection(DcMotor.Direction.REVERSE);
        frontRightW.setDirection(DcMotor.Direction.FORWARD);
        backRightW.setDirection(DcMotor.Direction.FORWARD);
        wristL.setDirection(DcMotor.Direction.FORWARD);
        wristR.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {runtime.reset();}

    @Override
    public void loop() {
        double leftPower;
        double rightPower;

        leftPower  = -gamepad1.left_stick_y ;
        rightPower = -gamepad1.right_stick_y ;

        frontLeftW.setPower(leftPower*0.75);
        backLeftW.setPower(leftPower*0.75);
        frontRightW.setPower(rightPower*0.75);
        backRightW.setPower(rightPower*0.75);
        if(gamepad1.left_trigger > 0) {
            arm.setPower(-gamepad1.left_trigger*0.25);
        }

        else if(gamepad1.right_trigger > 0) {
            arm.setPower(gamepad1.right_trigger*0.25);
        }

        else if(gamepad1.a) {
            wristL.setPower(0.5);
            wristR.setPower(0.5);
        }

        else if(gamepad1.y) {
            wristL.setPower(-0.5);
            wristR.setPower(-0.5);
        }

        else {
            wristL.setPower(0);
            wristR.setPower(0);
            arm.setPower(-0.05);
        }

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }

    @Override
    public void stop() {}

}
