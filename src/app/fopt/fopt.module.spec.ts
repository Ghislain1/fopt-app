import { FoptModule } from './fopt.module';

describe('FoptModule', () => {
  let foptModule: FoptModule;

  beforeEach(() => {
    foptModule = new FoptModule();
  });

  it('should create an instance', () => {
    expect(foptModule).toBeTruthy();
  });
});
