import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'bank-account',
        data: { pageTitle: 'mySampleApplicationApp.bankAccount.home.title' },
        loadChildren: () => import('./bank-account/bank-account.module').then(m => m.BankAccountModule),
      },
      {
        path: 'label',
        data: { pageTitle: 'mySampleApplicationApp.label.home.title' },
        loadChildren: () => import('./label/label.module').then(m => m.LabelModule),
      },
      {
        path: 'operation',
        data: { pageTitle: 'mySampleApplicationApp.operation.home.title' },
        loadChildren: () => import('./operation/operation.module').then(m => m.OperationModule),
      },
      /* myApplication-needle-add-entity-route - myApplication will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
