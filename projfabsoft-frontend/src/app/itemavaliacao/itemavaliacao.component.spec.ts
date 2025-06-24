import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemavaliacaoComponent } from './itemavaliacao.component';

describe('ItemavaliacaoComponent', () => {
  let component: ItemavaliacaoComponent;
  let fixture: ComponentFixture<ItemavaliacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ItemavaliacaoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemavaliacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
