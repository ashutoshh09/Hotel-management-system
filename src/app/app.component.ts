import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from './admin';
import { AdminloginService } from './adminlogin.service';
import { User } from './user';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-first-project';
  user:User= new User();
  admin:Admin=new Admin();
  service:UserService;
  loggedin:number=0;
  adi:String='admin';
  adminService:AdminloginService;
  loggedinUser?:String;

 

 
  constructor(adminService:AdminloginService,service:UserService, private router:Router){
    this.service=service;
    this.adminService=adminService;
  }

  UserRegister(){
    console.log(this.user);
    this.service.addusers(this.user).subscribe(data=>{alert("Successfully Registered")},error=>alert("Sorry user not register"));
    ;
    this.user=new User();


  }

  adminLogin(){

    
    this.adminService.loginadmin(this.admin).subscribe(data=>{
       this.gotoGuestList();
     },error=>alert("Sorry Please enter correct username and passoword"));
    console.log(this.adminService.loginadmin(this.admin));
    
    // this.result=this.adminService.loginadmin(this.admin);

    // this.adminService.loginadmin(this.admin).subscribe( r=>{this.result=r; console.log(this.result)});
    // if(this.result==true){
    //   console.log(this.result);
    //   this.gotoGuestList();
    // }
    
  }

  gotoGuestList(){
    this.loggedin=1;
   
    this.router.navigate(['/adminpage']);
  }



  userLogin(){

    this.loggedinUser=this.user.email;

    this.service.userLogin(this.user).subscribe(data=>{
       this.gotouserPage();
     },error=>alert("Sorry Please enter correct username and passoword"));
    console.log(this.adminService.loginadmin(this.admin));
    this.service.emailgetter(this.user.email);
    // this.result=this.adminService.loginadmin(this.admin);

    // this.adminService.loginadmin(this.admin).subscribe( r=>{this.result=r; console.log(this.result)});
    // if(this.result==true){
    //   console.log(this.result);
    //   this.gotoGuestList();
    // }
    
  }

  gotouserPage(){
    this.loggedin=1;
    this.adi='user';
    this.router.navigate(['/userpage']);
  }

  logout(){
    this.loggedin=0;
    this.router.navigate(['/home']);
  }

  updatePassword(){

    this.adminService.updatePassword('admin',this.admin).subscribe(d=>{alert("Password Updated")},error=>alert("Password Updated"));
  }

  
}
