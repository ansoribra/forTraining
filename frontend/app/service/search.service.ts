import { Injectable }     from '@angular/core';
import { Http, Response } from '@angular/http';
import { Home }           from '../component/home/home';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/Rx';
import { environment } from "../../environments/environment"

@Injectable()
export class SearchService {
    constructor (private http: Http) {}

    private Url = environment.dataserve+'/product?size=2000';  // URL to web API

    getService (){
        return this.http.get(this.Url)
            .map(res => <Home[]> res.json())
            .catch(this.handleError);
    }
    private extractData(res: Response) {
        let body = res.json();
        return body.data || { };
    }
    private handleError (error: any) {
        // In a real world app, we might use a remote logging infrastructure
        // We'd also dig deeper into the error to get a better message
        let errMsg = (error.message) ? error.message :
            error.status ? `${error.status} - ${error.statusText}` : 'Server error';
        console.error(errMsg); // log to console instead
        return Observable.throw(errMsg);
    }
}
