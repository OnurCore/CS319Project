import React from 'react';

import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { render } from "react-dom";
import Home from './Home';
import Course from './Course';
import MyGroup from './MyGroup';
import AllGroups from './AllGroups';
import People from './People';
import AllGroupsInstructor from './AllGroupsInstructor';
import InstructorSignUp from './InstructorSignUp';
import FirstPage from './FirstPage';
import CourseForInstructor from './CourseForInstructor';
import Assignment from './Assignment';
import PeopleForInstructor from './PeopleForInstructor';
class App extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path="/" exact component={FirstPage} />
          <Route path="/Home" component={Home} />
          <Route path="/Course" component={Course} />
          <Route path="/MyGroup" component={MyGroup} />
          <Route path="/AllGroups" component={AllGroups} />
          <Route path="/People" component={People} />
          <Route path="/AllGroupsInstructor" component={AllGroupsInstructor} />
          <Route path="/FirstPage" component={FirstPage} />
          <Route path="/InstructorSignUp" component={InstructorSignUp} />
          <Route path="/CourseForInstructor" component={CourseForInstructor} />
          <Route path="/Assignment" component={Assignment} />
          <Route path="/PeopleForInstructor" component={PeopleForInstructor} />
        </Switch>
      </BrowserRouter>
    )
  }
}


render(<App />, window.document.getElementById('root'));