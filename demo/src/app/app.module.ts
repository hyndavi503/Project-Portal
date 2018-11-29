import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRouting} from './app-routing.module'
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PostblogsComponent } from './postblogs/postblogs.component';
import { StudentComponent } from './student/student.component';
import { TrainerComponent } from './trainer/trainer.component';


import { AdminloginComponent } from './adminlogin/adminlogin.component';
import {AdminService} from './adminlogin/adminservice';
import {HttpClientModule} from '@angular/common/http';
import {UserService} from './services/user.service'
 import { AdminprofileComponent } from './adminprofile/adminprofile.component';
import { TrainerhomepageComponent } from './trainerhomepage/trainerhomepage.component';
import { PostsuccessfulComponent } from './postsuccessful/postsuccessful.component';
import { CommentComponent } from './comment/comment.component';
import { CommentService } from './comment/comment.service';
import { UserprofileComponent } from './userprofile/userprofile.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    PostblogsComponent,
    StudentComponent,
    TrainerComponent,
    AdminloginComponent,
    AdminprofileComponent,
    TrainerhomepageComponent,
    PostsuccessfulComponent,
    CommentComponent,
    UserprofileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
   AppRouting,
    HttpModule,
    HttpClientModule
  ],
  providers: [AdminService,UserService,CommentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
