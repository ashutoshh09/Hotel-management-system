import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import{Observable}from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  viewUrl:string;
  addUrl:string;
  viewUser:string;
  addUser:string;
  deleteUser:string;
  apiServerUrl:string;
  findguestbyNUrl:string;
  http:HttpClient;
  email!:String;

  constructor(http:HttpClient) {
    this.http=http;
    this.viewUrl='http://localhost:2020/admin/allguest';
    this.addUrl='http://localhost:2020/admin/addguest';
    this.viewUser='http://localhost:2020/admin/alluser';
    this.addUser='http://localhost:2020/admin/adduser';
    this.deleteUser='http://localhost:2020/admin/deleteuser';
    this.apiServerUrl='http://localhost:2020/admin';
    this.findguestbyNUrl='http://localhost:2020/admin/findusername';
  }


   public getUsers():Observable<User[]>{

    return this.http.get<User[]>(this.viewUser);
   }
   name!:string;
   emailgetter(t:string){

    this.name=t;

   }

   
   getUserByName(id:String):Observable<User>{

    return this.http.get<User>(`${this.findguestbyNUrl}/${this.name}`);
   }
 

   public addusers(user:User){
    return this.http.post<User>(this.addUser,user);
   }

   public deleteusers(id:number):Observable<void>{
    return this.http.delete<void>(`${this.deleteUser}/${id}`);

    //return this.http.delete<void>(this.deleteUser,id);
   }

   public updateUsers(employee: User): Observable<User> {
    return this.http.put<User>(`${this.apiServerUrl}/updateuser/${employee.id}`, employee);
  }

  private baseurl='http://localhost:2020/user/login';

  userLogin(admin:User):Observable<User>{
    console.log(admin);
    console.log(this.http.get(this.baseurl));
    console.log(this.http.post(`${this.baseurl}`,admin));
    return this.http.post<User>(`${this.baseurl}`,admin);
  }



 
}
