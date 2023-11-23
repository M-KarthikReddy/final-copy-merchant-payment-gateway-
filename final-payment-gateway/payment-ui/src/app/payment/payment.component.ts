import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.scss'
})
export class PaymentComponent {
  merchantId: any;
  amount: any;
  currency: any;

  paymentStatus:any;

  constructor(private http: HttpClient) { }

  makePayment() {
    this.http.post('http://localhost:9092/requestPayment', {
      merchantId: this.merchantId,
      amount: this.amount,
      currency: this.currency,
  
    }).subscribe((response: any) => {
      if (response.message !== "merchant not registered!!! please register before procee..") {
        alert(response.message);
        this.paymentStatus=response
      } else {
        alert("Payment failled: "+response.message);
       
      }
    })
  }
}
