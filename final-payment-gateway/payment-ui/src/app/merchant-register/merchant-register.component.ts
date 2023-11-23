import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-merchant-register',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './merchant-register.component.html',
  styleUrl: './merchant-register.component.scss'
})
export class MerchantRegisterComponent {
  merchantName: any;
  merchantEmail: any;
  merchantBusinesstype: any;
  merchantAddress: any;
  merchantPhone: any;

  constructor(private http: HttpClient) { }

  registerMerchant() {
    this.http.post('http://localhost:9092/Register', {
      merchantName: this.merchantName,
      merchantEmail: this.merchantEmail,
      merchantBusinesstype: this.merchantBusinesstype,
      merchantAddress: this.merchantAddress,
      merchantPhone: this.merchantPhone
    }).subscribe((response: any) => {
      if (response.message === "created sucessfully!!!") {
        alert(response.message);
      } else {
        alert(response.message);
      }
    })
  }
}
