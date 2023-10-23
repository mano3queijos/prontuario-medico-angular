import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';




@NgModule({
  
  declarations: [
    ErrorDialogComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [ErrorDialogComponent]
})
export class SharedModule { }
