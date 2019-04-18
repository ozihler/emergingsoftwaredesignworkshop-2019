import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {routes} from "./routes";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DragDropModule} from "primeng/primeng";
import {LibraryComponent} from './library/library.component';

@NgModule({
  declarations: [
    AppComponent,
    LibraryComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    DragDropModule
  ],
  providers: [HttpClient,
    {provide: "windowObject", useValue: window}],
  bootstrap: [AppComponent]
})
export class AppModule { //
}
