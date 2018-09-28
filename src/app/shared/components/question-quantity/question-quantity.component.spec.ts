import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionQuantityComponent } from './question-quantity.component';

describe('QuestionQuantityComponent', () => {
  let component: QuestionQuantityComponent;
  let fixture: ComponentFixture<QuestionQuantityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuestionQuantityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
