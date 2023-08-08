import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';
@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit {
  user1:boolean=true;
  // product: Product|undefined;
  loggeduser:any;
  product: any;
  productIdFromRoute:any;
  constructor(
    private service: RegistrationServiceService,
    private route: ActivatedRoute,
    private router: Router
    //  private cartService: CartService
  
  ) { }

  ngOnInit() {
    
    const routeParams = this.route.snapshot.paramMap;
    this.productIdFromRoute = Number(routeParams.get('productId'));
console.log(this.productIdFromRoute);
    // Find the product that correspond with the id provided in route.
    this.service.getProductsById(this.productIdFromRoute).subscribe({

      next: (val) => { this.product = val },
      error: (val) => { console.log(val) },

    }
    )
    //  products.find(product => product.id === productIdFromRoute);
   // console.log(val);
    this.loggeduser=sessionStorage.getItem("loggedname");
    if(this.loggeduser != null){
            this.user1=true;
           
    }
    else{
      alert("please login! ");
      this.router.navigate(['/login'])
           this.user1=false;
    }
  }

  addToCart(productIdSelected: any) {
    this.service.addToCart( this.loggeduser,this.productIdFromRoute).subscribe({

      next: (val) => {  },
      error: (val) => { console.log(val) },

    }
    )
    alert('Your product has been added to the cart!');
    this.router.navigate(['/cart'])
  }
}