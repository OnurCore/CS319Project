import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./AllGroups.css"

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
export default class Assignment extends React.Component {
    componentWillMount() {
        this.props.history.push('/Assignment');
    }

    render() {
        return (
            <div className="AllGroups">

                <p>
                    Assignment
            </p>

                <Link to="/CourseForInstructor"><button>Course</button></Link>
                <Link to="/Assignment"><button>Assignment</button></Link>
                <Link to="/AllGroupsInstructor"><button>All Groups</button></Link>
                <Link to="/PeopleForInstructor"><button>People</button></Link>

            </div>
        )
    }
}