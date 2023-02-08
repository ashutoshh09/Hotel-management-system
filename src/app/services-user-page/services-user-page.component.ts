import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Service } from '../service';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-services-user-page',
  templateUrl: './services-user-page.component.html',
  styleUrls: ['./services-user-page.component.css']
})
export class ServicesUserPageComponent implements OnInit {

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

  getGuest(){
    this.service.getservice().subscribe((data)=>(this.guest=data));
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

}
