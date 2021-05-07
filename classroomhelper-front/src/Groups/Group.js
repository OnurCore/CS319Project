import React from 'react'

export default class Group extends React.Component {

    state = {
        loading: true,
        groupInfo : null
    }

    async componentDidMount(){

        //This part is commented because, fake database api request has limited usage. 

         const url = "http://localhost:8080/allGroups/" + this.props.id
         const response = await fetch(url);
         const data = await response.json();
         this.setState({
             loading: false,
            groupInfo: data
         })}
/*
        this.setState({
            loading: false,
            groupInfo: { "id": 1,
             "name": "1A",
              "userlist": [ "dummy data",
                    "dummy data",
                    "dummy data",
                    "dummy data",
                    "dummy data" ]}})
    }
    */
    render(){
       
        return (
            <div>
                {
                    (this.state.loading || (this.state.groupInfo === null)) ? 
                    <div>loading...</div> 
                    :
                    <div className="group-name-list">
                    <h1>Group {this.props.id}</h1>
                    <ul>
                        <li>{this.state.groupInfo.name}</li>
                    </ul>
                </div>
           
                } 
            </div>
                
        )
    }
}