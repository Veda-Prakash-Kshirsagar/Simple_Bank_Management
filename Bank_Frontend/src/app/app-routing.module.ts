import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';



const routes: Routes = [
  {path:'accounts',component:AccountListComponent},
  {path:'create',component:CreateAccountComponent},
  {path:'deposit/:id',component:DepositComponent},
  {path:'withdraw/:id',component:WithdrawComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
