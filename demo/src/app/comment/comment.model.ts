import { PostBlogs } from "../postblogs/postblogs.model";
import { User } from "../register/user.model";

export class Comment
{
    commentid:number;
  comment:string;
    postBlogs:PostBlogs;
    user:User;
}