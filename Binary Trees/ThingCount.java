//(c) A+ Computer Science
//www.apluscompsci.com

public class ThingCount implements Comparable {

    private int count;
    private Object thing;

    public ThingCount() {
        count = 0;
        thing = null;
    }

    public ThingCount(Object thang, int cnt) {
        thing = thang;
        count = cnt;
    }

    public void setThing(Object obj) {
        thing = obj;
    }

    public void setCount(int cnt) {
        count = cnt;
    }

    public Object getThing() {
        return thing;
    }

    public int getCount() {
        return count;
    }

    public boolean equals(Object obj) {
        ThingCount other = (ThingCount) obj;
        return other != null ? thing.equals(other.getThing()) && count == other.getCount() : false;
    }

    public int compareTo(Object obj) {
        ThingCount other = (ThingCount) obj;
        return other != null ? ((Comparable) thing).compareTo(other.getThing()) : -1;
    }

    public String toString() {
        return "" + thing + " - " + count;
    }
}
