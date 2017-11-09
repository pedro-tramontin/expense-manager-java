import React from 'react';
import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';

class FeatureButton extends React.Component {
  constructor(props) {
    super(props);

    this.state = props;
  }

  changeFeature(feature) {
    this.props.changeFeature(feature);
  }

  changeAction(action) {
    this.props.changeAction(action);
  }

  changeTitle(feature, action) {
    if (feature) this.props.changeFeature(feature);
    if (action) this.props.changeAction(action);
  }

  render() {
    return (
      <div className="col-sm col-md-4">
        <Link
          to={this.state.link}
          onClick={() => (
            this.changeTitle(this.state.feature, this.state.action)
          )}
        >
          <div className="d-flex mx-auto main-feature-item material-bg-primary">
            <div className="mx-auto my-auto material-text-primary">
              <strong>{this.state.text}</strong>
            </div>
          </div>
        </Link>
      </div>
    );
  }
}

FeatureButton.propTypes = {
  changeFeature: PropTypes.func.isRequired,
  changeAction: PropTypes.func.isRequired,
};

export default FeatureButton;
