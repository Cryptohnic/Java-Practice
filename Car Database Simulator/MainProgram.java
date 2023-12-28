import java.util.Scanner;
import java.io.IOException;

public class MainProgram{
    public static void main(String[] args) throws IOException{
        FleetOfCars fleet=new FleetOfCars(); // instantiate our list
        Scanner s=new Scanner(System.in); // create Scanner to get user input
        while(true){
            System.out.print("\nEnter option from the list below:\n\t1) Display complete directory\n\t2) Enter new Car\n\t3) Search for Car\n\t4) Modify Car information\n\t5) Delete a record\n\tQ) Quit\nEnter your option: ");
            String input=s.next();
            System.out.println(); // formatting
            s.nextLine(); // have to do this to reset the Scanner
            if(input.toLowerCase().equals("q"))
                break;
            switch(input){
                case "1": // print out the directory
                    System.out.println(fleet);
                    continue;
                case "2": // add a car
                    System.out.print("What is the name of the make and model you would like to add?: ");
                    String makeAndModel=s.nextLine();
                    System.out.print("\nHow many doors the car you are adding have?: ");
                    int numDoors=s.nextInt();
                    System.out.print("\nHow many passengers can fit inside this car?: ");
                    int numPassengers=s.nextInt();
                    fleet.add(new Car(makeAndModel,numDoors,numPassengers));
                    continue;
                case "3": // find all cars of same make and model
                    System.out.print("Which make and model would you like to search for to see all matches in our fleet?: ");
                    input=s.nextLine();
                    System.out.println("\n"+fleet.search(input));
                    continue;
                case "4": // update cars of same make and model
                    System.out.print("Which make and model would you like to search for to see all matches in our fleet that you wish to change?: ");
                    String changeMakeAndModel=s.nextLine();
                    FleetOfCars toChange=fleet.search(changeMakeAndModel);
                    int numOfChangeable=toChange.getSize();
                    if(numOfChangeable==0)
                        continue;
                    System.out.print("\n"+toChange+"\n\nOf the "+numOfChangeable+" cars, how many would you like to change?: ");
                    int wantedNum=s.nextInt();
                    if(wantedNum>numOfChangeable)
                        throw new Error("You cannot change more cars than the number that exist in the outputted list above.");
                    for(int count=0;count<wantedNum;count++){ // loop through list of matches
                        toChange=fleet.search(changeMakeAndModel);
                        System.out.print("\n"+toChange+"\n\nOf the cars shown above, which car would you like to modify first? Cars are ordered (1,2,3...): ");
                        int carIndex=s.nextInt()-1;
                        Car currentCar=toChange.get(carIndex);
                        System.out.print("\nWould you like to change the make and model from "+currentCar.getMakeAndModel()+" to something else? (y or n): ");
                        input=s.next().toLowerCase();
                        if(input.equals("y")){
                            System.out.print("\nWhat would you like to change the make and model to?: ");
                            s.nextLine();
                            makeAndModel=s.nextLine();
                            currentCar.setMakeAndModel(makeAndModel);
                        }
                        System.out.print("\nWould you like to change the number of doors from "+currentCar.getNumberOfDoors()+" to something else? (y or n): ");
                        input=s.next().toLowerCase();
                        if(input.equals("y")){
                            System.out.print("\nWhat would you like to change the number of doors to?: ");
                            currentCar.setNumberOfDoors(s.nextInt());
                        }
                        System.out.print("\nWould you like to change maximum number of passengers from "+currentCar.getMaximumNumberOfPassengers()+" to something else? (y or n): ");
                        input=s.next().toLowerCase();
                        if(input.equals("y")){
                            System.out.print("\nWhat would you like to change the maximum number of passengers to?: ");
                            currentCar.setMaximumNumberOfPassengers(s.nextInt());
                        }
                    }
                    continue;
                case "5": // delete a car with confirmation
                    System.out.print("What is the index of the record you would like to delete?: ");
                    int index=s.nextInt();
                    if(index<0 || index>=fleet.getSize()){
                        System.out.println("\n"+fleet);
                        continue;
                    }
                    System.out.println("\n"+fleet.get(index));
                    System.out.print("\nAre you sure you want to delete the car show above? (y or n): ");
                    input=s.next().toLowerCase();
                    if(input.equals("y"))
                        fleet.delete(index);
            }
        }
    }
}