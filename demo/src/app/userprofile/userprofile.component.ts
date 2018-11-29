import { Component, OnInit } from '@angular/core';
import { User } from '../register/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  userProfile:User;

  constructor(private userService:UserService) {

    this.userProfile=new User();
    this.userService.getUserProfile().subscribe(
      (userProfile)=>{
        this.userProfile=userProfile;
        console.log(userProfile);
        console.log(this.userProfile.name);
      }
    )
   }

  ngOnInit() {
  }

}
