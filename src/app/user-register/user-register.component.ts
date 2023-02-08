import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';
import {ToastrService}from 'ngx-toastr';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent {
  service:UserService;

  user:User=new User();
  constructor(private toastr:ToastrService ,service:UserService, private router:Router){
    this.service=service;
  }

  UserRegister(){
    console.log(this.user);
    this.service.addusers(this.user).subscribe(data=>{alert("Successfully Registered")},error=>alert("Sorry user not register"));
    ;
    this.user=new User();


  }
  

}
