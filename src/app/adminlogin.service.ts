import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class AdminloginService {

  private baseurl='http://localhost:2020/admin/login';
  private updateUrl='http://localhost:2020/admin/updatepassword';
  constructor(private httpClient: HttpClient) { }

  loginadmin(admin:Admin):Observable<Admin>{
    console.log(admin);
    console.log(this.httpClient.get(this.baseurl));
    console.log(this.httpClient.post(`${this.baseurl}`,admin));
    return this.httpClient.post<Admin>(`${this.baseurl}`,admin);
  }


  updatePassword(admin:String,guest:Admin):Observable<Admin>{
    console.log(guest);
    console.log(admin);
    return this.httpClient.put<Admin>(`${this.updateUrl}/${admin}`,guest);
   }
  // loginadmin(admin:Admin){
  //   console.log(admin);
  //   console.log(this.httpClient.get(this.baseurl));
  //   console.log(this.httpClient.get<Boolean>(this.baseurl+"/"+admin.username+"/"+admin.password));
  //   return this.httpClient.get<Boolean>(this.baseurl+"/"+admin.username+"/"+admin.password);
  // }




}
