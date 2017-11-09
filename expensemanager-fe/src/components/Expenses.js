import React from 'react';
import PropTypes from 'prop-types';
import FeatureButton from './FeatureButton';

const Expenses = ({ match, changeFeature, changeAction }) => (
  <div className="container d-flex h-100">
    <div className="row w-100 justify-content-center align-self-center">
      <FeatureButton
        link={`${match.url}/new`}
        text="New"
        feature="Expenses"
        action="New"
        changeFeature={changeFeature}
        changeAction={changeAction}
      />
      <hr className="vertical-spacer d-md-none" />
      <FeatureButton
        link={`${match.url}/filter`}
        text="Filter"
        feature="Expenses"
        action="Filter"
        changeFeature={changeFeature}
        changeAction={changeAction}
      />
    </div>
  </div>
);

Expenses.propTypes = {
  match: PropTypes.shape({
    url: PropTypes.string,
  }).isRequired,
  changeFeature: PropTypes.func.isRequired,
  changeAction: PropTypes.func.isRequired,
};

export default Expenses;
