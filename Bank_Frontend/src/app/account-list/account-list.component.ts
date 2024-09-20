import { Component } from '@angular/core';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrl: './account-list.component.css'
})
export class AccountListComponent {

  accounts:Account[]=[]
deleted: any;

  constructor(private accountservice:AccountService, private router:Router, private http:HttpClient){}

  ngOnInit(){

    this.getAccounts();
  }

  getAccounts(){

    this.accountservice.getAllAccounts().subscribe(data=>{
        this.accounts=data;
    })

  }

  deposit(id:number){

    this.router.navigate(['/deposit',id]);
    console.log('Retrieved ID: list', id);


  }
  withdraw(id:number){

    this.router.navigate(['/withdraw',id]);
    console.log('Retrieved ID: list', id);

  }


  del(id:number){

    let deleted : Boolean = false;
    
    this.accountservice.deleteAccount(id).subscribe(data=>{
      console.log(data);
      //this.getAccounts
      deleted=true;
      setTimeout(() => {
        this.getAccounts();
      }, 2000)
    });
  }
}
