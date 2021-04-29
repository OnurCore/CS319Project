import React from 'react'
import Group from './Group'

export default class GroupFrame extends React.Component {

    // async fetchGroupByID(){

    //     const response = await fetch("https://0fb8886f-8d61-4bc9-9b01-4362a104ed54.mock.pstmn.io/group?id="+ this.props.id)
    
    //     if(!response.ok){
    //         throw new Error(`HTTP error! status: ${response.status}`);
    //     }
    
    //     let json = await response.json();
    
    //     return json;
    
    // }

    constructor(){
        super()
        this.state = {
            groupObj: null
        }
    }

    render(){

        // var result = this.fetchGroupByID();
        // console.log(this.props.id, "JSOOOOOOOOOOON" , result)
        return (
            <>
                <Group id = {this.props.id} ></Group>
                <button>Join Request</button>
                <button type="button" disabled>Review </button>
            </>
        )
    }
}


