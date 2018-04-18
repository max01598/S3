package treadSynch;

public class ThreadPCNonSynch {
	public static void main( String args[] )
	 {
	 synchronizedData d = new synchronizedData();
	 Producer p = new Producer( d );
	 Consumer c = new Consumer( d );
	 p.start();
	 c.start();
	 }

}
