import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBankAccount } from '../bank-account.model';

@Component({
  selector: 'my-bank-account-detail',
  templateUrl: './bank-account-detail.component.html',
})
export class BankAccountDetailComponent implements OnInit {
  bankAccount: IBankAccount | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ bankAccount }) => {
      this.bankAccount = bankAccount;
    });
  }

  previousState(): void {
    window.history.back();
  }
}
