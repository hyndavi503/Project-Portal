import {NgModule,Component} from '@angular/core';
import {Routes,RouterModule} from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component'
import { PostblogsComponent } from './postblogs/postblogs.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component'
import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { StudentComponent } from './student/student.component';
import { TrainerComponent } from './trainer/trainer.component';
import { TrainerhomepageComponent } from './trainerhomepage/trainerhomepage.component';
import { PostsuccessfulComponent } from './postsuccessful/postsuccessful.component';
import { UserprofileComponent } from './userprofile/userprofile.component';


const routes:Routes=[
    
    {path:'register',component:RegisterComponent},
    {path:'login',component:LoginComponent},
    {path: 'student',component:StudentComponent},
    {path:'trainer',component:TrainerComponent},
   {path:'trainerhomepage',component:TrainerhomepageComponent},
   {path:'home',component:HomeComponent},
   {path: 'userprofile',component:UserprofileComponent},
    {path:'adminlogin',component:AdminloginComponent},
    {path:'adminprofile',component:AdminprofileComponent},
    {path:'postblogs',component:PostblogsComponent},
    {path:'postsuccessful',component:PostsuccessfulComponent}
   
    ];
@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})

export class AppRouting {
  
}
