import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-updateguest',
  templateUrl: './updateguest.component.html',
  styleUrls: ['./updateguest.component.css']
})
export class UpdateguestComponent implements OnInit {
  id! :number;
  guest:Guest=new Guest();
  constructor(private service: GuestService,private route:ActivatedRoute,private router:Router){}
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.service.getGuestById(this.id).subscribe(data=>{this.guest=data;},error=>console.log(error));
   
  }



  onSubmit(){

    console.log(this.guest);
    console.log(this.id);
    this.service.updateGuestById(this.id,this.guest).subscribe(data=>{this.gotoGuestList();},error=>console.log(error));
   
  }

  gotoGuestList(){
    this.router.navigate(['/view']);
  }
}
