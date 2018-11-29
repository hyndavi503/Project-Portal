import { AdminLogin } from "./adminlogin.model";
import { Http } from "@angular/http";
import { Router } from "@angular/router";
import {HttpClient} from '@angular/common/http'
import { Injectable } from "@angular/core";
import { User } from "../register/user.model";
import { Observable } from "../../../node_modules/rxjs";

@Injectable()
  export class AdminService
  {
user:User;
    adminLogin:AdminLogin;
    trainersList:User[]=[];
    response:Response;
    constructor(private http:Http,private route:Router,private httpClient:HttpClient)
    {
    }

    ngOnInit() {
    }
  
  
    adminloginProcess(adminLogin:AdminLogin)
    {
      this.http.post('http://localhost:8070/comment/adminlogin',adminLogin).subscribe
      (
        (response) =>
        {
          console.log(response.json())
          if(response.json()!==null)
          {
              this.adminLogin=response.json();
            this.route.navigate(['/adminprofile']);
          }
          else
          {
            alert("admin login failed");
          }
        }
      );
    }

  
    getFacultyDetails(): Observable<User[]>
    {
      return this.httpClient.get<User[]>('http://localhost:8070/comment/trainerDetails');
    }
  }