import { Component, OnInit } from '@angular/core';
import { Login } from './login.model';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import {Response} from '@angular/http';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  login:Login;
  response:Response;
  constructor(private http:Http,private route:Router,private userService:UserService) { 
      this.login=new Login();
  }

  ngOnInit() {
  }

  loginProcess()
  {
    this.userService.loginProcess(this.login);
    
  }
  }

