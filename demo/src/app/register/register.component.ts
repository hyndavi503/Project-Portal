import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import {User} from './user.model';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
user:User;

  constructor(private http:Http,private route:Router) { 

    this.user=new User();
  }

  ngOnInit() {
  }


  register()
  {
    this.http.post('http://localhost:8070/comment/register',this.user).subscribe
    (
      (response) =>console.log(response)
    );
    this.route.navigate(['/login']);
  }

}
