import { Routes } from '@angular/router';
import { MerchantRegisterComponent } from './merchant-register/merchant-register.component';
import { PaymentStatusComponent } from './payment-status/payment-status.component';
import { PaymentComponent } from './payment/payment.component';

export const routes: Routes = [
    { path: 'payment', component: PaymentComponent },
    { path: 'payment-status', component: PaymentStatusComponent },
    { path: 'register-merchant', component: MerchantRegisterComponent }
];
