//(c) A+ Computer Science
//www.apluscompsci.com

public interface Linkable
{
   Comparable getValue();
   Linkable getNext();
   void setNext(Linkable next);
   void setValue(Comparable value);
}