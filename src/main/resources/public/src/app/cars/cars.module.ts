import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarsComponent } from './cars.component';
import { FormsModule } from '@angular/forms';
import { RouterModule} from '@angular/router';

import { CarService } from './car.service';
import { CarListComponent } from './cars-list.component';
import { CarDetailComponent } from './car-detail.component';
import { CarDetailGuard } from './car-guard.service';
import { CarEditComponent } from './car-edit.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild([
      { path: 'cars', component: CarListComponent },
      { path: 'car/:id',
          component: CarDetailComponent,
          canActivate: [ CarDetailGuard ]
      },
      { path: 'car-edit/:id', component: CarEditComponent } // todo add guard
    ])
  ],
  declarations: [
      CarsComponent,
      CarListComponent,
      CarDetailComponent,
      CarEditComponent
  ],
  providers: [
      CarService,
      CarDetailGuard
  ]
})
export class CarsModule { }
