import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SellerComponent } from './seller/seller.component';
import { HttpClientModule } from '@angular/common/http';
import { SellerService } from './seller/seller.service';

@NgModule({
  declarations: [
    AppComponent,
    SellerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [SellerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
