import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Account } from '../account';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrl: './create-account.component.css'
})
export class CreateAccountComponent {

  account:Account = new Account();

  constructor(private accountservice:AccountService,private router:Router){}

  created:boolean=false;

  onSubmit(){
    this.saveAccount();
  }

  saveAccount(){
    
    this.accountservice.createAccount(this.account).subscribe(data=>{

      console.log(data);
      this.created=true;
      
      setTimeout(() => {
        this.goToAccountList();
      }, 2000);
    })
  }

  //go back to the account list once new user has been added
  //use Router class object from router
  goToAccountList(){

    this.router.navigate(['/accounts']);

  }
}
