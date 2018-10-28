package com.erika.wetalknow.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erika.wetalknow.connection.CSharpReceive;
import com.erika.wetalknow.connection.CSharpSend;
import com.erika.wetalknow.repository.Messages;



@Service
public class MessageService {

	@Autowired
	private Messages messages;
	
	public int add(Message message) {
		try {
			message.setFromW("Java");
			message.setToW("C#");
			messages.save(message);
			CSharpSend s = new CSharpSend();
			s.sendMsg(message.getText());
			System.out.println("Text from Angular to Java " + message.getText());
			return 200;
		}catch(Exception e) {
			return 500;
		}	
	}
	
	public Message getMessage() throws IOException, InterruptedException{
		
		String newRec = null;
		CSharpReceive r = new CSharpReceive(newRec);
		
		Message m = new Message();
		m.setText(r.receiveMsg());
		m.setFromW("C#");
		m.setToW("Java");
		System.out.println("text from C# " + m.getText());
		messages.save(m);
		return m;
	}
	
}
