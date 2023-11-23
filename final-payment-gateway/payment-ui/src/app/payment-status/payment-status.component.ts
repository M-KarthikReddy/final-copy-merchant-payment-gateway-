import { Component, CUSTOM_ELEMENTS_SCHEMA, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-payment-status',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  templateUrl: './payment-status.component.html',
  styleUrl: './payment-status.component.scss'
})
export class PaymentStatusComponent implements OnInit {
  merchantId = '';
  paymentResponse:any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  trackStatus() {
    this.http.get('http://localhost:9092/paymentStatus/' + this.merchantId).subscribe((response: any) => {
     
    if (response.length > 0) {
        alert("Transaction success!");
        this.merchantId = '';
        this.paymentResponse=response[0]
      } else {
        alert("Transaction failed!");
      }
    })
  }
}
