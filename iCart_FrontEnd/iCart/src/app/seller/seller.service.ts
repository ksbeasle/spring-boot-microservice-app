import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Seller } from './Seller'
import { Observable } from 'rxjs';
import { Deal } from './Deal';
@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private http:HttpClient) { }

registerSeller(data:any):Observable<any>{
  console.log("Data: " + data);
  return <Observable<any>> this.http.post("http://localhost:8080/registerSeller", data);
}

  getSellerDetails(data):Observable<Seller>{
    console.log("Data: " + data);
    return this.http.get<Seller>("http://localhost:8080/sellerDetails/"+data);
  }

  getSellerDeals():Observable<Deal[]>{
    return this.http.get<Deal[]>("http://localhost:8080/deals")
  }
}
