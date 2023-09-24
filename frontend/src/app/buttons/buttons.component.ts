import { Component, EventEmitter, Output, Input } from '@angular/core';

@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})
export class ButtonsComponent {
  @Output() loginEvent = new EventEmitter();
  @Output() logoutEvent = new EventEmitter();
  @Input() accessButtonVisible: boolean = true;

  onAccessClick(): void {
    this.accessButtonVisible = !this.accessButtonVisible;
  
        this.loginEvent.emit();// evento do login

  }


}

// emanuel esteve aqui