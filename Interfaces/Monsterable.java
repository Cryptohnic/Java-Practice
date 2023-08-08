//(c) A+ Computer Science
//www.apluscompsci.com

public interface Monsterable{
	public int getHowBig();
	public String getName();
	public boolean isBigger(Monsterable other);	
	public boolean isSmaller(Monsterable other);
	public boolean namesTheSame(Monsterable other);
}