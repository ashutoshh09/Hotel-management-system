import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-admin-home-page',
  templateUrl: './admin-home-page.component.html',
  styleUrls: ['./admin-home-page.component.css']
})
export class AdminHomePageComponent {
  guest:Guest=new Guest();
  service:GuestService;
 

  constructor(service:GuestService,private router:Router){
    this.service=service;
  }

  getGuestDetails(){
    console.log(this.guest)
    this.service.addGuest(this.guest).subscribe();
    this.guest=new Guest();
    this.redirectToView();
  
   }

   redirectToView(){
    this.router.navigate(['userpage']).then(()=>{window.location.reload();});
  
   }

}
