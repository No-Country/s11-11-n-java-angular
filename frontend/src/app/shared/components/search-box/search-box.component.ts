import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'shared-search-box',
  template: `
    <div class="container-search">
      <label class="container-icon" for="search-box">
        <input
          type="text"
          class="search-box"
          id="search-box"
          placeholder="Bluey The Game"
          (keyup.enter)="search()"
          #searchInput
        />
        <img
          class="search-img"
          src="assets/images/menu-icons/icon-search-box.svg"
          alt="search icon"
        />
      </label>
    </div>
  `,
  styles: [
    `
      .container-search {
        position: absolute;
        top: 115px;
        left: 50%;
        transform: translateX(-50%);
        box-shadow: 10px 4px 4px rgba(0, 0, 0, 0.25);

        width: 733.971px;
        height: 67.015px;
        flex-shrink: 0;
        border-radius: 86.162px;
        background: #e4e4e4;

        border-radius: 86.162px;
        border: 2px solid #c7c7c7;
        z-index: 1;

        .search-box {
          width: 100%;
          height: 100%;
          background: transparent;
          border: none;
          outline: none;
          color: #4b4b4b;
          font-family: var(--f-1);
          font-size: 28.721px;
          font-weight: 400;
          padding: 0 2rem;
        }

        .container-icon {
          position: relative;
        }

        .search-img {
          position: absolute;
          top: 50%;
          right: 2rem;
          transform: translateY(-55%);
          cursor: pointer;
        }
      }

      @media (max-width: 768px) {
        .container-search {
          width: 85%;
          height: 50px;

          .search-box {
            font-size: 1.2rem;
          }

          .search-img {
            width: 30px;
            height: 30px;
          }
        }
      }
    `,
  ],
})
export class SearchBoxComponent {
  @ViewChild('searchInput')
  public searcher!: ElementRef<HTMLInputElement>;

  search() {
    const string = this.searcher.nativeElement.value;
    console.log(string);

    this.searcher.nativeElement.value = '';
  }
}
