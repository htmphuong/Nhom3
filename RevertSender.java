package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RevertSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket socketSender = new DatagramSocket();
			System.out.println("Sender connected");
			
			String chuoi ="hello";
			byte [] packetChuoi=chuoi.getBytes();
			int length =packetChuoi.length;
			InetAddress address = InetAddress.getByName("localhost");
			int port = 5600;
						
			DatagramPacket sendPacket = new DatagramPacket(packetChuoi, length, address, port);
			socketSender.send(sendPacket);
			
			byte[] nhan= new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(nhan, nhan.length);
			socketSender.receive(receivePacket);
			byte [] chuoiNhan = receivePacket.getData();
			String chuoiNguoc = (new String (chuoiNhan, chuoiNhan.length)).trim();
			System.out.println("Nhan la"+chuoiNguoc);
			socketSender.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
