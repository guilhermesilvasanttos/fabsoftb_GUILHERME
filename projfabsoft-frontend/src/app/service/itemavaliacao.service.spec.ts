import { TestBed } from '@angular/core/testing';

import { ItemavaliacaoService } from './itemavaliacao.service';

describe('ItemavaliacaoService', () => {
  let service: ItemavaliacaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemavaliacaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
