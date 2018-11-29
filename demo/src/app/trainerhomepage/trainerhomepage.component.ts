import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { PostBlogs } from '../postblogs/postblogs.model';
import {Comment} from '../comment/comment.model';
import { CommentService } from '../comment/comment.service';

@Component({
  selector: 'app-trainerhomepage',
  templateUrl: './trainerhomepage.component.html',
  styleUrls: ['./trainerhomepage.component.css']
})
export class TrainerhomepageComponent implements OnInit {
postLists:PostBlogs[];
comment:Comment;
newMessage:string;
  constructor(private userService:UserService,private commentService:CommentService) { 
   this.comment=new Comment();
  }

  ngOnInit() {

    // this.userService.getPosts().subscribe(
    //   (data)=>{
    //     console.log(data);
    //     this.postLists=data;
        
    //   }
    // )
  }

  // addComment(postBlogs:PostBlogs)
  // {
  //   this.comment.comment=this.newMessage;
  //   this.comment.postBlogs=postBlogs;
  //   this.comment.user=this.userService.retrievedUser;
  // this.commentService.addComment(this.comment).subscribe(
  //   (response)=>{
  //     if(response){
  //       postBlogs.comment.push(this.comment)
  //     }
  //   }
  // )
  // }

}
