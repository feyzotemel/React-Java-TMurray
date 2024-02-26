import React, { useState } from 'react';
import { MenuMenu, MenuItem, Menu, Container } from 'semantic-ui-react';
import SignedIn from './SignedIn';
import SignedOut from './SignedOut';
import {NavLink} from 'react-router-dom';
import { useNavigate } from "react-router-dom";

export default function Navi() {
  const [isAuthenticated, setisAuthenticated] = useState(true);
  const navigate = useNavigate();
  
  function handleSignOut() {
    console.log("handleSignOut")
    localStorage.setItem("isAuthenticated", false)
    navigate('/login');

  };
  function handleSignIn() {
    console.log("handleSignIn")
    setisAuthenticated(true);
  }; 
  return (
    <div>
      <Menu size='small' inverted fixed='top'>
        <Container>
          <MenuItem name='home'  as={NavLink} to="/" />
          <MenuMenu position='right'>
            <MenuItem> {localStorage.getItem("isAuthenticated") === "true" ? <SignedIn signOut={handleSignOut} /> : 
                                          <SignedOut signIn={handleSignIn} />} 
            </MenuItem>
          </MenuMenu>
        </Container>
      </Menu>

    </div>
  )
}

