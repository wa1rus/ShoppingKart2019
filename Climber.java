package com.saintsrobotics.shoppingkart.tests;

import com.github.dozer.coroutine.helpers.RunEachFrameTask;
import com.github.dozer.input.OI.XboxInput;
import com.saintsrobotics.shoppingkart.util.AbsoluteEncoder;
import com.saintsrobotics.shoppingkart.util.MotorRamping;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends RunEachFrameTask {
    private BooleanSupplier trigger;
    private MotorRamping motor;
    private AbsoluteEncoder encoder;
    //in is when not doing anything
    private double in; 
    //out is when fully out
    private double out;
    private boolean isDown = false;

    public Climber(BooleanSupplier trigger, MotorRamping motor, AbsoluteEncoder encoder, double in, double out) {
        this.trigger = trigger;
        this.motor = motor;
        this.encoder = encoder;
        this.xboxInput = xboxInput;
        this.in = in;
        this.out = out;
    }

    @Override
    protected void runEachFrame() {
        wait.until(this.trigger));
        if(isDown){this.motor.set(-1);}
        else(this.motor.set(1))
        wait.until(()->{this.encoder.getRotation() >= this.out || this.encoder.getRotation() <= this.in});
        this.motor.set(0);
        if(this.encoder.getRotation()>= this.out){isDown=true;}
        else if(this.encoder.getRotation() <= this.in){isDown=false;}
    
        this.motor.update();
    }
}