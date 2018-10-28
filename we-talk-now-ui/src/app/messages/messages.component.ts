import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup } from '@angular/forms';
import {MatProgressBarModule} from '@angular/material/progress-bar';

import { Message } from '../message';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']

})
export class MessagesComponent implements OnInit {

// progress bar
  progress = 0;
  posting = false;
// progress bar

// enable field
  enabdis = false;

  // placeholder
  msgPlaceHolder = "Your Message";

  msgobj: any;
  message: Array<any>;

  msg;

  respRegister: any;

  constructor(private messageService: MessageService) { }
  @ViewChild("target") el: ElementRef;
  @ViewChild("audio") bipsong: ElementRef;


  ngOnInit() {
      this.newMessage();
      this.msg=[
        {txt: "",
        from: "",
        date: ""}
      ]

  }

dateObj = Date.now();


  getMessages(): void {
    this.msgPlaceHolder = "Waiting for C# ...";
    this.messageService.getMessage()
    .subscribe(resp => {
      this.msg.push({
        txt: resp.text,
        from: "C#",
        date: Date.now()
      });
      this.el.nativeElement.scrollIntoView();
      this.enabdis = false; // enable input and bottom
      this.bipsong.nativeElement.play();
      this.msgPlaceHolder = "Your Message";
    });

  }

  newMessage(){
    this.msgobj = {  text: '' }
  }
  postMessages(): void {
    this.posting = true; // show progress bar
    this.progress = 50; // progress bar
    this.enabdis = true; // disable input and bottom

    this.messageService.postMessage(this.msgobj)
    .subscribe(resp => {
      if(resp == 200){
        this.respRegister = "Message sent";
        this.msg.push({
          txt: this.msgobj.text,
          from: "Angular and Java",
          date:  Date.now()
        });
        this.progress = 100;
        this.el.nativeElement.scrollIntoView();
        this.posting = false; // hide progress bar
        this.getMessages();
      }else{
        this.respRegister = "Something went wrong, try again later";
        alert(this.respRegister);
      }

      this.newMessage();

    });


  }


}
