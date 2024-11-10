public class testJni
{
	static
	{
		System.loadLibrary("native");
	}
	public static void main(String args[])
	{
		int a = 10, b = 20;
		System.out.println("Subtraction is "+ new testJni().sub(b,a));
		
	}
	private native int sub(int n1,int n2);
}
