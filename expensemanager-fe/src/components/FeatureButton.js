import React from 'react';
import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';

const FeatureButton = props => (
  <div className="col-sm col-md-4">
    <Link to={props.link}>
      <div className="d-flex mx-auto main-feature-item material-bg-primary">
        <div className="mx-auto my-auto material-text-primary">
          <strong>{props.text}</strong>
        </div>
      </div>
    </Link>
  </div>
);

FeatureButton.propTypes = {
  link: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
};

export default FeatureButton;
