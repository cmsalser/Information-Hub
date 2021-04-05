import { TestBed } from '@angular/core/testing';

import { EventsScheduleService } from './events-schedule.service';

describe('EventsScheduleService', () => {
  let service: EventsScheduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventsScheduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
