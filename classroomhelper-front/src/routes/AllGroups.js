import { render } from '@testing-library/react';
import React, { Component } from 'react';
import "./AllGroups.css"
import NavBar from "../NavBar/NavBar"
import GroupTable from "../Groups/GroupTable"
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
            <>
                <NavBar></NavBar>



                <div className="AllGroups">

                    <h1>
                        All Groups
                    </h1>

                    <GroupTable></GroupTable>

                </div>
            </>   
        )
    }
}