import React from "react"
import { slide as Menu } from 'react-burger-menu'
import navStyle from "./hamStyling.css"

export default class NavBar extends React.Component {

    showSettings(event) {
        event.preventDefault();
    }


    render() {
                    //Add other pages here
        return (
            <>
                <Menu styles={navStyle} >
                    <a id="Course" className="menu-item" href="/Course">Course</a>
                    <a id="MyGroup" className="menu-item" href="/MyGroup">MyGroup</a>
                    <a id="AllGroups" className="menu-item" href="/AllGroups">AllGroups</a>
                    <a id="People" className="menu-item" href="/People">People</a>
                    <a onClick={this.showSettings} className="menu-item--small" href="">Settings</a>
                </Menu>
            </>
        )


    }

}





