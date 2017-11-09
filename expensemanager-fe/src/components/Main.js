import React from 'react';
import { Route, Switch } from 'react-router-dom';
import Header from './Header';
import MainFeatures from './MainFeatures';
import Expenses from './Expenses';
import Incomes from './Incomes';
import Reports from './Reports';

class Main extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      feature: '',
      action: '',
    };

    this.handleFeature = this.changeFeature.bind(this);
    this.handleAction = this.changeAction.bind(this);
  }

  changeFeature(newFeature) {
    this.setState({ feature: newFeature });
  }

  changeAction(newAction) {
    this.setState({ action: newAction });
  }

  render() {
    return (
      <div className="container d-flex h-100">
        <Header
          feature={this.state.feature}
          action={this.state.action}
        />
        <Switch>
          <Route
            exact
            path="/"
            render={() => (
              <MainFeatures
                changeFeature={this.handleFeature}
                changeAction={this.handleAction}
              />
            )}
          />
          <Route
            path="/expenses"
            render={({ match }) => (
              <Expenses
                changeFeature={this.handleFeature}
                changeAction={this.handleAction}
                match={match}
              />
            )}
          />
          <Route
            path="/incomes"
            render={({ match }) => (
              <Incomes
                changeFeature={this.handleFeature}
                changeAction={this.handleAction}
                match={match}
              />
            )}
          />
          <Route
            path="/reports"
            render={({ match }) => (
              <Reports
                changeFeature={this.handleFeature}
                changeAction={this.handleAction}
                match={match}
              />
            )}
          />
        </Switch>
      </div>
    );
  }
}

export default Main;
