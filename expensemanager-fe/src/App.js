import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Main from './components/Main';
import Expenses from './components/Expenses';
import Incomes from './components/Incomes';
import Reports from './components/Reports';

const App = () => (
  <Router>
    <Switch>
      <Route exact path="/" render={Main} />
      <Route path="/expenses" component={Expenses} />
      <Route path="/incomes" component={Incomes} />
      <Route path="/reports" component={Reports} />
    </Switch>
  </Router>
);

export default App;
