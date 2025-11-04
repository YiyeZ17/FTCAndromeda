package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class TestClass extends OpMode {

    private DcMotor leftFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotor rightFrontMotor;
    private DcMotor rightBackMotor;

    private final IMUTest imu = new IMUTest();

    @Override
    public void init() {

        // Initializing DC Motors

        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFront");
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBack");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFront");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBack");

        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Initializing IMU

        imu.init(hardwareMap);

    }

    @Override
    public void loop() {

        double y = -gamepad1.left_stick_y;

        telemetry.addData("y", y);

        leftFrontMotor.setPower(y);
        leftBackMotor.setPower(y);
        rightFrontMotor.setPower(y);
        rightBackMotor.setPower(y);

        telemetry.addData("Heading", imu.getHeading());

    }

}
