import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./Home.css"
import Course from './Course';
import MyGroup from './MyGroup';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
export default class Home extends React.Component {
    componentWillMount() {
        this.props.history.push('/home');
    }

    render() {
        return (
            <div className="Home">
                <header>
                    <p>
                        Classroom Helper for Students
              </p>
                </header>
                <form>
                    <label>
                        Email:
                  <input type="text" name="Email" />
                    </label>
                </form>

                <form>
                    <label>
                        Password:
                  <input type="text" name="Password" />
                    </label>
                </form>

                <Link to="/Course">  <button>Login</button>   </Link>

                <button>Sign-up</button>

            </div>
        )
            ;
    }
}