import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  userDetails:any;
  registerForm!: FormGroup;
  submitted!: boolean;
  
  constructor(private formBuilder: FormBuilder,private service:RegistrationServiceService,
    private router: Router) { }


  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      adminEmail: ['', [Validators.required,Validators.email]],
      adminPassword: ['', Validators.required],
      
    });
  }

  login(){
 this.service.adminlogin(this.registerForm.value).subscribe({
  next: (val) => { 
    console.log(val);
    this.userDetails = val 
    if(this.registerForm.value.adminEmail == this.userDetails.adminEmail &&
      this.registerForm.value.adminPassword ==
     this.userDetails.adminPassword){
       
       alert("logged in successfully!! ");
       this.router.navigate(['/seller'])
       this.submitted=true;
      //  var obj = { "message": taskMessage, "name": taskName }
      //   var val = localStorage.setItem("task", obj);
      //sessionStorage.setItem('userId',val.id);
      sessionStorage.setItem('loggedname',val.id );
     }
  },
   error: (val) => { 
    alert("invalid details!! ");
    this.router.navigate(['adimlogin']);
    this.registerForm = this.formBuilder.group({
      adminEmail: ['', [Validators.required,Validators.email]],
      adminPassword: ['', Validators.required],
      
    });
  
  },
   
  },
)

  }}