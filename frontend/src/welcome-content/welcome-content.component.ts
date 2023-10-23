import { Component, EventEmitter, Output, Input } from '@angular/core';


@Component({
  selector: 'app-welcome-content',
  templateUrl: './welcome-content.component.html',
  styleUrls: ['./welcome-content.component.css']
})
export class WelcomeContentComponent {
    @Output() loginEvent = new EventEmitter();
  @Output() logoutEvent = new EventEmitter();

}

