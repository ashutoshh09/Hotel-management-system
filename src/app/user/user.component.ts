import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{

 
  // public editEmployee: User;
  // public deleteEmployee: User;

  service:UserService;
  public user:User[];
  editEmployee: User = new User;
  deleteEmployee: User = new User;
    
  
  // u:User=new User();
  public searchEmployees(key: string): void {
    console.log(key);
    const results: User[] = [];
    for (const employee of this.user) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.address.toLowerCase().indexOf(key.toLowerCase()) !== -1 )  {
        results.push(employee);
      }
    }
    this.user = results;
    if (results.length === 0 || !key) {
      this.getUser();
    }
  }
 


  constructor(service:UserService, private router:Router){
    this.service=service;
    this.user=[];
      


   


  }

  ngOnInit(): void {
    this.getUser();
  }
  
  deleteUser(id:number){
    //this.service.deleteusers(id).subscribe( data=>{this.getGuest();},error=>console.log(error));
   // this.redirectToView();
   this.service.deleteusers(id).subscribe((response:void)=>{console.log(response);this.getUser();}, (error: HttpErrorResponse) => {
    alert(error.message);
  }
);
}
   
  redirectToView(){
    this.router.navigate(['user']).then(()=>{window.location.reload();});
  
   }
   gotoGuestList(){
    this.router.navigate(['/user']);
  }
  getGuest(){
    this.service.getUsers().subscribe((data)=>(this.user=data));
  }

  public getEmployees(): void {
    this.service.getUsers().subscribe(
      (response: User[]) => {
        this.user = response;
        console.log(this.user);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public getUser():void{
    this.service.getUsers()
    
    
    
    .subscribe(
      (response: User[]) => {
        this.user = response;
        console.log(this.user);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

  public onOpenModal(employee: User, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
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


  // u=new User();

  // getUserDetails(){
    
  //   this.service.addusers(this.u).subscribe();
  //   this.u=new User();

  //   this.redirectToView();
  // }
  // redirectToView(){
  //   this.router.navigate(['user']).then(()=>{window.location.reload();});
  
  //  }
  // public onAddUser(addForm: NgForm): void {
  //   document.getElementById('add-employee-form').click();
  //   this.service.addusers(addForm.value).subscribe();
  // }

  public onUpdateEmloyee(employee: User): void {
    this.service.updateUsers(employee).subscribe(
      (response: User) => {
        console.log(response);
        this.getUser();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEmloyee(employeeId: number): void {
    this.service.deleteusers(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getUser();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  // public editEmployee: User;
  // public deleteEmployee: User;
  // // }

  // public onOpenModal(employee: User, mode: string): void {
  //   const container = document.getElementById('main-container');
  //   const button = document.createElement('button');
  //   button.type = 'button';
  //   button.style.display = 'none';
  //   button.setAttribute('data-toggle', 'modal');
  //   if (mode === 'add') {
  //     button.setAttribute('data-target', '#addEmployeeModal');
  //   }
  //   if (mode === 'edit') {
  //     this.editEmployee = employee;
  //     button.setAttribute('data-target', '#updateEmployeeModal');
  //   }
  //   if (mode === 'delete') {
  //     this.deleteEmployee = employee;
  //     button.setAttribute('data-target', '#deleteEmployeeModal');
  //   }
  //   container.appendChild(button);
  //   button.click();
  // }
  
 





}
}