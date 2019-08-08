public class ThreadRunnableOne implements Runnable{
    public int myCount = 4;
 
    /*public MyRunnableThread(){
         
    }*/
    //step 2
    public ThreadRunnableOne()
	{
		System.out.println("This is ThreadRunnableOne 4 Constructor");
	}
	
    public void run() {
        while((myCount%4==0)&&(myCount<=40)){
            try{
                System.out.println("Runnable Thread: "+myCount);
                myCount+=4;
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
        System.out.println("End of runnable Thread...\n");
    }
    
    public static void main(String a[]) {
    	int i = 3;
    	
        System.out.println("Starting Main Thread...");
        
        //step 3
        ThreadRunnableOne mrt = new ThreadRunnableOne();
        
        //step 4
        Thread t = new Thread(mrt);
       
        MySmpThreads msts= new MySmpThreads();
        
        //step 5
       
        while( ((i%3) == 0)&&(i<=30)){
            try{
                System.out.println("Main Thread: "+i);
                i+=3;
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...\n");
        
//       System.out.println(t.isAlive());
        t.start();
     
//System.out.println(t.isAlive());

        try {
			Thread.sleep(1500);
			msts.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
class MySmpThreads extends Thread{//step 1
	//Thread class is in java.lang package

	public MySmpThreads()
	{
		System.out.println("This is MySmpThread() 5 Constructor");
	}
	
     int i = 5;
    
    //step 2
    public void run(){
    	System.out.println("start of thread extends");//public void run() need to be overridden to run in a separate thread
        while( (i%5==0) && (i<=50) ){
          try{
                System.out.println("Extended Thread from Thread: "+i);
                i+=5;
                Thread.sleep(100); //in milliseconds
            } catch (InterruptedException iex) {//checked exception
                System.out.println("Exception in thread: "+iex.getMessage());
                break;
            }
        }
        System.out.println("End of thread extends\n");
    }
}
