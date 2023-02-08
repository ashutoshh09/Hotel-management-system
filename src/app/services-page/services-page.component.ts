import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Service } from '../service';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-services-page',
  templateUrl: './services-page.component.html',
  styleUrls: ['./services-page.component.css']
})
export class ServicesPageComponent implements OnInit {
  service:ServicesService;
  guest:Service[];
  id?:number;
  bil?:number;

  constructor(  service:ServicesService
    , private router:Router,private route:ActivatedRoute){
    
    this.service=service;
    this.guest=[];
  }
  ngOnInit(): void {
  
   
    this.getGuest();
  }


  public searchEmployees(key: string): void {
    console.log(key);
    const results: Service[] = [];
    for (const employee of this.guest) {
      if (employee.servicename.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.servicedesc.toLowerCase().indexOf(key.toLowerCase()) !== -1
      )  {
        results.push(employee);
      }
    }
    this.guest = results;
    if (results.length === 0 || !key) {
      this.getGuest();
    }
  }
  getGuest(){
    this.service.getservice().subscribe((data)=>(this.guest=data));
  }
  updateGuest(id:number){

    this.router.navigate(['updateguest',id]);


  }

  deleteGuest(id:number){

    this.service.deleteservice(id).subscribe(data=>{this.getGuest();},error=>console.log(error));

  }
  gotoGuestList(){
    this.router.navigate(['/view']);
  }
  updateEmployee: Service = new Service;
  editEmployee: Service = new Service;
  deleteEmployee: Service = new Service;

  public onOpenModal(employee: Service, mode: string): void {
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
   
    container?.appendChild(button);
    button.click();
  }
  onSubmit(){

    console.log(this.updateEmployee);
    console.log(this.updateEmployee.id);
   
    
    this.service.updateServices(this.updateEmployee.id,this.updateEmployee).subscribe(data=>{this.redirectToView();},error=>console.log(error));
   
  }


  
  getGuestDetails(){
    console.log(this.editEmployee)
    this.service.addservice(this.editEmployee).subscribe();
    this.editEmployee=new Service();
    this.redirectToView();
  
   }
  
   redirectToView(){
    this.router.navigate(['view']).then(()=>{window.location.reload();});
  
   }



}
