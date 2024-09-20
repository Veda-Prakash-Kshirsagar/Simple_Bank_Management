import { Component } from '@angular/core';
import { Account } from '../account';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrl: './withdraw.component.css'
})
export class WithdrawComponent {

  account:Account = new Account();
  id!:number;
  amount!:number;
  withdrawed:boolean=false;
  updateForm!: FormGroup;

  constructor(private accountservice:AccountService,private router:ActivatedRoute,
              private route:Router, private fb: FormBuilder){}

  ngOnInit(): void {

     this.id = +this.router.snapshot.paramMap.get('id')!;
     console.log('Retrieved ID:', this.id);

    this.accountservice.getAccountById(this.id).subscribe((data) => {
      this.account = data;

    });

    this.updateForm = this.fb.group({
      amount: ['']
    });

  }

  onWithdraw(): void {

    const amount = this.updateForm.get('amount')?.value;
    //this.amount = +this.router.snapshot.paramMap.get('amount')! || this.account.amount;

    if(amount && this.id){

      this.accountservice.withdrawAmount(this.id, amount).subscribe((data) => {
        this.account=data;
        console.log(data);
  
        console.log('Withdraw successful:', data);
        
        this.withdrawed = true;
        console.log(this.withdrawed);
        
        setTimeout(() => {
          //this.goToAccountList();
          this.route.navigate(['/accounts']);
  
        }, 1000);
      });

    }


  }
}


