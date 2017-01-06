import { Component, OnInit }  from '@angular/core';

import { ICar } from './car';
import { CarService } from "./car.service";

@Component({
    templateUrl: './cars-list.component.html',
    styleUrls: ['./cars-list.component.css']
})

export class CarListComponent implements OnInit {

    pageTitle: string = 'Car List';
    errorMessage: string;
    cars: ICar[];

    constructor(private _carService: CarService) {
    }

    ngOnInit(): void {
        this._carService.getCars()
            .subscribe(cars => this.cars = cars,
                error => this.errorMessage = <any>error);
    }


    deleteCar(car: ICar): void {
        let carPos = this.cars.map(function(x) {return x.id  }).indexOf(car.id);
        this._carService.deleteCar(car.id)
            .subscribe(car => this.updateUi(carPos),
            error => this.errorMessage = <any>error);
    }

    // todo purposely deleting bad car from ui, changed in e2e tests
    updateUi(idx: number): void {
        //let index = this.cars.indexOf(car);
        //console.log(`Index: `, index);
        this.cars.splice(idx, 1);
    }
}
