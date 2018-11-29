import { Component, OnInit } from '@angular/core';
import {AdminService} from '../adminlogin/adminservice'
import { User } from '../register/user.model';
import { UserService } from '../services/user.service';


@Component({
 selector: 'app-trainer',
 templateUrl: './trainer.component.html',
 styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {

 facultyList:User[];

 constructor(private adminservice:AdminService,private userService:UserService) { }

 ngOnInit() {
   this.adminservice.getFacultyDetails().subscribe(
     (data)=>{
       this.facultyList=data;
       console.log(data);
     }
   );
 }
active(trainer:User)
{
  console.log(trainer);
  this.userService.ActivateUpdateUser(trainer.uid).subscribe(
    (result)=>{
      if(result==true)
      {
        trainer.status=true;
      }
    }
  )
}

 deactivate(trainer: User){
   this.userService.DeactivateUpdateUser(trainer.uid).subscribe(
     (result) =>{
      console.log(result);
       if(result==true){
          trainer.status=false;
       }
   });
}

}