export interface ICar {
    id: number;
    name: string;
    price: number;
    speed: number;
    engineType: string;
    brand: string;        // todo IBrand
    modelType: string;    // todo IModelType
}

export class Car implements ICar {
    id: number;
    name: string;
    price: number;
    speed: number;
    engineType: string;
    brand: string;
    modelType: string;

}