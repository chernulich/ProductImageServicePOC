import { TestBed } from '@angular/core/testing';

import { HttpImageService } from './http-image.service';

describe('HttpImageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpImageService = TestBed.get(HttpImageService);
    expect(service).toBeTruthy();
  });
});
