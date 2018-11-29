import { Injectable } from "@angular/core";

import { Http } from "@angular/http";
import { Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { User } from "../register/user.model";
import { Login } from "../login/login.model";
import { Observable } from "../../../node_modules/rxjs";
import { PostBlogs } from "../postblogs/postblogs.model";



@Injectable()
export class UserService
{

  retrievedUser:User;
comment:Comment;

constructor(private http:Http,private route:Router,private httpClient:HttpClient)
{
  
}

loginProcess(login:Login)
  {
    this.httpClient.post<User>('http://localhost:8070/comment/login',login).subscribe
    (

      (response)=>{
      this.retrievedUser=response;
        console.log(this.retrievedUser.role);
        if(this.retrievedUser.role==='admin')
        {

        this.route.navigate(['/admin']);
        }
        else if(this.retrievedUser.role==='student')
        {
        this.route.navigate(['/student']);
      }
      else if(this.retrievedUser.role==='faculty')
      {
          if(this.retrievedUser.status===true)
          {
          this.route.navigate(['/trainerhomepage']);
        }
        else{this.route.navigate(['/login']);}
        }
        else{
         
          this.route.navigate(['/login']);}
      }
    );
    
  }




  ActivateUpdateUser(uid:number):Observable<boolean>{
    console.log(uid);
  return this.httpClient.get<boolean>('http://localhost:8070/comment/activeuser/'+uid);
}
DeactivateUpdateUser(uid:number): Observable<boolean>{
  console.log(uid);
return this.httpClient.get<boolean>('http://localhost:8070/comment/deactiveuser/'+uid);

}


addPost(postBlog:PostBlogs)
{
postBlog.user=this.retrievedUser;
this.http.post('http://localhost:8070/comment/postblog',postBlog).subscribe(
  (response)=>{
    console.log(response);
if(this.retrievedUser.role==='admin')
{
  this.route.navigate(['/admin']);
}
else if(this.retrievedUser.role==='student')
{
  this.route.navigate(['/student']);
}
else if(this.retrievedUser.role==='faculty')
{
  this.route.navigate(['/postsuccessful']);
}
}

);
}


getPosts():Observable<PostBlogs[]>
{
return this.httpClient.get<PostBlogs[]>('http://localhost:8070/comment/getposts');

}

getUserProfile():Observable<User>
{
  return this.httpClient.get<User>('http://localhost:8070/comment/profile/'+this.retrievedUser.uid);
}

getComments(postId:number):Observable<Comment[]>
{
  return this.httpClient.get<Comment[]>('http://localhost:8070/comment/comments/'+postId);
}





}