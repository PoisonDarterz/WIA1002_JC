package T1;

abstract class Vehicle {
    double maxSpeed;
    protected double currentSpeed;
    
    public Vehicle(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    abstract void accelerate();

    double getCurrentSpeed() {
        return currentSpeed;
    }

    double getMaxSpeed() {
        return maxSpeed;
    }

    void pedalToTheMetal() {
        while (currentSpeed < maxSpeed) {
            accelerate();
        }
    }
}
