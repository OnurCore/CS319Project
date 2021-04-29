import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./Course.css"
import Home from './Home';
import MyGroup from './MyGroup';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
export default class Course extends React.Component {
    componentWillMount(){
        this.props.history.push('/Course');
    }

    render(){
        return(
            <div className="Course">
            
            <p>
                Course
            </p>

            <Link to="/Course"><button>Course</button></Link>            
            <Link to="/MyGroup"><button>My Group</button></Link>
            <Link to="/AllGroups"><button>All Groups</button></Link>
            <Link to="/People"><button>People</button></Link>   

            </div>
        )
    }
}