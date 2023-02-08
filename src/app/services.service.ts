import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import{Observable}from 'rxjs';
import { Service } from './service';
 

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  
  viewService:string;
  addUrl:string;
  updateService:string;
 
  deleteUser:string;
  apiServerUrl:string;
  http:HttpClient;

  constructor(http:HttpClient) {
    this.http=http;
    this.viewService='http://localhost:2020/admin/allservice';
    this.addUrl='http://localhost:2020/admin/addservice';
    this.updateService='http://localhost:2020/admin/updateservice';
    
    this.deleteUser='http://localhost:2020/admin/deleteservice';
    this.apiServerUrl='http://localhost:2020/admin';
  }

  public getservice():Observable<Service[]>{

    return this.http.get<Service[]>(this.viewService);
   }
   
 

   public addservice(user:Service){
    return this.http.post<Service>(this.addUrl,user);
   }

   public deleteservice(id:number):Observable<void>{
    return this.http.delete<void>(`${this.deleteUser}/${id}`);

    //return this.http.delete<void>(this.deleteUser,id);
   }

  //  public updateServices(employee: Service): Observable<Service> {
  //   return this.http.put<Service>(`${this.apiServerUrl}/updateservice/${employee.id}`, employee);
  // }


  updateServices(id:number,guest:Service):Observable<Service>{
    console.log(guest);
    console.log(id);
    return this.http.put<Service>(`${this.apiServerUrl}/updateservice/${id}`, guest);
   }


}
