export class Event {
    userId: number;
    eventId: number;
    title: string;
    description: string;
    body: string;

    constructor(userId: number, eventId: number, title: string, description: string, body: string) {
        this.userId = userId;
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.body = body;
    }
}