import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerhomepageComponent } from './trainerhomepage.component';

describe('TrainerhomepageComponent', () => {
  let component: TrainerhomepageComponent;
  let fixture: ComponentFixture<TrainerhomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerhomepageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerhomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
