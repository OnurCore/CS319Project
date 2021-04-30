import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./Course.css";
import Home from './Home';
import Assignment from './Assignment';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
export default class CourseForInstructor extends React.Component {
    componentWillMount() {
        this.props.history.push('/CourseForInstructor');
    }

    render() {
        return (
            <div className="Course">

                <p>
                    Course
            </p>

                <Link to="/CourseForInstructor"><button>Course</button></Link>
                <Link to="/Assignment"><button>Assignment</button></Link>
                <Link to="/AllGroupsInstructor"><button>All Groups</button></Link>
                <Link to="/PeopleForInstructor"><button>People</button></Link>

            </div>
        )
    }
}