import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';
import { Service } from '../service';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent {

  guest:Guest=new Guest();
  servic:Service=new Service();

  constructor(private service:GuestService,private ser:ServicesService,private router:RouterModule){}

   
 getGuestDetails(){
  console.log(this.guest)
  this.service.addGuest(this.guest).subscribe();
  this.guest=new Guest();
 

 }

 addser(){
  this.ser.addservice(this.servic).subscribe();
 }

 


}
