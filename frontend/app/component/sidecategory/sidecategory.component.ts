import { Component} from '@angular/core';

@Component({
  selector: 'app-sidecategory',
  templateUrl: './sidecategory.component.html',
  styleUrls: ['./sidecategory.component.css']
})

export class SidecategoryComponent {
  catgorsidfixShrink : string='';

  onScrolled(yPos : number) {
    this.catgorsidfixShrink = yPos ? "catgorsidfixShrink" : "";
  }
}
