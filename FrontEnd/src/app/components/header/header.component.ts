import { Component, OnInit } from '@angular/core';
import { RegistrationServiceService } from 'src/app/service/registration-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
 username:any="user";
 
 flag:boolean=false;
 public totalItem: number =0;
  public searchTerm !:string;
  constructor(private service: RegistrationServiceService,private router: Router) { }

  ngOnInit(): void 
  {
     this.username=sessionStorage.getItem("loggedname");
     if(this.username != null){
      this.flag=true;
     }
  }
  ngDoCheck(){
    if(this.username != null){
      this.flag=true;
     }
  }
  
logout()
{
  sessionStorage.clear();
  if(this.username != null){
    this.flag=true;
   }
  this.username=sessionStorage.getItem("loggedname");
  alert("logged out successfully"); 
  this.router.navigate(['/login']);
}

}
