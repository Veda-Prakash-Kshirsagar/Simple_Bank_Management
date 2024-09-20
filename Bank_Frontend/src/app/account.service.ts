import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {


  constructor(private httpclient:HttpClient) {}
   
  private baseUrl: string = "http://localhost:8080/accounts";




  //Observable is important as it communicates with http clients.
  getAllAccounts():Observable<Account[]>{

    return this.httpclient.get<Account[]>(`${this.baseUrl}/allAccounts`);
    }

  createAccount(account:Account):Observable<Account>{

     return this.httpclient.post<Account>(`${this.baseUrl}/create`,account)

   }

   getAccountById(id:number):Observable<Account>{

      return this.httpclient.get<Account>(`${this.baseUrl}/${id}`);

   } 
  

   depositAmount(id:number,amount:number):Observable<Account>{

    const body = { amount };
    return this.httpclient.put<Account>(`${this.baseUrl}/deposit/${id}`, body, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  });

  }


  withdrawAmount(id:number,amount:number):Observable<Account>{

    const body = { amount };
    return this.httpclient.put<Account>(`${this.baseUrl}/withdraw/${id}`, body, {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  });

  }



   deleteAccount(id:Number):Observable<Account>{

     return this.httpclient.delete<Account>(`${this.baseUrl}/delete/${id}`);

   }

 
}
