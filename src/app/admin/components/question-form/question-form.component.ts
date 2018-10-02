import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { QuestionService } from '../../../shared/services/question.service';
import { CategoryService } from '../../../shared/services/category.service';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {
  categories$;
  Question = {};
  id;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private categoryService: CategoryService,
    private questionService: QuestionService) {
    this.categories$ = categoryService.getAll();

    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) this.questionService.get(this.id).valueChanges().subscribe(p => this.Question = p);
  }

  save(Question) {
    if (this.id) this.questionService.update(this.id, Question);
    else this.questionService.create(Question);

    this.router.navigate(['/admin/Questions']);
  }

  delete() {
    if (!confirm('Are you sure you want to delete this Question?')) return;

    this.questionService.delete(this.id);
    this.router.navigate(['/admin/Questions']);
  }

  ngOnInit() {
  }

  private log(value: any): void {
    console.log(JSON.stringify(value, null, 3));
  }

}