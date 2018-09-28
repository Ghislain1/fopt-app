import { TestBed, inject } from '@angular/core/testing';

import { AnsweredQuestionService } from './answered-question.service';

describe('AnsweredQuestionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AnsweredQuestionService]
    });
  });

  it('should be created', inject([AnsweredQuestionService], (service: AnsweredQuestionService) => {
    expect(service).toBeTruthy();
  }));
});
