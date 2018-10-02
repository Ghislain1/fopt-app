import { AnsweredQuestionItem } from './answered-question-item';
import { Question } from './question';

/// Define abstraction of Question!!
/// Define abstraction of Question!!

/// Similary to ShoppingCart 


export class AnsweredQuestion {
    ///
    items: AnsweredQuestionItem[] = [];

    //TODO_Ghislain: What means this  given paramter  syntax: -->  private itemsMap: { [questionId: string]: AnsweredQuestionItem }
    constructor(private itemsMap?: { [questionId: string]: AnsweredQuestionItem }) {

        //TODO_Ghislain: Canb you explain this || {}
        this.itemsMap = itemsMap || {};

        for (let questionId in itemsMap) {
            let item = itemsMap[questionId];
            this.items.push(new AnsweredQuestionItem({ ...item, $key: questionId }));
        }
    }

    ///Provide a number of time this item question has been answered.
    getQuantity(question: Question) {
        let item = this.itemsMap[question.$key];
        return item ? item.quantity : 0;
    }

    //TODO-GHislain: why the get with space---> besser because  we don t need  to write property again and outside this can be call as property.
    get totalItemsCount() {
        let count = 0;
        for (let questionId in this.itemsMap) {
            count += this.itemsMap[questionId].quantity;
        }
        return count;
    }

}