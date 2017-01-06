import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';


import { ICar } from './car';
import { Car } from './car';
import { CarService } from "./car.service";

import { Subscription } from "rxjs";
import { NgForm } from "@angular/forms";


@Component({
    templateUrl: './car-edit.component.html'
})

export class CarEditComponent implements OnInit, OnDestroy {

    private sub: Subscription;
    car: ICar = new Car();
    errorMessage: string;
    selectType = ["Select Type", "SUV", "CONVERTIBLE", "COUPE", "PICKUP", "SEDAN", "HATCHBACK"];
    selectBrand = ["Select Brand", "AUDI","BMV","BENTLEY","HONDA","OPEL","MAZDA"];
    selectEngineType = ["Select Engine Type", "DIESEL", "PETROL"];
    hasTypeError: boolean = false;
    hasBrandError: boolean = false;
    hasEngineTypeError: Boolean = false;

    constructor(private _route: ActivatedRoute,
                private _router: Router,
                private _carService: CarService) {

    }

    ngOnInit(): void {
        this.sub = this._route.params.subscribe(
            params => {
                let id = +params['id'];
                this.getCar(id);
            }
        )
    }

    getCar(id: number) {
        this._carService.getCar(id).subscribe(
            car => this.car = car,
            error => this.errorMessage = <any>error
        );

        console.log(`Car getCar: , ${this.car}`);
    }

    // todo add more generalise method for validation

    validateType(value: string): void {
        this.hasTypeError = value === 'Select Type';
    }

    validateBrand(value: string): void {
        this.hasBrandError = value === 'Select Brand';
    }

    validateEngineType(value: string): void {
        this.hasEngineTypeError = value === 'Select Engine Type';
    }

    submitCar(form: NgForm) {
        console.log(form.value);
        // validating form
        // todo add brand and modelType
/*        this.validateType(this.car.modelType);
        this.validateBrand(this.car.brand);
        if ( this.hasTypeError || this.hasBrandError) return;*/

        console.log('Sending car ' + this.car);

        this._carService.updateCar(this.car)
            .subscribe(
                data => console.log('success', data),
                err => console.log(`err: `, err),
                () => console.log('done')
            );

    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }
}




















