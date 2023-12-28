public class Car{

    private String makeModel;
    private int numDoors;
    private int maxPassengers;

    public Car(){ // for testing
        this("None assigned",4,5);
    }

    // public Car(String makeModel){
    //     this(makeModel,4,5);
    // }

    // public Car(String makeModel,int numDoors){
    //     this(makeModel,numDoors,5);
    // }

    public Car(String makeModel,int numDoors,int maxPassengers){
        this.makeModel=makeModel;
        this.numDoors=numDoors;
        this.maxPassengers=maxPassengers;
    }

    public void setMakeAndModel(String makeModel){
        this.makeModel=makeModel;
    }

    public String getMakeAndModel(){
        return makeModel;
    }
    
    public void setNumberOfDoors(int numDoors){
        this.numDoors=numDoors;
    }

    public int getNumberOfDoors(){
        return numDoors;
    }
    
    public void setMaximumNumberOfPassengers(int maxPassengers){
        this.maxPassengers=maxPassengers;
    }

    public int getMaximumNumberOfPassengers(){
        return maxPassengers;
    }
    
    public String toString(){
        return "Make and Model: "+makeModel+"\nNumber of doors: "+numDoors+"\nMaximum number of passengers: "+maxPassengers;
    }
}