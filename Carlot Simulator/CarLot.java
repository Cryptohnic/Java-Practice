import java.util.List;
import java.util.ArrayList;

public class CarLot{

    Queue<Car> gasCars;
    Queue<Car> hybridCars;
    Queue<Car> electricCars;    

    public CarLot(){
        gasCars=new Queue<>();
        hybridCars=new Queue<>();
        electricCars=new Queue<>();
    }

    public boolean addCar(Car c){
        switch(c.getPowerSource()){
            case 1:
                gasCars.enqueue(c);
                return true;
            case 2:
                hybridCars.enqueue(c);
                return true;
            case 3:
                electricCars.enqueue(c);
                return true;
            default:
                return false;
        }
    }

    public List<Car> processRequests(CarRequests requests){
        List<Car> cars=new ArrayList<>();
        while(requests.hasPendingRequests()){
            int request=requests.getRequest();
            switch(request){
                case 1:
                    if(!gasCars.isEmpty())
                        cars.add(gasCars.dequeue());
                    else
                        cars.add(new Car(0,0,0)); // add a dummy car
                    continue;
                case 2:
                    if(!hybridCars.isEmpty())
                        cars.add(hybridCars.dequeue());
                    else
                        cars.add(new Car(0,0,0));
                    continue;
                case 3: 
                    if(!electricCars.isEmpty())
                        cars.add(electricCars.dequeue());
                    else
                        cars.add(new Car(0,0,0));
            }
        }
        return cars;
    }

    public String toString(){
        return "Gasoline cars:\n"+gasCars.toString()+"\nHybrid cars:\n"+hybridCars.toString()+"\nElectric cars:\n"+electricCars.toString();
    }

    public static void main(String[] args) {
        CarLot lot=new CarLot();
        lot.addCar(new Car(1,1,100));
        lot.addCar(new Car(2,2,200));
        lot.addCar(new Car(3,3,300));
        lot.addCar(new Car(4,1,400));
        lot.addCar(new Car(5,2,500));
        lot.addCar(new Car(6,3,600));
        System.out.println(lot);
        CarRequests requests=new CarRequests();
        requests.addRequest(1);
        requests.addRequest(2);
        requests.addRequest(3);
        requests.addRequest(1);
        System.out.println(lot.processRequests(requests).toString().replace("[", "[\n").replaceAll(", ",",\n").replace("]", "\n]"));
    }
}
