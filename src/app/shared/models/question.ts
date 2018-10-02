/// Define abstraction of Question!!

export interface Question {
    $key: string; //id to serve the quesuin FireBase.
    title: string; //Get and sets global title of the question
    description: number; // Get and sets the phrase of the question
    chapter: string; // Whre the question should come from.
    imageUrl: string;
    request: string;
    qid: string; //answer Id;
}