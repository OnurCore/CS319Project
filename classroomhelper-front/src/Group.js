import React from 'react'

export default class Group extends React.Component {

    constructor(){
        super()
        this.state = {
            nameSource: null
        }
    }

    // componentDidMount(){
    //         var requestOptions = {
    //             method: 'GET',
    //             redirect: 'follow'
    //           };
     
    //     fetch("https://0fb8886f-8d61-4bc9-9b01-4362a104ed54.mock.pstmn.io/group?id="+ this.props.id, requestOptions)
    //           .then((response) => {
    //             console.log("response: ", response.json());
    //             let namelist = response;
    //             this.setState({
    //                 nameSource : namelist
    //             })
    //         })
    

         
    // }
    
    render(){
        

        // async function createNamesTable(groupData ){
        //     return await Promise.resolve(groupData);
        // }
        

        if( this.state.nameSource instanceof Promise ){ return null;}
        if( this.state.nameSource == null ){ return null;}
        console.log("inside group namesource", this.props.id, this.state.nameSource.body);
        return (
            
            <div className="group-name-list">
                <h1>Group {this.props.id}</h1>
                <ul>
                    <li>isim1</li>
                    <li>isim1</li>
                    <li>isim1</li>
                    <li>isim1</li>
                    <li>isim1</li>
                </ul>
            </div>
        
        )
    }
}