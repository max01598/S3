package treadSynch;

public class Consumer extends Thread {
	 private synchronizedData cHold;
	 public Consumer( synchronizedData h )
	 {
	 super( "Consumer" );
	 cHold = h;
	 }
	 public void run()
	 {
	 int val, sum = 0;
	 do {
	 // sleep for a random interval
	 try {
	 Thread.sleep( (int) ( Math.random() * 3000 ) );
	 }
	 catch( InterruptedException e ) {
	 System.out.println( e.toString() );
	 }
	 val = cHold.getCommonInt();
	 sum += val;
	 } while ( val != 10 );
	 System.out.println("Thread "+ Thread.currentThread().getName()+" Finished Getting values");
	 }

}
