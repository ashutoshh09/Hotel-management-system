import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddguestComponent } from './addguest/addguest.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomeComponent } from './home/home.component';
import { ServicesPageComponent } from './services-page/services-page.component';
import { ServicesUserPageComponent } from './services-user-page/services-user-page.component';
import { SpecificGuestComponent } from './specific-guest/specific-guest.component';
import { SpecificUserComponent } from './specific-user/specific-user.component';
import { UpdateguestComponent } from './updateguest/updateguest.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserComponent } from './user/user.component';
import { UserpageComponent } from './userpage/userpage.component';
import { ViewguestComponent } from './viewguest/viewguest.component';

const routes: Routes = [

  {path:'home',redirectTo:'/welcome'},{path:'view',component:ViewguestComponent},
  {path:'add',component:AddguestComponent},
  {path:'user',component:UserComponent},
  {path:'login',component:AdminLoginComponent},
  {path:'register',component:UserRegisterComponent},
  {path:'adduser',component:AdduserComponent},
  {path:'updateguest/:id',component:UpdateguestComponent},
  {path:'adminpage',component:UserpageComponent},{path:'servicepage',component:ServicesPageComponent},
  {path:'userpage',component:AdminLoginComponent},{path:'services',component:ServicesUserPageComponent},
  {path:'specificguest',component:SpecificGuestComponent},{path:'specificuser',component:SpecificUserComponent},{path:'welcome',component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
