import React from 'react';
import PropTypes from 'prop-types';
import FeatureButton from './FeatureButton';

const Incomes = ({ match }) => (
  <div className="container d-flex h-100">
    <nav className="navbar fixed-top material-bg-primary">
      <span className="navbar-brand mb-0 h1 material-text-primary">
        <strong>Incomes</strong>
      </span>
    </nav>
    <div className="row w-100 justify-content-center align-self-center">
      <FeatureButton link={`${match.url}/new`} text="New" />
      <hr className="vertical-spacer d-md-none" />
      <FeatureButton link={`${match.url}/filter`} text="Filter" />
    </div>
  </div>
);

Incomes.propTypes = {
  match: PropTypes.shape({
    url: PropTypes.string,
  }).isRequired,
};

export default Incomes;
