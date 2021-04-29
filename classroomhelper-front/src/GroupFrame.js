import React from 'react'
import Group from './Group'

export default class GroupFrame extends React.Component {

    sendJoinRequest(){
        //TODO
    }

    async fetchGroupByID(id){
       var requestOptions = {
           method: 'GET',
           redirect: 'follow'
         };

    const response = await fetch("https://0fb8886f-8d61-4bc9-9b01-4362a104ed54.mock.pstmn.io/group?id="+id, requestOptions)

    const json = await response.json();

    console.log(json)

    return json;
    

        // return {
        //     "id": id,
        //     "name": "1A",
        //     "userlist": [
        //      "isim1A soyisim1A",
        //      "isim2A soyisim2A",
        //      "isim3A soyisim3A",
        //      "isim4A soyisim4A",
        //      "isim5A soyisim5A"
        //     ]
        //    }
    }

    render(){

        var result = this.fetchGroupByID(this.props.id);
        console.log("inside render" , this.props.id , result);
        return (
            <>
                <Group id = {this.props.id} groupData = {result}></Group>
                <button>Join Request</button>
                <button type="button" disabled>Review </button>
            </>
        )
    }
}
