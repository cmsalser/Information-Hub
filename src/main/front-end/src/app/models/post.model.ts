import { Thread } from './thread.model';

export class Post {
    id: number;
    thread: Thread;
    title: string;
    description: string;
    timestampCreated: Date;
    timestampEdited: Date;
    stickied: boolean;
    upvotes: [];
    anonymous: boolean;

    constructor(id: number, thread: Thread, title: string, description: string, timestampCreated: Date, timestampEdited: Date, stickied: boolean, upvotes: [], anonymous: boolean){
        this.id = id;
        this.thread = thread;
        this.title = title;
        this.description = description;
        this.timestampCreated = timestampCreated;
        this.timestampEdited = timestampEdited;
        this.stickied = stickied;
        this.upvotes = upvotes;
        this.anonymous = anonymous;
    }
}