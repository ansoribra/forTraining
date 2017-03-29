import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule } from '@angular/router';
import {MdIconModule,MdIconRegistry} from '@angular2-material/icon';
import {MdCardModule} from '@angular2-material/card';
import {MdButtonModule} from '@angular2-material/button';
import {MdInputModule} from '@angular2-material/input';
import {Ng2PageScrollModule} from 'ng2-page-scroll';

import { AppComponent } from './app.component';
import { MidrouteComponent } from './component/midroute/midroute.component';
import {AuthGuard} from "../app/common/auth.guard";
import { AUTH_PROVIDERS } from 'angular2-jwt';
import {HomeComponent} from "./component/home/home.component";
import {HeaderComponent} from "./component/header/header.component";
import {TrackScrollDirective} from "./component/home/directives/trackscroll.directive";
import {SearchpopupComponent} from "./component/searchpopup/searchpopup.component";
import {SearchPipe} from "./pipe/search.pipe";
import {SeemoreComponent} from "./component/seemore/seemore.component";
import {SidecategoryComponent} from "./component/sidecategory/sidecategory.component";
import {PagingComponent} from "./component/paging/paging.component";
import {DetailprodComponent} from "./component/detailprod/detailprod.component";
import {SearchresultComponent} from "./component/searchresult/searchresult.component";
import {LoginComponent} from "./component/login/login.component";
import {SellerareaComponent} from "./component/sellerarea/sellerarea.component";
import {UserService} from "./service/user.service";
import {CategoryService} from "./service/category.service";
import {enableProdMode} from '@angular/core';

enableProdMode();

const APP_ROUTES:Routes = [
  { path: '', component: MidrouteComponent},
  { path: 'home', component: MidrouteComponent },
  { path: 'seemore/:id',component:SeemoreComponent },
  { path: 'searchresult/:name',component:SearchresultComponent },
  { path: 'sellerarea',component:SellerareaComponent, canActivate: [AuthGuard] },
  { path: 'detailprod/:id', component: DetailprodComponent }];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    TrackScrollDirective,
    SearchpopupComponent,
    SearchPipe,
    SeemoreComponent,
    MidrouteComponent,
    SidecategoryComponent,
    PagingComponent,
    DetailprodComponent,
    SearchresultComponent,
    LoginComponent,
    SellerareaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MdCardModule,
    MdButtonModule,
    MdIconModule,
    MdInputModule,
    Ng2PageScrollModule,
    RouterModule.forRoot(APP_ROUTES)
  ],
  exports: [RouterModule],
  providers: [AuthGuard, MdIconRegistry, UserService, CategoryService],
  bootstrap: [AppComponent]
})

export class AppModule { }
