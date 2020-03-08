import { Component, OnInit } from '@angular/core';
import { Seller } from './Seller';
import { SellerService } from './seller.service';
import { ActivatedRoute } from '../../../node_modules/@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {



  seller:Seller;
  sellerForm:FormGroup;
  successMessage:String;
  errorMessage:String;
  registerNewSeller:Boolean = false;
  showDetailsFlag:Boolean = false;
  idToFind:string;
  validSellerDetails:Boolean = false;

  newSellerFlag(){
    if(this.registerNewSeller == false){
      this.registerNewSeller = true;
    }else{
      this.registerNewSeller = false;
    }
  }

  showDetails(){
    if(this.showDetailsFlag == false){
      this.showDetailsFlag= true;
    }else{
      this.showDetailsFlag = false;
    }
  }

  registerSeller(){
    this.successMessage = null;
    this.errorMessage = null;

    console.log(this.sellerForm.value)

    this.sellerService.registerSeller(this.sellerForm.value)
    .subscribe(
      (success) => {this.successMessage = success.message},
      (error) => {this.errorMessage = error.message}
    )

  }

  flag(){
    this.validSellerDetails = true
  }

  sellerId:String = "";
  S:Seller
  getSellerDetails(emailId){
    this.flag()
    this.sellerId = emailId
   this.activatedRoute.paramMap.subscribe(
     params => this.sellerId = params.get('emailId')
   );
   this.sellerService.getSellerDetails(emailId).subscribe(
     x => {this.S = x; console.log(this.S)}
   )
   
  }

  getSellerDeals(){
    
  }



  constructor(private sellerService:SellerService, private activatedRoute:ActivatedRoute, private formBuilder:FormBuilder) { }
  ngOnInit() {
    this.sellerForm = this.formBuilder.group({
      name:['',Validators.required],
      password:['',Validators.required],
      phone:['', Validators.required],
      address:['', Validators.required],
      email_id:['', Validators.required]
    })

  }

}
