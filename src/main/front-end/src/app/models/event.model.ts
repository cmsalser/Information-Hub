export class Event {

    constructor(public id: number, public userId: number, public title: string, public startDate: Date, public endDate: Date, public description: string, public eventLink: string, public body: string) {
    }
}
