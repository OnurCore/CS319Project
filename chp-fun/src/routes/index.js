import React from 'react';

import {BrowserRouter, Route, Switch} from 'react-router-dom';

import Home from './Home';
import Course from './Course';
import MyGroup from './MyGroup';
import AllGroups from './AllGroups';
import People from './People';

export default () => 
<BrowserRouter>
<Switch>
    <Route path="/" exact component={Home} /> 
    <Route path="/Home" component={Home} />
    <Route path="/Course" component={Course} />
    <Route path="/MyGroup" component={MyGroup} />
    <Route path="/AllGroups" component={AllGroups} />
    <Route path="/People" component={People} />
</Switch>
</BrowserRouter>;