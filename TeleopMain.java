package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleopMain", group="Iterative Opmode")
public class TeleopMain extends OpMode
{

    public DcMotor frontLeftW = null;
    public DcMotor frontRightW = null;
    public DcMotor backLeftW = null;
    public DcMotor backRightW = null;
    public DcMotor arm = null;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        frontLeftW = hardwareMap.get(DcMotor.class, "FL");
        frontRightW = hardwareMap.get(DcMotor.class, "FR");
        backLeftW = hardwareMap.get(DcMotor.class, "BL");
        backRightW = hardwareMap.get(DcMotor.class, "BR");
        arm = hardwareMap.get(DcMotor.class, "arm");

        frontLeftW.setDirection(DcMotor.Direction.REVERSE);
        backLeftW.setDirection(DcMotor.Direction.REVERSE);
        frontRightW.setDirection(DcMotor.Direction.FORWARD);
        backRightW.setDirection(DcMotor.Direction.FORWARD);

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
        arm.setPower(gamepad1.left_trigger*0.5);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }

    @Override
    public void stop() {}

}
