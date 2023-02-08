import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-addguest',
  templateUrl: './addguest.component.html',
  styleUrls: ['./addguest.component.css']
})
export class AddguestComponent {
  service:GuestService;
  guest:Guest;
  constructor(service:GuestService, private router:Router){
    this.service=service;
    this.guest=new Guest();


  }
 
 getGuestDetails(){
  console.log(this.guest)
  this.service.addGuest(this.guest).subscribe();
  this.guest=new Guest();
  this.redirectToView();

 }

 redirectToView(){
  this.router.navigate(['view']).then(()=>{window.location.reload();});

 }
 

}
