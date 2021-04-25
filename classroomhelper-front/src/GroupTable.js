import React from 'react'
import GroupFrame from './GroupFrame'
import "./GroupTable.css"


export default class GroupTable extends React.Component {


    render(){
        return (
            <div class="row">
                <div class="column"  >
                    <GroupFrame id="1A"> </GroupFrame>
                </div>
                <div class="column" > 
                    <GroupFrame id="1B"> </GroupFrame>
                </div>
               
                <p>This is GroupTable </p> 
            </div>

            
        )
    }
}
