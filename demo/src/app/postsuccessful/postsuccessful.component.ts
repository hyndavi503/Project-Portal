import { Component, OnInit } from '@angular/core';
import { PostBlogs } from '../postblogs/postblogs.model';
import { Router } from '../../../node_modules/@angular/router';
import { UserService } from '../services/user.service';
import {Comment} from '../comment/comment.model'
import {CommentService} from '../comment/comment.service'

@Component({
  selector: 'app-postsuccessful',
  templateUrl: './postsuccessful.component.html',
  styleUrls: ['./postsuccessful.component.css']
})
export class PostsuccessfulComponent implements OnInit {


 comment:Comment;
  postBlogsList:PostBlogs[];
  newMessage:string;
  constructor(private route:Router,private userService:UserService,private commentService:CommentService) { 
    this.comment=new Comment();
  }

  ngOnInit() {

    this.userService.getPosts().subscribe(
      (postBlogsList)=>{
        postBlogsList.forEach((post) => {
          this.userService.getComments(post.postId).subscribe(
          (comments)=>{
               post.comment=comments;
          }
          );
          
        });

      

        this.postBlogsList=postBlogsList;
        console.log(postBlogsList);
      }
    )
  }

  addComment(postBlogs:PostBlogs)
  {
    this.comment.comment=this.newMessage;
    this.comment.postBlogs=postBlogs;
    this.comment.user=this.userService.retrievedUser;
  this.commentService.addComment(this.comment).subscribe(
    (response)=>{
      if(response){
        postBlogs.comment.push(this.comment)
      }
    }
  )
  }

}
