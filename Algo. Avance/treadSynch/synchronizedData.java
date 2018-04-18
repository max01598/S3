package treadSynch;

public class synchronizedData {
	private int commonInt = -1;
	private boolean flag = false; 
	 public  synchronized  void setCommonInt( int val )
	 {
		 while ( flag) { 
			 try { wait(); }
			 catch ( InterruptedException e ) {System.out.println( e.toString() );
			 	}
			 }

	 System.out.println( Thread.currentThread().getName() + "  Assigning as "
	+ val );
	 commonInt = val;
	 flag = true;
	 notify();
	 }
	 public synchronized int getCommonInt()
	 {
		 
		 while ( !flag ) { // not the getting thread’s turn
			 try { wait(); }
			 catch ( InterruptedException e ) {
			 System.out.println( e.toString() );
			 }
			 }

	 System.out.println( Thread.currentThread().getName() +
	 " Getting the " + commonInt );
	 //System.out.print( "val = " + commonInt);
	 flag = false;
	 notify(); 
	 return commonInt;
	 }

}
