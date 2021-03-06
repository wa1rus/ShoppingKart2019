//this class is for the purposes of testing and debugging

package com.saintsrobotics.shoppingkart.tests;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.input.OI.XboxInput;
import com.github.dozer.output.Motor;
import com.saintsrobotics.shoppingkart.util.AbsoluteEncoder;

public class TestDriveSwerveWheel extends RunEachFrameTask {
	XboxInput xb;
	Motor driver;
	AbsoluteEncoder encoder;

	public TestDriveSwerveWheel(XboxInput xb, Motor driver) {
		this.xb = xb;
		this.driver = driver;
		// this.encoder = encoder;
	}

	@Override
	protected void runEachFrame() {
		double yAxis = -xb.leftStickY();
		this.driver.set(yAxis);
		// SmartDashboard.putNumber("magnitude", value)
	}
}
