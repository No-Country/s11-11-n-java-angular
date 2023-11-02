import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/core/products/services/product.service';
import { NotifyService } from 'src/app/services/notify.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss'],
})
export class CreateProductComponent {
  img =
    'https://im.ziffdavisinternational.com/ign_es/screenshot/default/60225-metal-gear-solid-3-subsistence-playstation-2_umwf.jpg';

  addProductForm: FormGroup = new FormGroup({
    img: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required]),
    stock: new FormControl('', [Validators.required]),
  });

  constructor(
    private _productSvc: ProductService,
    private _notifySvc: NotifyService,
    private _router: Router
  ) {}

  onCreateProdct() {
    if (this.addProductForm.invalid) {
      this._notifySvc.showError('Error', 'Por favor, rellene todos los campos');
      return;
    }

    const product = this.addProductForm.value;

    this._productSvc.createProduct(product).subscribe({
      next: (res) => {
        console.log(res);
        this._notifySvc.showSuccess(
          'El producto se ha creado correctamente',
          'Producto creado'
        );
      },
      error: (err) => {
        console.log(err);
        this._notifySvc.showError(
          'Ha ocurrido un error al crear el producto',
          'Error'
        );
      },
    });

    this._router.navigate(['/']);
  }
}
