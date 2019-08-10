import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  number:number=0;  
  getUpdatedvalue($event) {  
    console.log($event);  
    this.number = $event;  
}  
}

