import { Question } from './question';



/// Similary to ShoppingCartItem  
export class AnsweredQuestionItem {
    $key: string; //id to serve the quesuin FireBase.
    title: string; //Get and sets global title of the question
    description: number; // Get and sets the phrase of the question
    chapter: string; // Whre the question should come from.
    imageUrl: string;
    aid: string; //answer Id;
    quantity: number; //how much this question has been answered?

    //TODO-Ghislain: why Partial what does it mean?
    constructor(init?: Partial<AnsweredQuestionItem>) {
        Object.assign(this, init); // TODO-Ghislain: can you explain this?
    }

    //TODO-Ghislain: Why get wioth empty space???
    get totalQuantity() {
        return this.quantity;
    }
}


