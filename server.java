import java.net.*;

public class server extends Thread{
	private static ServerSocket serverSock;
	private Socket sock;

	public server(){
		this.sock = null;
	}

	public server(Socket sock){
		this.sock = sock;
	}

	public void run(){
		System.out.println("this is a thread");
	}

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