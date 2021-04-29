import React from 'react'
import GroupFrame from './GroupFrame'
import "./GroupTable.css"


export default class GroupTable extends React.Component {

    //static groupIDArray = [];
    fetchAvailableGroupInfo() {
        //Get a fetch method here
        //var groupIDArray = [1,2,3];
    }

    render(){
        //this.fetchGroupInfo();
        var groupIDArray = [1,2,3,4,5,6,7,8,9,10];
        var rows = [];

        for (var i = 0; i <groupIDArray.length ; i++ ) {
            rows.push(<div key={"col " + i} className="column"  > <GroupFrame id={groupIDArray[i]}> </GroupFrame>  </div>)
            //<div class="row"> <div class="column"  > <GroupFrame id={groupIDArray[i]}> </GroupFrame>  </div></div>
        } 
        return <div>{rows}</div>;
           
    }
}
