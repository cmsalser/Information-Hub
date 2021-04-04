import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YouthAppointmentComponent } from './youth-appointment.component';

describe('YouthAppointmentComponent', () => {
  let component: YouthAppointmentComponent;
  let fixture: ComponentFixture<YouthAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ YouthAppointmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(YouthAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
