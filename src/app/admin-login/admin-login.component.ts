import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AdminloginService } from '../adminlogin.service';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  

  admin:Admin=new Admin();
  guest:Guest=new Guest();
  email!:string;
  constructor( private service:GuestService,private adminService:AdminloginService,private router:Router){}
 
  ngOnInit(): void {
   
  }
  result:Boolean=false;



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
    this.router.navigate(['/userpage']);
  }


  getGuestDetails(){
    console.log(this.guest)
    this.service.addGuest(this.guest).subscribe(data=>{
      alert("Added Successfully!");
    },error=>alert("Added Successfully!"));
    console.log(this.guest.name);
    this.service.namegetter(this.guest.name);
    this.guest=new Guest();
    
    //this.redirectToView();
  
   }

   redirectToView(){
    this.router.navigate(['userpage']).then(()=>{window.location.reload();});
  
   }





}
