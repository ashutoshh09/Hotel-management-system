import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'
import {FormsModule} from '@angular/forms';
import { ViewguestComponent } from './viewguest/viewguest.component';
import { AddguestComponent } from './addguest/addguest.component';
import { UserComponent } from './user/user.component';
import { AdduserComponent } from './adduser/adduser.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UpdateguestComponent } from './updateguest/updateguest.component';
import { UserpageComponent } from './userpage/userpage.component';
import {ToastrModule} from 'ngx-toastr';
import { AdminHomePageComponent } from './admin-home-page/admin-home-page.component';
import { ServicesPageComponent } from './services-page/services-page.component';
import { ServicesUserPageComponent } from './services-user-page/services-user-page.component';
import { SpecificUserComponent } from './specific-user/specific-user.component';
import { SpecificGuestComponent } from './specific-guest/specific-guest.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewguestComponent,
    AddguestComponent,
    UserComponent,
    AdduserComponent,
    AdminLoginComponent,
    UserRegisterComponent,
    UpdateguestComponent,
    UserpageComponent,
    AdminHomePageComponent,
    ServicesPageComponent,
    ServicesUserPageComponent,
    SpecificUserComponent,
    SpecificGuestComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,
    AppRoutingModule, ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
