import { Component } from '@angular/core';
import { Account } from '../account';
import { AccountService } from '../account.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrl: './deposit.component.css'
})
export class DepositComponent {

  account:Account = new Account();
  id!:number;
  amount!:number;
  deposited:boolean=false;
  updateForm!: FormGroup;

  constructor(private accountservice:AccountService,private router:ActivatedRoute,
              private route:Router, private fb: FormBuilder){}

  ngOnInit(): void {

     this.id = +this.router.snapshot.paramMap.get('id')!;
     console.log('Retrieved ID:', this.id);

    this.accountservice.getAccountById(this.id).subscribe((data) => {
      this.account = data;

    });

    // this.accountservice.getAllAccount(this.id).subscribe((data) => {
    //   this.account = data;
    //   console.log(this.account);
      

    // });

    this.updateForm = this.fb.group({
      amount: ['']
    });

  }

  onDeposit(): void {

    const amount = this.updateForm.get('amount')?.value;
    //this.amount = +this.router.snapshot.paramMap.get('amount')! || this.account.amount;

    if(amount && this.id){

      this.accountservice.depositAmount(this.id, amount).subscribe((data) => {
        this.account=data;
        console.log(data);
  
        console.log('Deposit successful:', data);
        
        this.deposited = true;
        console.log(this.deposited);
        
        setTimeout(() => {
          //this.goToAccountList();
          this.route.navigate(['/accounts']);
  
        }, 1000);
      });

    }
  }

  // goToAccountList():void{

  //   this.route.navigate(['/accounts']);

  // }

  
}
