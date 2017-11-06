import React from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from 'react-router-dom';
import Expenses from './components/Expenses';
import Incomes from './components/Incomes';
import Reports from './components/Reports';

const App = () => (
  <Router>
    <Switch>
      <Route
        exact
        path="/"
        render={() => (
          <div className="container d-flex h-100">
            <div className="row w-100 justify-content-center align-self-center">
              <div className="col-sm col-md-4">
                <Link to="/expenses">
                  <div className="d-flex mx-auto main-feature-item material-bg-primary">
                    <div className="mx-auto my-auto material-text-primary">
                      <strong>Expenses</strong>
                    </div>
                  </div>
                </Link>
              </div>
              <hr className="vertical-spacer d-md-none" />
              <div className="col-sm col-md-4">
                <Link to="/incomes">
                  <div className="d-flex mx-auto main-feature-item material-bg-primary">
                    <div className="mx-auto my-auto material-text-primary">
                      <strong>Incomes</strong>
                    </div>
                  </div>
                </Link>
              </div>
              <hr className="vertical-spacer d-md-none" />
              <div className="col-sm col-md-4">
                <Link to="/reports">
                  <div className="d-flex mx-auto main-feature-item material-bg-primary">
                    <div className="mx-auto my-auto material-text-primary">
                      <strong>Reports</strong>
                    </div>
                  </div>
                </Link>
              </div>
            </div>
          </div>
        )}
      />
      <Route path="/expenses" component={Expenses} />
      <Route path="/incomes" component={Incomes} />
      <Route path="/reports" component={Reports} />
    </Switch>
  </Router>
);

export default App;
