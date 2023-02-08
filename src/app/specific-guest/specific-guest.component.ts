import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-specific-guest',
  templateUrl: './specific-guest.component.html',
  styleUrls: ['./specific-guest.component.css']
})
export class SpecificGuestComponent implements OnInit{

  service:GuestService;
  guest:Guest;
  
  constructor( service:GuestService, private router:Router){
    this.guest=new Guest();
    this.service=service;
  }
  ngOnInit(): void {

    this.getguestbyname();
    
  }

  getguestbyname(){

   
    this.service.getGuestByName(this.guest.name).subscribe((data)=>(this.guest=data));




}

deleteGuest(id:number){

  this.service.deleteGuestByid(id).subscribe(data=>{this.getguestbyname();},error=>console.log(error));

}
gotoGuestList(){
  this.router.navigate(['/view']);
}
updateEmployee: Guest = new Guest;
editEmployee: Guest = new Guest;
deleteEmployee: Guest =new Guest;

bil!:number;


public onOpenModal(employee: Guest, mode: string): void {
  const container = document.getElementById('main-container');
  const button = document.createElement('button');
  button.type = 'button';
  button.style.display = 'none';
  button.setAttribute('data-toggle', 'modal');
  if (mode === 'update') {
    this.updateEmployee = employee;
    button.setAttribute('data-target', '#editEmployeeModal');
  }
  if (mode === 'edit') {
    this.editEmployee = employee;
    button.setAttribute('data-target', '#updateEmployeeModal');
  }
  if (mode === 'delete') {
    this.deleteEmployee = employee;
    button.setAttribute('data-target', '#deleteEmployeeModal');
  }
  if (mode === 'bill') {
    this.editEmployee = employee;
    var date1 = new Date(employee.check_in);
    var date2 = new Date(employee.check_out);
    var diff = Math.abs(date2.getTime() - date1.getTime());
    var diffDays = Math.ceil(diff / (1000 * 3600 * 24)); 
    console.log(diffDays);
    this.bil=diffDays*employee.room*employee.nosguest*1000;
    button.setAttribute('data-target', '#bill');
  }
  container?.appendChild(button);
  button.click();
}

    


onSubmit(){

  console.log(this.updateEmployee);
  console.log(this.updateEmployee.id);
 
  
  this.service.updateGuestById(this.guest.id,this.guest).subscribe(data=>{alert("Updated Successfully!");},error=>console.log(error));
 
}



getGuestDetails(){
  console.log(this.editEmployee)
  this.service.addGuest(this.editEmployee).subscribe();
  this.editEmployee=new Guest();
  this.redirectToView();

 }

 redirectToView(){
  this.router.navigate(['userpage']).then(()=>{window.location.reload();});

 }


}
