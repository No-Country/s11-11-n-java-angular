import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root',
})
export class NotifyService {
  constructor(public toastrSvc: ToastrService) {}

  showSuccess(message: string, title: string) {
    this.toastrSvc.success(message, title);
  }

  showError(message: string, title: string) {
    this.toastrSvc.error(message, title);
  }
}
