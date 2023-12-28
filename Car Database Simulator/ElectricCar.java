public class ElectricCar extends Car{

    private double batterySize;

    // public ElectricCar(){
    //     super("None assigned",4,5);
    //     batterySize=-1;
    // }

    // public ElectricCar(String makeModel){
    //     super(makeModel,4,5);
    //     batterySize=-1;
    // }

    // public ElectricCar(String makeModel,int numDoors){
    //     super(makeModel,numDoors,5);
    //     batterySize=-1;
    // }

    // public ElectricCar(String makeModel,int numDoors,int maxPassengers){
    //     super(makeModel,numDoors,maxPassengers);
    //     batterySize=-1;
    // }

    public ElectricCar(String makeAndModel,int numDoors,int maxPassengers,double batterySize){
        super(makeAndModel,numDoors,maxPassengers);
        this.batterySize=batterySize;
    }

    public void setBatterySize(double batterySize){
        this.batterySize=batterySize;    
    }

    public double getBatterySize(){
        return batterySize;
    }
    
    public String toString(){
        return super.toString()+"\nBattery size: "+batterySize;
    }
}