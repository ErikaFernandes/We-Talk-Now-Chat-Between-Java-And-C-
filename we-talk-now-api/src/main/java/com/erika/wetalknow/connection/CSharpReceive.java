package com.erika.wetalknow.connection;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class CSharpReceive implements Runnable  {
	
   public static ServerSocket serverSocket;
   public static Socket workerSocket;
   public static DataInputStream socketInputStream;
   public static String resp, response;
   public static boolean ret = false;
   public static Scanner leitor;
   private static Thread threadOne;
   
	public CSharpReceive(String newRec) {
		response = newRec;
	}
	
	public void StartThread() throws IOException{
		try {
	         
			 serverSocket = new ServerSocket(8081, 4);
			 workerSocket = serverSocket.accept();
			 leitor = new Scanner(workerSocket.getInputStream());
			 threadOne = Thread.currentThread();
				
				   
					new Thread(new CSharpReceive(response)).start();
					
				  
			}catch(IOException e) {
				System.out.println(e);
			}
	}
	
	@SuppressWarnings("static-access")
	public String receiveMsg() throws IOException, InterruptedException   {
		
		if(response==null) {
			StartThread();
		}
		threadOne.sleep(1000);
		
		return response;
	}
	
	@Override
	public void run() {
		try{
			while((resp = leitor.nextLine()) != null){
					response = resp;
					ret = true;
					
					serverSocket.close();
					workerSocket.close();
					
					receiveMsg();
					threadOne.interrupt();
					break;
			}
		}catch(IOException error){
			System.out.println(error);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
}