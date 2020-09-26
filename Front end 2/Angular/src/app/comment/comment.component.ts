import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { CommentService } from '../service/comment.service';
import { RegistrationService } from '../service/registration.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
 export class CommentComponent implements OnInit {
  user:User=new User();
  msg1:string;
  errorMsg1:string;
  
 // view :boolean=true;
  constructor(private commentService:CommentService, private router:Router) { }

  ngOnInit(): void {
  }
  comment() {
   this.commentService.comment(this.user).subscribe(
      (data)=>{
      console.log("Data",data);
      this.msg1=data;
      this.errorMsg1=undefined;
      this.router.navigate(['viewCom'])
      },
      (error)=>{
        this.errorMsg1=error.error;
      console.log(this.errorMsg1);
      this.msg1=undefined;
            }
      );
      //this.view=false;
  }

}
