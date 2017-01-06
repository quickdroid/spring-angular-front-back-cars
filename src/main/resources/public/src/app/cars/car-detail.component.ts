import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { CarService } from './car.service';
import { ICar } from './car';


import { Subscription } from 'rxjs/Subscription';

@Component({
    templateUrl: './car-detail.component.html'
})

export class CarDetailComponent implements OnInit, OnDestroy {

    pageTitle: string = 'Car Detail';
    car: ICar;
    errorMessage: string;
    private sub: Subscription;

    constructor(private _route: ActivatedRoute,
                private _carService: CarService,
                private _router: Router) {
    }

    ngOnInit(): void {
        this.sub = this._route.params.subscribe(
            params => {
                let id = +params['id'];
                this.getCar(id);
            }
        )
    }

    ngOnDestroy(): void {
        this.sub.unsubscribe();
    }

    private getCar(id: number) {
        this._carService.getCar(id).subscribe(
            car => this.car = car,
            error => this.errorMessage = <any>error);

        console.log('CAR: ', this.car);
    }

    goBack(): void {
        this._router.navigate(['/cars']);
    }

}
