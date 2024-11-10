public class testJni
{
	static
	{
		System.loadLibrary("native");
	}
	public static void main(String args[])
	{
		int a = 10, b = 20;
		System.out.println("Addition is "+ new testJni().add(a,b));
		
	}
	private native int add(int n1,int n2);
}
