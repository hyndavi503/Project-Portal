import { Component, OnInit } from '@angular/core';
import { PostBlogs } from './postblogs.model';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import {Comment} from '../comment/comment.model';

@Component({
  selector: 'app-postblogs',
  templateUrl: './postblogs.component.html',
  styleUrls: ['./postblogs.component.css']
})
export class PostblogsComponent implements OnInit {

postBlogs:PostBlogs;

  constructor(private http:Http,private route:Router,private userService:UserService) { 

    this.postBlogs=new PostBlogs();
  }

  ngOnInit() {
  }

  postBlogProcess()
  {
    this.userService.addPost(this.postBlogs);
    
  }
}

