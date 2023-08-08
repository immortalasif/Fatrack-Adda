import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';
@Component({
  selector: 'app-checkoutpage',
  templateUrl: './checkoutpage.component.html',
  styleUrls: ['./checkoutpage.component.css']
})
export class CheckoutpageComponent implements OnInit {
  grandTotal : number=0 ;
productDetails:any;
  registerForm!: FormGroup;
  submitted!: boolean;
  loggeduser:any;
  public product:any =[];
  placed:boolean=false;
  constructor(private formBuilder: FormBuilder, private router: Router,private service: RegistrationServiceService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      name: ['', [Validators.required]],
      address: ['', Validators.required],
      phone: ['', [Validators.required]],
      pincode: ['', Validators.required],
      
    });
    
    this.loggeduser=sessionStorage.getItem("loggedname");
   // this.loggedId =sessionStorage.getItem("userId");
   
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
        else{
          alert("please login first!");
          this.router.navigate(['/login'])
        }
    }
  cancel(){
    this.router.navigate(['/cart']);
  }
  
  apply(){
   
    this.service.deleteAllCartProducts(this.loggeduser).subscribe({
      next: (val) => { 
        console.log("All items deleted");
       
        alert("order placed successfully! you will recieve a message shortly!")
        this.submitted=true;
        //this.router.navigate(['/'])
           },
    error: (val) => { console.log("deletion failed") },
    })
  }
}
