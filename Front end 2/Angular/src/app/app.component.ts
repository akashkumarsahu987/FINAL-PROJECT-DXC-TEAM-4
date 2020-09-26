import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, OnDestroy} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { RegistrationService } from './service/registration.service';
//import { CommentService } from './service/comment.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy{
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );


  mobileQuery: MediaQueryList;
  title = 'book-Application';
  private _mobileQueryListener: () => void;

  menuItems = ['search', 'categories','comment','viewCom'];


  constructor(private Router:Router, changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private breakpointObserver: BreakpointObserver, public regser: RegistrationService){
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }
  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }
  ngOnInit(): void {
    this.Router.navigate(['home']);
  }
  async login(){
  
    console.log(this.regser.currentUser);
    this.Router.navigate(['/login']);
  }
  async logout() {
  
    this.regser.logout();
    this.Router.navigate(['/login']);
    
  }
}
