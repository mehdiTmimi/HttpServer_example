import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public 	Main() {
		try {
		ServerSocket server=new ServerSocket(3000);
		while(true) {
			// use threads
			Socket canal = server.accept();
			OutputStream outputStream= canal.getOutputStream();
			InputStream inputStream= canal.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String chunk;
			do {
				chunk= reader.readLine();
				System.out.println(chunk);
			}while(!chunk.isEmpty());

			
			outputStream.write("HTTP/1.1 200 OK\r\ncontent-type: text/html\r\n\r\nok".getBytes());
			canal.close();
			
			System.out.println("end of data");
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Main();

	}

}
