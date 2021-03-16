// import { isLoweredSymbol } from "@angular/compiler";

export class Faq {
    id: string;
    question: string;
    answer: string;

    constructor(id: string, question: string, answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    // userId: number;
    // id: number;
    // title: string;
    // body: string;

    // constructor(userId: number, id: number, title: string, body: string) {
    //     this.userId = userId;
    //     this.id = id;
    //     this.title = title;
    //     this.body = body;
    // }
}