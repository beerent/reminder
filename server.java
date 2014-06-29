import java.net.*;

public class server extends Thread{
	private static ServerSocket serverSock;
	private Socket sock;
	private static int count;
	private int myCount;

	/* Accepts no parameters. Sets the sock Socket to null*/
	public server(){
		this.sock = null;
		this.count = 0;
	}

	/* Accepts one parameter. This constructor should only be called from the 
	   server class, once it has established a connection. 

	   Sets sock to the socket established with the client. 
	*/
	public server(Socket sock){
		this.sock = sock;
		this.count++;
		this.myCount = this.count;
	}

	/* here, we are connected to the client, and may begin communication 

       calling this method begins a separate thread. You do not call this method directly
	   using .run(). Instead you call .start() on a server (or and object that extends Thread)
	   and it begins a new thread. You use the .run() method for all of your threads. A thread
	   can do anything you tell it to; they do not all have to do the same thing. 

       Check out the acceptConnections() method to see whats going on
	*/
	public void run(){

	}

	/*  */
	public void runServer(){
		try{
			establishSocket();
			acceptConnections();
		}catch(Exception e){

		}
	}

	private void establishSocket() throws Exception{
		this.serverSock = new ServerSocket(4567);
	}

	/* method accepts no parameters. 
	   this method runs forever. It accepts a connection, creates a new server and runs the .start()
	   method on that object, to run the new thread. 
	 */
	private void acceptConnections() throws Exception{
		Socket sock;
		while (true){
			System.out.println("listening for connection...");
			sock = this.serverSock.accept();
			server serv = new server(sock);
			serv.start();
		}
	}

	public static void main(String [] args){
		server s = new server();
		s.runServer();
	}
}