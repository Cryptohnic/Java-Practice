public class GasolineCar extends Car{

    private double gasTankSize;

    // public GasolineCar(){
    //     super("None assigned",4,5);
    //     gasTankSize=-1;
    // }
    
    // public GasolineCar(String makeModel){
    //     super(makeModel,4,5);
    //     gasTankSize=-1;
    // }

    // public GasolineCar(String makeModel,int numDoors){
    //     super(makeModel,numDoors,5);
    //     gasTankSize=-1;
    // }

    // public GasolineCar(String makeModel,int numDoors,int maxPassengers){
    //     super(makeModel,numDoors,maxPassengers);
    //     gasTankSize=-1;
    // }

    public GasolineCar(String makeAndModel,int numDoors,int maxPassengers,double gasTankSize){
        super(makeAndModel,numDoors,maxPassengers);
        this.gasTankSize=gasTankSize;
    }

    public void setGasTankSize(double gasTankSize){
        this.gasTankSize=gasTankSize;
    }

    public double getGasTankSize(){
        return gasTankSize;
    }
    
    public String toString(){
        return super.toString()+"\nGas tank size: "+gasTankSize;
    }
}