package application;

import java.net.*;
import java.io.*;

public class MulticastPeer {
	@SuppressWarnings("deprecation")
	public static void conectarMulticastPeer(String msg, String ip) throws IOException {
		
		// args  provê o conteúdo da mensagem e o endereço  do grupo multicast (p. ex. "228.5.6.7")
		
		MulticastSocket mSocket = null;
		InetAddress groupIp = null;
		
		try {
			groupIp = InetAddress.getByName(ip);
			
			mSocket = new MulticastSocket(6789);
			mSocket.joinGroup(groupIp);
			
			byte[] message = msg.getBytes();
			DatagramPacket messageOut = new DatagramPacket(message, message.length, groupIp, 6789);
			mSocket.send(messageOut);
			byte[] buffer = new byte[1000];
			while(true) { // get messages from others in group
				DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
				mSocket.receive(messageIn);
				String data = new String(messageIn.getData()).trim();
				TelaChatController.getMsgRecebidas(data);
				System.out.println("Recebido:" + new String(messageIn.getData()).trim());
			}
			
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			mSocket.leaveGroup(groupIp);
			if (mSocket != null)
				mSocket.close();
		}
	}

}
