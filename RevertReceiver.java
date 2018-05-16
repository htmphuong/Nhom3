package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RevertReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket socketReceive = new DatagramSocket(5600);
			System.out.println("Receiver started");
			
			byte[] chuoiNhan= new byte[1024];
			DatagramPacket receiveData=new DatagramPacket(chuoiNhan, chuoiNhan.length);
			socketReceive.receive(receiveData);
			
			byte[] packetNhan = receiveData.getData();
			String chuoi=(new String (packetNhan, packetNhan.length)).trim();
			String chuoiNguoc = new StringBuilder(chuoi).reverse().toString();
			
			byte [] packetCHuoiNguoc = chuoiNguoc.getBytes();
			InetAddress address= receiveData.getAddress();
			int port = receiveData.getPort();
			DatagramPacket sendData = 
			new DatagramPacket(packetCHuoiNguoc,packetCHuoiNguoc.length,address,port);
			socketReceive.send(sendData);
			socketReceive.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
