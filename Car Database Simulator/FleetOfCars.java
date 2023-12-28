import java.util.List;
import java.util.ArrayList; 

public class FleetOfCars{

    private List<Car> fleetOfCars;
    private int length;

    public FleetOfCars(){
        fleetOfCars=new ArrayList<Car>();
        length=0;
    }

    public void add(Car c){
        fleetOfCars.add(c);
        length++;
    }
    
    public Car get(int i){
        return fleetOfCars.get(i);
    }

    public Car delete(int i){
        length--;
        return fleetOfCars.remove(i);
    }

    public int getSize(){
        return length;
    }

    public FleetOfCars search(String s){
        FleetOfCars fleet=new FleetOfCars();
        for(Car c:fleetOfCars)
            if(c.getMakeAndModel().equals(s))
                fleet.add(c);
        return fleet;
    }

    public String toString(){
        String output="[\n";
        for(Car c:fleetOfCars)
            output+=c.toString()+", \n\n";
        return length!=0 ? output.substring(0,output.length()-4)+"\n]" : "[]";
    }

    public static void main(String[] args){
        FleetOfCars f=new FleetOfCars();
        f.add(new Car());
        System.out.println(f);
        f.add(new GasolineCar("Nissan Altima",4,5,15));
        f.add(new ElectricCar("Porsche Taycan",4,5,120));
        f.add(new GasolineCar("Ford F-150",4,5,20));
        f.add(new GasolineCar("Lamborghini Huracan",2,2,12));
        System.out.println(f);
        f.delete(1);
        System.out.println(f);
        f.delete(0);
        System.out.println(f);
        f.delete(f.getSize()-1);
        System.out.println(f);
    }
}