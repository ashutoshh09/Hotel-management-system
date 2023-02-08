import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent {
  service:UserService;
  u:User;


  constructor(service:UserService, private router:Router){
    this.service=service;
    this.u=new User();

  }

  getUserDetails(){
    
    this.service.addusers(this.u).subscribe();
    this.u=new User();

    this.redirectToView();
  }
  redirectToView(){
    this.router.navigate(['user']).then(()=>{window.location.reload();});
  
   }

}
