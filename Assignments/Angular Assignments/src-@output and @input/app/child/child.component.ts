import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  @Input() 
  number:number=0;  
  @Output()
   change: EventEmitter<number> = new EventEmitter<number>(); 
  constructor() { }
  ngOnInit() {
  }
  updateValue(event:any) {  
    this.number=event.target.value;
  this.change.emit(this.number);  
}  
}
