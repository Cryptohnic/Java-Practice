//(c) A+ Computer Science
//www.apluscompsci.com

public class Monster implements Comparable {

    private int myWeight;
    private int myHeight;
    private int myAge;

    //write a default Constructor
    public Monster() {
    }

    //write an initialization constructor with an int parameter ht
    public Monster(int ht) {
        myHeight = ht;
    }

    //write an initialization constructor with int parameters ht and wt
    public Monster(int ht, int wt) {
        myHeight = ht;
        myWeight = wt;
    }

    //write an initialization constructor with int parameters ht, wt, and age
    public Monster(int ht, int wt, int age) {
        myHeight = ht;
        myWeight = wt;
        myAge = age;
    }

    //modifiers - write set methods for height, weight, and age
    public void setHeight(int ht) {
        myHeight = ht;
    }

    public void setWeight(int wt) {
        myWeight = wt;
    }

    public void setAge(int age) {
        myAge = age;
    }

    //accessors - write get methods for height, weight, and age
    public int getHeight() {
        return myHeight;
    }

    public int getWeight() {
        return myWeight;
    }

    public int getAge() {
        return myAge;
    }

    //creates a new copy of this Object
    public Object clone() {
        return new Monster(myHeight, myWeight, myAge);
    }

    public boolean equals(Object obj) {
        return compareTo(obj) == 0;
    }

    public int compareTo(Object obj) {
        Monster rhs = (Monster) obj;
        if (myHeight == rhs.getHeight()) {
            if (myWeight == rhs.getWeight()) {
                return myAge > rhs.getAge() ? 1 : myAge < rhs.getAge() ? -1 : 0;
            }
            return myWeight > rhs.getWeight() ? 1 : -1;
        }
        return myHeight > rhs.getHeight() ? 1 : -1;
    }

    //write a toString() method
    public String toString() {
        return myHeight + " " + myWeight + " " + myAge;
    }
}
