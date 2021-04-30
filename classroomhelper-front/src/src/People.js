import { render } from '@testing-library/react';
import React, { Component } from 'react';
import Home from './Home';
import MyGroup from './MyGroup';
import "./People.css"
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
export default class People extends React.Component {
    componentWillMount() {
        this.props.history.push('/People');
    }

    render() {
        return (
            <div className="People">

                <p>
                    People
            </p>

                <Link to="/Course"><button>Course</button></Link>
                <Link to="/MyGroup"><button>My Group</button></Link>
                <Link to="/AllGroups"><button>All Groups</button></Link>
                <Link to="/People"><button>People</button></Link>

            </div>
        )
    }
}