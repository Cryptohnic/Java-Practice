//(c) A+ Computer Science
//www.apluscompsci.com

public interface Linkable<T>
{
   T getValue();
   Linkable<T> getNext();
   void setNext(Linkable<T> next);
   void setValue(T value);
}