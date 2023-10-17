import { Component } from '@angular/core';

@Component({
  selector: 'shared-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent {
  footerLinks = [
    {
      title: 'Productos',
      links: [
        {
          text: 'Videojuegos',
          url: '/games',
        },
        {
          text: 'Accesorios',
          url: '/accesories',
        },
        {
          text: 'Nuevo',
          url: '/new',
        },
      ],
    },
    {
      title: 'Sobre Nosotros',
      links: [
        {
          text: 'Misión',
          url: '/mission',
        },
        {
          text: 'Visión',
          url: '/vision',
        },
        {
          text: 'Contáctanos',
          url: '/contact',
        },
      ],
    },
    {
      title: 'Términos y Condiciones',
      links: [
        {
          text: 'Política de Privacidad',
          url: '/privacy',
        },
        {
          text: 'Política de Devolución',
          url: '/return',
        },
        {
          text: 'Política de Envío',
          url: '/shipping',
        },
      ],
    },
  ];
}
