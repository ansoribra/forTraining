import { Injectable }     from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import 'rxjs/Rx';
import { environment } from "../../environments/environment"
import {Home} from "../home";

@Injectable()
export class UserService {
    constructor (private http: Http) {

    }

    private page=0;

    private userUrl = environment.dataserve+'/user';

    private headers1 = new Headers({'Content-Type': 'application/json', 'Authorization': 'Bearer '+localStorage.getItem("id_token")});

    getUser (){
        return this.http.get(this.userUrl,{headers: this.headers1})
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
