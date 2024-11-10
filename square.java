public class testJni
{
	static
	{
		System.loadLibrary("native");
	}
	public static void main(String args[])
	{
		int a = 10;		
		System.out.println("Square is : " + new testJNI.sqr(a));
	}
	private native int sqr(int a);
}
