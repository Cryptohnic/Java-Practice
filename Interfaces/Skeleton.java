//(c) A+ Computer Science
//www.apluscompsci.com

import static java.lang.System.*;

public class Skeleton implements Monsterable {
    //add instance variables	

    private String name;
    private int size;
    //add a constructor

    public Skeleton() {
    }

    public Skeleton(String n) {
        name = n;
    }

    public Skeleton(int s) {
        size = s;
    }

    public Skeleton(String n, int s) {
        name = n;
        size = s;
    }
    //add code to implement the Monster interface

    public boolean isBigger(Monsterable mon) {
        return size > mon.getHowBig();
    }

    public boolean namesTheSame(Monsterable mon) {
        return name.equals(mon.getName());
    }

    public boolean isSmaller(Monsterable mon) {
        return size < mon.getHowBig();
    }

    public int getHowBig() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + size;
    }
}
