import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicesUserPageComponent } from './services-user-page.component';

describe('ServicesUserPageComponent', () => {
  let component: ServicesUserPageComponent;
  let fixture: ComponentFixture<ServicesUserPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServicesUserPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServicesUserPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
