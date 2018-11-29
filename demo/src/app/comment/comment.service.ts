import { Injectable } from "../../../node_modules/@angular/core";
import { Observable } from "../../../node_modules/rxjs";
import { HttpClient } from "@angular/common/http";
import {Comment} from '../comment/comment.model';


@Injectable()
export class CommentService {
   public constructor(private httpClient: HttpClient){
   }
   public addComment(comment: Comment): Observable<boolean>{
       return this.httpClient.post<boolean>('http://localhost:8070/comment/addcomment',comment);
   }
}
