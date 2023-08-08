import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { CartComponent } from './components/cart/cart.component';
import { CheckoutpageComponent } from './components/checkoutpage/checkoutpage.component';
import { LoginpageComponent } from './components/loginpage/loginpage.component';
import { MainpageComponent } from './components/mainpage/mainpage.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { RegisterpageComponent } from './components/registerpage/registerpage.component';
import { SellerproductsComponent } from './components/sellerproducts/sellerproducts.component';
import { ViewproductComponent } from './components/viewproduct/viewproduct.component';


const routes: Routes = [
  {path : '' , redirectTo:'products' , pathMatch: 'full'},
  {path: 'products' ,component:MainpageComponent},
  {path: 'viewproduct/:productId' ,component:ViewproductComponent},
  {path: 'register' ,component:RegisterpageComponent},
  {path: 'seller', component:SellerproductsComponent},
  {path:'login' , component:LoginpageComponent},
  {path:'cart', component:CartComponent},
  {path:'adimlogin' , component:AdminLoginComponent},
  {path: 'checkout' , component:CheckoutpageComponent},
  {path: '**' ,component:PageNotFoundComponent}
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
