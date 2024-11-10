public class testJni
{
	static
	{
		System.loadLibrary("native");
	}
	public static void main(String args[])
	{
		int a = 10, b = 20;
		System.out.println("Multiplication is "+ new testJni().mul(b,a));
		
	}
	private native int mul(int n1,int n2);
}
