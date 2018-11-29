import { Component, OnInit } from '@angular/core';
import {Student} from './student.model'
import { Http } from '@angular/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {



  student:Student;
  constructor(private http:Http,private route:Router) {
    this.student=new Student;
   }

  ngOnInit() {
  }

}
