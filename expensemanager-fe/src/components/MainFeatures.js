import React from 'react';
import PropTypes from 'prop-types';
import FeatureButton from './FeatureButton';

const MainFeatures = props => (
  <div className="container d-flex h-100">
    <div className="row w-100 justify-content-center align-self-center">
      <FeatureButton
        link="/expenses"
        text="Expenses"
        feature="Expenses"
        changeFeature={props.changeFeature}
        changeAction={props.changeAction}
      />
      <hr className="vertical-spacer d-md-none" />
      <FeatureButton
        link="/incomes"
        text="Incomes"
        feature="Incomes"
        changeFeature={props.changeFeature}
        changeAction={props.changeAction}
      />
      <hr className="vertical-spacer d-md-none" />
      <FeatureButton
        link="/reports"
        text="Reports"
        feature="Reports"
        changeFeature={props.changeFeature}
        changeAction={props.changeAction}
      />
    </div>
  </div>
);

MainFeatures.propTypes = {
  changeFeature: PropTypes.func.isRequired,
  changeAction: PropTypes.func.isRequired,
};

export default MainFeatures;
