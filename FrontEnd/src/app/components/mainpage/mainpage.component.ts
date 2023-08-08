import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  searchKey:string="";
  updateFormView: boolean = false;
  productDetails: any
  constructor(private service: RegistrationServiceService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  
    this.service.getProducts().subscribe({

      next: (val) => { this.productDetails = val },
      error: (val) => { console.log(val) },

    }
    )
 
  }


}
