import { User } from "../register/user.model";
import {Comment} from '../comment/comment.model';

export class PostBlogs
{
    postId:number;
    postTitle:string;
    postDescription:string;
    user:User;
    comment:Comment[];
}