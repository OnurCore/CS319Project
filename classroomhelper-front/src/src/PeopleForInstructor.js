import Home from './Home';
import MyGroup from './MyGroup';
import React, { Component } from 'react';
import "./People.css"
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
export default class PeopleForInstructor extends React.Component {
    componentWillMount() {
        this.props.history.push('/PeopleForInstructor');
    }

    render() {
        return (
            <div className="People">

                <p>
                    People
            </p>

                <Link to="/CourseForInstructor"><button>Course</button></Link>
                <Link to="/Assignment"><button>Assignment</button></Link>
                <Link to="/AllGroupsInstructor"><button>All Groups</button></Link>
                <Link to="/PeopleForInstructor"><button>People</button></Link>

            </div>
        )
    }
}