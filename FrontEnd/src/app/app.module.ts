import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { RegisterpageComponent } from './components/registerpage/registerpage.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { ViewproductComponent } from './components/viewproduct/viewproduct.component';
import {  HttpClientModule } from '@angular/common/http';
import { SellerproductsComponent } from './components/sellerproducts/sellerproducts.component';
import { CustomPipePipe } from './pipes/custom-pipe.pipe';
import { CartComponent } from './components/cart/cart.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { CheckoutpageComponent } from './components/checkoutpage/checkoutpage.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainpageComponent,
    RegisterpageComponent,
    LoginpageComponent,
    ViewproductComponent,
    SellerproductsComponent,
    CustomPipePipe,
    CartComponent,
    AdminLoginComponent,
    CheckoutpageComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
