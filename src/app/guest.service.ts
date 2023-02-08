import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import{Observable}from 'rxjs';
import { Guest } from './guest';

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  viewUrl:string;
  addUrl:string;
  findguestUrl:string;
  updateUrl:string;
  deleteUrl:string;
  findguestbyNUrl:string;
  http:HttpClient;

  name!:string;

  constructor(http:HttpClient) {
    this.http=http;
    this.viewUrl='http://localhost:2020/admin/allguest';
    this.addUrl='http://localhost:2020/admin/addguest';
    this.findguestUrl='http://localhost:2020/admin/findguest';
    this.findguestbyNUrl='http://localhost:2020/admin/findguestname';
    this.updateUrl='http://localhost:2020/admin/guest';
    this.deleteUrl='http://localhost:2020/admin/deleteguest';




   }

   public viewAllGuest():Observable<Guest[]>{

    return this.http.get<Guest[]>(this.viewUrl);




   }

   namegetter(t:string){

    this.name=t;

   }

   public addGuest(guest:Guest){
    return this.http.post<Guest>(this.addUrl,guest);


   }
  updateGuestById(id:number,guest:Guest):Observable<Guest>{
    console.log(guest);
    console.log(id);
    return this.http.put<Guest>(`${this.updateUrl}/${id}`,guest);
   }

   getGuestById(id:number):Observable<Guest>{
    return this.http.get<Guest>(`${this.findguestUrl}/${id}`);
   }

   getGuestByName(id:String):Observable<Guest>{

    return this.http.get<Guest>(`${this.findguestbyNUrl}/${this.name}`);
   }

   deleteGuestByid(id:number):Observable<Guest>{
    return this.http.delete<Guest>(`${this.deleteUrl}/${id}`);
   }

   
}
