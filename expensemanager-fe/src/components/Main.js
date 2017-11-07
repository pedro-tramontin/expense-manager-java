import React from 'react';
import FeatureButton from './FeatureButton';

const Main = () => (
  <div className="container d-flex h-100">
    <div className="row w-100 justify-content-center align-self-center">
      <FeatureButton link="/expenses" text="Expenses" />
      <hr className="vertical-spacer d-md-none" />
      <FeatureButton link="/incomes" text="Incomes" />
      <hr className="vertical-spacer d-md-none" />
      <FeatureButton link="/reports" text="Reports" />
    </div>
  </div>
);

export default Main;
