import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecificGuestComponent } from './specific-guest.component';

describe('SpecificGuestComponent', () => {
  let component: SpecificGuestComponent;
  let fixture: ComponentFixture<SpecificGuestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecificGuestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecificGuestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
