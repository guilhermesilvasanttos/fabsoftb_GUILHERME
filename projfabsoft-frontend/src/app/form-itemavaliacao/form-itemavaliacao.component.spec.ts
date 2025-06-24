import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormItemavaliacaoComponent } from './form-itemavaliacao.component';

describe('FormItemavaliacaoComponent', () => {
  let component: FormItemavaliacaoComponent;
  let fixture: ComponentFixture<FormItemavaliacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormItemavaliacaoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormItemavaliacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
