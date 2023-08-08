import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup ,Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';

@Component({
  selector: 'app-sellerproducts',
  templateUrl: './sellerproducts.component.html',
  styleUrls: ['./sellerproducts.component.css']
})
export class SellerproductsComponent implements OnInit {
  registerForm!: FormGroup;
  updateFormView: boolean = false;
  productDetails: any
  username:any;
  id:any;
  constructor(private service: RegistrationServiceService, private formBuilder: FormBuilder,private router: Router) { }

  ngOnInit(): void {
    this.service.getProducts().subscribe({

      next: (val) => { this.productDetails = val },
      error: (val) => { console.log(val) },

    }
    )
    this.username=sessionStorage.getItem("loggedname");
    if(this.username < 100){
      
      sessionStorage.clear();
      this.username=null;
      alert("you are logged out! DONOT ACT SMART!")
      this.router.navigate(['/adimlogin']);
     }
    this.registerForm = this.formBuilder.group({
      productName: ['', [Validators.required]],
      image: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      
    });
  }
  logout(){
    
    // if(this.username != null){
    //   this.router.navigate(['/login']);
    //  }
    
    sessionStorage.clear();
    alert("logged out successfully"); 
    this.router.navigate(['/adimlogin']);   
  }

    delete(id: number) {

      this.service.delete(id).subscribe({
        next: (val) => { 
          console.log("inside next") ;
        this.service.getProducts().subscribe({

          next: (val) => { this.productDetails = val },
          error: (val) => { console.log(val) },
    
        }
        )
        alert("successfully deleted the successfully!");
        },
        error: (val) => { console.log("inside error") },
  
      })
      
      
    }
    //registerProductPage
    addProduct(){
       this.updateFormView = true;
       this.registerForm = this.formBuilder.group({
        productName: ['', [Validators.required]],
        image: ['', Validators.required],
        description: ['', Validators.required],
        price: ['', Validators.required],
        
      });

       
    }
    apply(){
       //registerProduct
       this.service.registerProduct(this.registerForm.value).subscribe({
        next: (val) => { 
          console.log("inside next") ;
          alert("successfully added the product successfully!");
        this.updateFormView=false;
        this.service.getProducts().subscribe({

          next: (val) => { this.productDetails = val },
          error: (val) => { console.log(val) },
    
        }
        )
        
        },
        error: (val) => { console.log("inside error") },
  
      })
      
      

    //   this.service.registerProduct(this.registerForm.value).subscribe({
    //     next(value) {
          
    //     }
    //  })
    //  alert("product added to the list");
    //  this.updateFormView=false;
    }
  }
