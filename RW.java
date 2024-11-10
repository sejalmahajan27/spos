
import java.util.Scanner;
import java.util.concurrent.Semaphore;

class RW
{

	public static void main(String[] args) 
	{
		ReaderWriter rw = new ReaderWriter();
		Scanner sc = new Scanner(System.in);
		
		rw.new Reader();
		rw.new Reader();
		rw.new Reader();
		rw.new Writer();
		rw.new Reader();
		rw.new Reader();
		rw.new Writer();
		rw.new Reader();
		rw.new Reader();
		rw.new Writer();
		rw.new Reader();
		rw.new Reader();
		
	}

}
class ReaderWriter
{

	Semaphore readers = new Semaphore(9);
	Semaphore mutex = new Semaphore(1);
	Semaphore writers = new Semaphore(1);

	static int rd = 0;
	static int count = 1;
	static int wr = 0;
	Scanner sc = new Scanner(System.in);

	static String msg = "Hello World!";
	

	class Writer implements Runnable
	{
		Writer()
		{
			Thread t = new Thread(this,"Writer");
			t.start();
		}

		public void run()
		{
			try
			{	

				mutex.acquire();
				writers.acquire();
				if(wr == 0)
				{

					wr++;
					System.out.print("Enter Message to be written : ");
					msg = sc.nextLine();
				}
				
				wr--;
				mutex.release();
				writers.release();
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	class Reader implements Runnable
	{
		int no = count++;

		Reader()
		{
			Thread t = new Thread(this,"Reader");
			t.start();
		}

		public void run()
		{
			try
			{
				mutex.acquire();
				readers.acquire();

				if(wr == 0)
				{
					rd++;
					System.out.println("Reader " + no + " is reading : " + msg);
					Thread.sleep(1000); // Simulating Reading time.
					System.out.println("Reader " + no + " is Done!");
					rd--;
				}

				mutex.release();
				readers.release();
				
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
