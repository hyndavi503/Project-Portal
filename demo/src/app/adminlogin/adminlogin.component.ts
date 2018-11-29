import { Component, OnInit } from '@angular/core';
import { AdminLogin } from './adminlogin.model';
import { Http } from '@angular/http';
import { Router } from '@angular/router';
import { AdminService } from './adminservice';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  adminLogin:AdminLogin;
  constructor(private adminService:AdminService) { 
    this.adminLogin=new AdminLogin();
  }

  ngOnInit() {
  }


  adminloginProcess()
  {
    this.adminService.adminloginProcess(this.adminLogin);
  }
}
