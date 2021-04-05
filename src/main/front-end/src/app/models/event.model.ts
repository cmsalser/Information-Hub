export class Event {
    userId: number;
    eventId: number;
    title: string;
    startDate: Date;
    endDate: Date;
    description: string;
    eventLink: string;
    body: string; //don't need?

    constructor(userId: number, eventId: number, title: string, startDate: Date, endDate: Date, description: string, eventLink: string, body: string) {
        this.userId = userId;
        this.eventId = eventId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.eventLink = eventLink;
        this.body = body; //remove??, not used
    }
}