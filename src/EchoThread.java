import java.io.*;
import java.net.Socket;

/**
 * 
 * @author Tanner Howell
 * @author Brian Wilder
 * 
 * This is a thread that runs the actual print and write buffers for each
 * +client and server
 *
 */
public class EchoThread extends Thread {
	protected Socket socket;
	private int playerNo;
	private BufferedReader in;
	private PrintWriter out;

	public EchoThread(Socket clientSocket, int passedNo) {
		this.socket = clientSocket;
		this.playerNo = passedNo;
		this.in = null;
		this.out = null;
	}

	//TODO: Needs to know which player it is
	public void run(int playerNo) {
		//BufferedReader in = null;
		//PrintWriter out = null;
		String line;
		try {
			// Buffer for reading in
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

			//Buffer for writing
			out = new PrintWriter(this.socket.getOutputStream(), true);

		} catch (IOException e) {
			return;
		}

		while (true) {
			try {

				if(in.ready() == true){
					String pack = receivePacket();
				}
				/*line = in.readLine();
                if ((line == null) || line.equalsIgnoreCase("TERM")) {
                    socket.close();
                    return;
                }*/

			} catch (IOException e) {
				System.out.println(e);
				return;
			}
		}
	}

	/**
	 * A function that sends a packet over the printbuffer
	 * @param myPacket - the packet to be send
	 */
	public void sendPacket(String myPacket){
		boolean errInWrite = true;
		while(errInWrite == true)
		{
			try{
				out.flush();
				//TODO: Notify the client might not be needed, check into this
				out.notify();    //Might not be needed 
				out.println(myPacket);
				errInWrite = out.checkError();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		return;
	}

	/**
	 * 
	 * @return
	 */
	public String receivePacket(){
		String rcvPack = "";
		while(rcvPack.equals(null)){
			try {
				rcvPack = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rcvPack;
	}
}