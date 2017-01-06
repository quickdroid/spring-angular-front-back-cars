import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/from';

import { ICar } from './car';

@Injectable()
export class CarService {

    private _carsUrl = 'http://localhost:8080/api/v1/models';
    private _carUrl =  'http://localhost:8080/api/v1/model/';

    constructor(private _http: Http) {
    }

    getCars(): Observable<ICar[]> {
        return this._http.get(this._carsUrl)
            .map((response: Response) =>  <ICar[]> response.json())
            .catch(this.handleError);
    }

    getCar(id: number): Observable<ICar> {
        return this._http.get(this._carUrl + id)
            .map((response: Response) => <ICar> response.json())
            .do((data) => console.log(`From service CAR: `, data))
            .catch(this.handleError);
    }

    deleteCar(id: number): Observable<ICar>  {
        return this._http.delete(this._carUrl + id)
            .map((response: Response) => <ICar> response.json())
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.json().error || 'Server error');
    }

    updateCar(car: ICar): Observable<ICar> {
        return this._http.put(this._carUrl+car.id, car)
            .map((response: Response) => <ICar> response.json())
            .do(data => console.log(`returned data: `, JSON.stringify(data)))
            .catch(this.handleError);
    }
}
