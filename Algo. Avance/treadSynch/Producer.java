package treadSynch;

public class Producer extends Thread {
	 private synchronizedData pHold;
	 public Producer( synchronizedData h )
	 {
	 super( "Producer" );
	 pHold = h;
	 }
	 public void run()
	 {
	 for ( int count = 1; count <= 10; count++ ) {
	 // sleep for a random interval
	 try {
	 Thread.sleep( (int) ( Math.random() * 3000 ) );
	 }
	 catch( InterruptedException e ) {
	 System.out.println( e.toString() );
	 }
	 pHold.setCommonInt( count );
	 }
	 System.out.println( "Thread " + Thread.currentThread().getName() + " Finished Putting values");
	 }
}
