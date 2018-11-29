import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostsuccessfulComponent } from './postsuccessful.component';

describe('PostsuccessfulComponent', () => {
  let component: PostsuccessfulComponent;
  let fixture: ComponentFixture<PostsuccessfulComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostsuccessfulComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostsuccessfulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
