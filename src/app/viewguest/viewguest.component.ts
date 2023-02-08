import { Component ,OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Guest } from '../guest';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-viewguest',
  templateUrl: './viewguest.component.html',
  styleUrls: ['./viewguest.component.css']
})
export class ViewguestComponent implements OnInit {

  service:GuestService;
  guest:Guest[];
  id?:number;
  bil?:number;

  constructor(service:GuestService, private router:Router,private route:ActivatedRoute){
    
    this.service=service;
    this.guest=[];
  }
  ngOnInit(): void {
  
   
    this.getGuest();
  }


  public searchEmployees(key: string): void {
    console.log(key);
    const results: Guest[] = [];
    for (const employee of this.guest) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.check_in.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.check_out.toLowerCase().indexOf(key.toLowerCase()) !== -1 )  {
        results.push(employee);
      }
    }
    this.guest = results;
    if (results.length === 0 || !key) {
      this.getGuest();
    }
  }
  getGuest(){
    this.service.viewAllGuest().subscribe((data)=>(this.guest=data));
  }
  updateGuest(id:number){

    this.router.navigate(['updateguest',id]);


  }

  deleteGuest(id:number){

    this.service.deleteGuestByid(id).subscribe(data=>{this.getGuest();},error=>console.log(error));

  }
  gotoGuestList(){
    this.router.navigate(['/view']);
  }
  updateEmployee: Guest = new Guest;
  editEmployee: Guest = new Guest;
  deleteEmployee: Guest = new Guest;

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
   
    
    this.service.updateGuestById(this.updateEmployee.id,this.updateEmployee).subscribe(data=>{this.redirectToView();},error=>console.log(error));
   
  }


  
  getGuestDetails(){
    console.log(this.editEmployee)
    this.service.addGuest(this.editEmployee).subscribe();
    this.editEmployee=new Guest();
    this.redirectToView();
  
   }
  
   redirectToView(){
    this.router.navigate(['view']).then(()=>{window.location.reload();});
  
   }



}
