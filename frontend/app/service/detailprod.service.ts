import { Injectable }     from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import { environment } from "../../environments/environment"
import 'rxjs/Rx';
import {DetailprodComponent} from '../component/detailprod/detailprod.component';
import {Home} from '../home';
import { ActivatedRoute,Router } from '@angular/router';

@Injectable()
export class DetailprodService {
    private id:string;
    constructor (private http: Http, private route: ActivatedRoute) {
        this.route.params.subscribe(params => {let   id = params['id'];this.id = id;});
    }


    getDetail(){
        return this.http.get(environment.dataserve+'/product/'+this.id)
                    .map(res=> res.json());
    }

}
