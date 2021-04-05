import { TestBed } from '@angular/core/testing';

import { TopicForumService } from './topic-forum.service';

describe('TopicForumService', () => {
  let service: TopicForumService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TopicForumService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
