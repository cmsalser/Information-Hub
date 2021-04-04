import { TopicForum } from './topicForum.model';

export class Thread {
    threadID: number;
    title: string;
    description: string;
    anonymous: boolean;
    timestampCreated: Date;
    timestampEdited: Date;
    stickied: boolean;
    topicForum: TopicForum;

    constructor(threadID: number, title: string, description: string, anonymous: boolean, timestampCreated: Date, timestampEdited: Date, stickied: boolean, topicForum: TopicForum) {
        this.threadID = threadID;
        this.title = title;
        this.description = description;
        this.anonymous = anonymous;
        this.timestampCreated = timestampCreated;
        this.timestampEdited = timestampEdited;
        this.stickied = stickied;
        this.topicForum = topicForum;
    }
}