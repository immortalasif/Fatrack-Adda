import { Component, OnInit } from '@angular/core';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  loggeduser:any;
 loggedId:any;
 grandTotal:number=0;
  public product:any =[];
 // public grandTotal = this.product.price;
  
  constructor(private service: RegistrationServiceService, private router: Router) { }

  ngOnInit(  ): void {
    this.loggeduser=sessionStorage.getItem("loggedname");
   // this.loggedId =sessionStorage.getItem("userId");
    if(this.loggeduser != null){
      this.service.getCartById(this.loggeduser).subscribe({

        next: (val) => { this.product = val 
        console.log(this.product)
        this.product.forEach((a:any)=>{
          console.log(a.price);
          this.grandTotal+=parseInt(a.price);
         })
        //this.grandTotal+=this.product.price;
        
      },
        error: (val) => { console.log(val) },
  
      }
      )
      
      
           
    }
    else{
      alert("please login! ");
      this.router.navigate(['/login'])
    }
    
  }
  emptycart(){
    this.service.deleteAllCartProducts(this.loggeduser).subscribe({
      next: (val) => { 
        console.log("All items deleted");
        if(this.loggeduser != null){
          this.service.getCartById(this.loggeduser).subscribe({
    
            next: (val) => { this.product = val 
              this.grandTotal=0;
              console.log(this.product)
              this.product.forEach((a:any)=>{
                console.log(a.price);
                
                this.grandTotal+=parseInt(a.price);
               })},
            error: (val) => { console.log(val) },
      
          }
          )}
           },
    error: (val) => { console.log("deletion failed") },
    })

  }
  removeItem(item1 :any){
 
      this.service.deleteItem(this.loggeduser,item1.productid).subscribe({
        next: (val) => { console.log("item deleted");
          
          if(this.loggeduser != null){
            this.service.getCartById(this.loggeduser).subscribe({
      
              next: (val) => { this.product = val 
                this.grandTotal=0;
                console.log(this.product)
                this.product.forEach((a:any)=>{
                  console.log(a.price);
                  
                  this.grandTotal+=parseInt(a.price);
                 })},
              error: (val) => { console.log(val) },
        
            }
            )}
            
            this.router.navigate(['/cart'])
            alert("product removed!");
         },
        error: (val) => { console.log("deletion failed") },
  
      })
    
    }}
