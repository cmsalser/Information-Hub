export class Event {
    userId: number;
    eventId: number;
    title: string;
    startDate: Date = new Date();;
    endDate: Date = new Date();;
    description: string;
    body: string;

    constructor(userId: number, eventId: number, title: string, startDate: Date, endDate: Date, description: string, body: string) {
        this.userId = userId;
        this.eventId = eventId;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.body = body;
    }
}