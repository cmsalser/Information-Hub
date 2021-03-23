export class Thread {
    threadID: number;
    accountID: number;
    title: string;
    description: string;
    timestampCreated: Date;
    timestampEdited: Date;
    stickied: boolean;

    constructor(threadID: number, accountID: number, title: string, description: string, timestampCreated: Date, timestampEdited: Date, stickied: boolean) {
        this.threadID = threadID;
        this.accountID = accountID;
        this.title = title;
        this.description = description;
        this.timestampCreated = timestampCreated;
        this.timestampEdited = timestampEdited;
        this.stickied = stickied;
    }
}