import React from 'react';
import PropTypes from 'prop-types';

const Header = ({ feature, action }) => {
  const titleFeature = feature ? `: ${feature}` : '';
  const titleAction = action ? ` - ${action}` : '';

  const title = `Expense Manager${titleFeature}${titleAction}`;

  return (
    <nav className="navbar fixed-top material-bg-primary">
      <span className="navbar-brand mb-0 h1 material-text-primary">
        <strong>{ title }</strong>
      </span>
    </nav>
  );
};

Header.propTypes = {
  feature: PropTypes.string.isRequired,
  action: PropTypes.string.isRequired,
};

export default Header;
