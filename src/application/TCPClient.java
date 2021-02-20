package application;

import java.net.*;
import java.io.*;

public class TCPClient {
	public static String conectarClient(String msg,String host, int porta) {
		// arguments supply message and hostname
		Socket s = null;
		String data = null;
		try {
			int serverPort = porta;
			s = new Socket(host, serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(msg);
			data = in.readUTF(); // ê uma linha do fluxo de dados
			System.out.println("Recebido: " + data);
		} catch (UnknownHostException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline:" + e.getMessage());
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}
		}

		return data;
	}
}
