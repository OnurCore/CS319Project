
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import './App.css';
import GroupTable from "./Groups/GroupTable"

import React from 'react';


export default function BasicExample() {
  return (
    <Router>
      <div>
          <Switch>

            <Route exact path="/">
                <App />
            </Route>

            <Route path="/home">
                <Home />
            </Route>
          
            <Route path="/mygroup">
                <MyGroup />
            </Route>
      
              <Route path="/people">
                <People />
              </Route>

          </Switch>
      </div>
    </Router>
  );
}

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <p>
            Classroom Helper
          </p>

          <form>
            <label>
              Username:
              <input type="text" name="Username"/>
            </label>
          </form>

          <form>
            <label>
              Password:
              <input type="text" name="Password" />
            </label>
          </form>

          <Link to="/Home">  <button>Login</button>   </Link>  

          <button>Sign-up</button>
        </header>
      </div>
    </Router>
  );
}

function Home() {
  return (
    <Router>
        <div className="App">

          <p>
              Homepage
          </p>
      
          <Link to="/home">       <button>Home</button>        </Link>
          <Link to="/mygroup">    <button>My Groups</button>   </Link>
          <Link to="/people">     <button>People</button>      </Link>     
              
          <button>All Groups</button>
              
          <button>Gradebook</button>
      
          <button>Info</button>
 
        </div>
        </Router>
      );
  
}

function MyGroup(){
return (
  <Router>
      <div className="App">
      
        <h1>
            My Group
        </h1>


        <Link to="/home"> <button>Home </button></Link>
        <Link to="/mygroup"> <button> My Group </button></Link>
        <Link to="/people"> <button> People </button></Link>     
        
        <button>All Groups</button>
                
        <button>Gradebook</button>
            
        <button>Info</button>
      
        <GroupTable>
          </GroupTable>
      </div>
  </Router>
  );
}


function People(){
  return (
    <Router>
        <div className="App">
          <p>
              People
          </p>
    
        <Link to="/home"> <button>Home </button></Link>
        <Link to="/mygroup"> <button> My Group </button></Link>
        <Link to="/people"> <button> People </button></Link>     
        
        <button>All Groups</button>
                
        <button>Gradebook</button>
            
        <button>Info</button>
     
        <p>
        Participants List
        </p>

        <ul>
          <li>
            Funda Tan             
            <button>
            Send invitation
            </button>   
          </li>

          <li>
            Ezgi Saygılı           
            <button>
            Send invitation
            </button>
          </li>
      </ul>
        
      </div>
    </Router>
  );
}



