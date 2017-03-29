import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {
  loading:any;
  transform(service: any[], term: any): any {
    if (!service || !service.length) {
      return [];
    }else {
      this.loading = document.getElementById("loader2");
      this.loading.style.display = "none";
    }
    if (term === undefined) return null;
    return service.filter(service => service.product_name.toLowerCase().includes(term.toLowerCase()))
  }
}
