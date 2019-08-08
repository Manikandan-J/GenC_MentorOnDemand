class MySmpThread extends Thread{//step 1
	//Thread class is in java.lang package

	public MySmpThread()
	{
		System.out.println("This is MySmpThread() Constructor");
	}
	
     static int i = 31;
    
    //step 2
    public void run(){//public void run() need to be overridden to run in a separate thread
        while(MySmpThread.i <= 60){
          try{
            	
                System.out.println("Other Thread: "+MySmpThread.i);
                i=i+1;
                Thread.sleep(100); //in milliseconds
            } catch (InterruptedException iex) {//checked exception
                System.out.println("Exception in thread: "+iex.getMessage());
                break;
            }
        }
    }
}

public class SomeThread {
	static int i = 1;
    public static void main(String a[]){
    	//main thread starts by default
        System.out.println("Starting Main Thread...");
        
        //step 3
        MySmpThread mst = new MySmpThread();
        
        //from this main thread, start MySmpThread thread, by invoking start()
        
        
        while(SomeThread.i <=30){
            try{
                System.out.println("Main Thread: "+SomeThread.i);
                SomeThread.i=SomeThread.i+1;
                Thread.sleep(100);//delays program execution by 100ms
            } catch (Exception iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
                break;
            }
        }
     
        
        System.out.println("End of Main Thread...");
        //step 4
        mst.start();
    }
}