import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./MyGroup.css"
import NavBar from "../NavBar/NavBar"
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
export default class MyGroup extends React.Component {
    componentWillMount(){
        this.props.history.push('/MyGroup');
    }

    render(){
        return(
            <>
            <NavBar> </NavBar>

            <div className="MyGroup">
            
            <h1>
                My Group
            </h1>

            <Link to="/Course"><button>Course</button></Link>            
            <Link to="/MyGroup"><button>My Group</button></Link>
            <Link to="/AllGroups"><button>All Groups</button></Link>
            <Link to="/People"><button>People</button></Link>    

            </div>

            </>
        )
    }
}