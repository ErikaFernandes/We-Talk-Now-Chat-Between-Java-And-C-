package com.erika.wetalknow.connection;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CSharpSend {

	protected DatagramSocket socket = null;
	
	public void sendMsg(String msg) {
		try {
			socket = new DatagramSocket();
			byte[] buf = new byte[256];

			InetAddress address = InetAddress.getByName("127.0.0.1");
			buf = msg.getBytes();
			DatagramPacket packet = new DatagramPacket(buf,buf.length, address, 8888);
			socket.send(packet);
		}catch (IOException e) {
			System.out.println(e);

		}finally {
			socket.close();
		}

	}
}
