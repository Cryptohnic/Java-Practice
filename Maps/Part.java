//(c) A+ Computer Science
//www.apluscompsci.com

public class Part implements Comparable<Part> {

    private String make, model, rest;
    private int year;

    public Part(String line) {
        String[] list = line.split(" ");
        make = list[list.length - 3];
        model = list[list.length - 2];
        year = Integer.parseInt(list[list.length - 1]);
        rest = list.length == 6 ? list[0] + " " + list[1] + " " + list[2] : list[0] + " " + list[1];  // set based on one or two words
    }

    // have to have compareTo if implements Comparable
    public int compareTo(Part rhs) {
        if (make.equals(rhs.make)) {
            if (model.equals(rhs.model)) {
                if (year == rhs.year) {
                    return rest.compareTo(rhs.rest);
                }
                return year > rhs.year ? 1 : -1;
            }
            return model.compareTo(rhs.model);
        }
        return make.compareTo(rhs.make);
    }

    public String toString() {
        return make + " " + model + " " + year + "  " + rest;
    }
}
