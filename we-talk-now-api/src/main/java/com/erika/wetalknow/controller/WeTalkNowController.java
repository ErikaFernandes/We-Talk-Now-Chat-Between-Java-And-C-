package com.erika.wetalknow.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.erika.wetalknow.model.Message;
import com.erika.wetalknow.model.MessageService;


@Controller
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class WeTalkNowController {
	
	@Autowired
	private MessageService messageService;
	
	
	@PostMapping("/message")
	public int sendMessage(@RequestBody @Valid Message message) {
		int resp =	messageService.add(message);
		return resp; 
	}
	
	@GetMapping("/message")
	public Message getMessages() throws IOException, InterruptedException{
		return messageService.getMessage();
	}
}
