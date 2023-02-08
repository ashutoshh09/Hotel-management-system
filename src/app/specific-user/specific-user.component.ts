import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-specific-user',
  templateUrl: './specific-user.component.html',
  styleUrls: ['./specific-user.component.css']
})
export class SpecificUserComponent {

  service:UserService;
  guest:User;
  
  constructor( service:UserService, private router:Router){
    this.guest=new User();
    this.service=service;
  }
  ngOnInit(): void {

    this.getguestbyname();
    
  }

  getguestbyname(){

   
    this.service.getUserByName(this.guest.name).subscribe((data)=>(this.guest=data));




}

onSubmit(){


 
  
  this.service.updateUsers(this.guest).subscribe(data=>{alert("Updated Succesfully!")},error=>console.log(error));
 
}
redirectToView(){
  this.router.navigate(['userpage']).then(()=>{window.location.reload();});

 }
  
  

}
