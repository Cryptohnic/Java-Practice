//(c) A+ Computer Science
//www.apluscompsci.com

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner {

    public static void main(String args[]) throws IOException {
        Scanner s = new Scanner(new File("relatives.dat"));
        Relatives r = new Relatives();
        while (s.hasNextLine()) {
            r.setPersonRelative(s.nextLine());
        }
        out.println(r);
    }
}
