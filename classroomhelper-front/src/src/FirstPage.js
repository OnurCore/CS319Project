import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./Course.css"
import Home from './Home';
import InstructorSignUp from './InstructorSignUp';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
export default class FirstPage extends React.Component {

    render() {
        return (
            <div className="Course">

                <p>
                    Welcome to Classroom Helper.
                </p>

                <Link to="/InstructorSignUp"><button>Instructor</button></Link>
                <Link to="/Home"><button>Student</button></Link>


            </div>
        )
    }
}