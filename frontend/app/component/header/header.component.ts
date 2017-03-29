import { Component,Output,EventEmitter } from '@angular/core';

@Component({
    selector:'header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css','./header2.component.css'],
})
export class HeaderComponent {
    term:string;
    navbarShrink : string = '';
    navbarShrinkSecond : string = '';
    icoQyubixShrink : string = '';
    spaceShrink : string='';
    buttonBsShrink : string='';
    buttonAsShrink : string='';
    searchFieldShrink : string='';
    searchButtonShrink : string='';

    onScrolled(yPos : number) {
        this.navbarShrink = yPos ? "navbar-shrink" : "";
        this.navbarShrinkSecond = yPos ? "navbar-shrink-second" : "";
        this.icoQyubixShrink = yPos ? "ico-qyubix-shrink" : "";
        this.spaceShrink = yPos ? "space-shrink" : "";
        this.buttonBsShrink = yPos ? "button-bs-shrink" : "";
        this.buttonAsShrink = yPos ? "button-as-shrink" : "";
        this.searchFieldShrink = yPos ? "search-field-shrink" : "";
        this.searchButtonShrink = yPos ? "search-button-shrink" : "";
    }

    refresh(){
        window.location.reload();
    }

    @Output() showMenu = new EventEmitter();
    @Output() hideMenu = new EventEmitter();

    showmenu(){
        this.showMenu.emit(null);
    }

    hidemenu(){
        this.hideMenu.emit(null);
    }

    @Output() showLogin = new EventEmitter();

    showlogin(){
        this.showLogin.emit(null);
    }

    @Output() searchemit: EventEmitter<string> = new EventEmitter<string>();
    onChange(){
        this.searchemit.emit(this.term);
        if (this.term===''){
            this.hidemenu();
        }else {
            this.showmenu()
        }
    }
}