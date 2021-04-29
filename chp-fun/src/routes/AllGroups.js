import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./AllGroups.css"

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
export default class AllGroups extends React.Component {
    componentWillMount(){
        this.props.history.push('/AllGroups');
    }

    render(){
        return(
            <div className="AllGroups">
            
            <p>
                All Groups
            </p>

            <Link to="/Course"><button>Course</button></Link>         
            <Link to="/MyGroup"><button>My Group</button></Link>
            <Link to="/AllGroups"><button>All Groups</button></Link>
            <Link to="/People"><button>People</button></Link>     

            </div>     
        )
    }
}