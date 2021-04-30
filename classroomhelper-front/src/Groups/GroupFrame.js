import React from 'react'
import Group from './Group'

export default class GroupFrame extends React.Component {

    constructor(){
        super()
        this.state = {
            groupObj: null
        }
    }

    render(){
        return (
            <>
                <Group id = {this.props.id} ></Group>
                <button>Join Request</button>
                <button type="button" disabled>Review </button>
            </>
        )
    }
}


