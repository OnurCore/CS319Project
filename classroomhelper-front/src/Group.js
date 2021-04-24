import React from 'react'

export default class Group extends React.Component {


    render(){
        return (
        
            <div className="shopping-list">
                <h1>Group {this.props.id}</h1>
                <ul>
                    <li>Ahmet</li>
                    <li>Mehmet</li>
                    <li>Yeşil</li>
                    <li>Empty</li>
                    <li>Empty</li>
                </ul>
            </div>
        
        )
    }
}