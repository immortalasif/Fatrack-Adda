import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  
  userDetails:any;
  registerForm!: FormGroup;
  submitted!: boolean;
  
  constructor(private formBuilder: FormBuilder,private service:RegistrationServiceService,private router: Router) { }


  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      password: ['', Validators.required],
      
    });
  }

  login(){
    // console.log(this.registerForm.value);
     
    this.service.login(this.registerForm.value).subscribe({
       
       next: (val) => { 
        console.log(val);
        this.userDetails = val 
        if(this.registerForm.value.email == this.userDetails.email &&
          this.registerForm.value.password ==
         this.userDetails.password){
           
           alert("logged in successfully!! ");
           this.router.navigate(['/'])
           this.submitted=true;
          //  var obj = { "message": taskMessage, "name": taskName }
          //   var val = localStorage.setItem("task", obj);
          //sessionStorage.setItem('userId',val.id);
           sessionStorage.setItem('loggedname',val.id );
         }
      },
       error: (val) => { 
        alert("invalid details!! ");
        this.router.navigate(['login']);
        this.registerForm = this.formBuilder.group({
          email: ['', [Validators.required,Validators.email]],
          password: ['', Validators.required],
        });
      
      },
       
      },
    )

  
  }
 
  }



