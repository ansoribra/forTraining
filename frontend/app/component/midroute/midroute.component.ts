import { Component } from '@angular/core';

@Component({
  selector: 'app-midroute',
  templateUrl: './midroute.component.html',
  styleUrls: ['./midroute.component.css']
})
export class MidrouteComponent{
  searchValue:string;
  visibility:string='visible';
  searchCalled(message:string):void{
    this.searchValue=message;
  }

}
