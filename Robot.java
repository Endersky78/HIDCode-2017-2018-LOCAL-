package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Robot extends OpMode {
    public DcMotor frontLeftW;
    public DcMotor frontRightW;
    public DcMotor backLeftW;
    public DcMotor backRightW;

    public void init() {
        frontLeftW = hardwareMap.get(DcMotor.class, "FL");
        frontRightW = hardwareMap.get(DcMotor.class, "FR");
        backLeftW = hardwareMap.get(DcMotor.class, "BL");
        backRightW = hardwareMap.get(DcMotor.class, "BR");

        frontLeftW.setDirection(DcMotor.Direction.FORWARD);
        backLeftW.setDirection(DcMotor.Direction.FORWARD);
        frontRightW.setDirection(DcMotor.Direction.REVERSE);
        backRightW.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop() {}
    public void stop() {}
}
