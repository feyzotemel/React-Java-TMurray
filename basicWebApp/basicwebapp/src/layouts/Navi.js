import React, { useState } from 'react';
import { MenuMenu, MenuItem, Menu, Container } from 'semantic-ui-react'
import SignedIn from './SignedIn'
import SignedOut from './SignedOut'
export default function Navi() {
  const [isAuthenticated, setisAuthenticated] = useState(true);
  function handleSignOut() {
    console.log("handleSignOut")
    setisAuthenticated(false);
  };
  function handleSignIn() {
    console.log("handleSignIn")
    setisAuthenticated(true);
  }; 
  return (
    <div>
      <Menu size='small' inverted fixed='top'>
        <Container>
          <MenuItem name='home' />
          <MenuItem name='messages' />
          <MenuMenu position='right'>
            <MenuItem> {isAuthenticated ? <SignedIn signOut={handleSignOut} /> : 
                                          <SignedOut signIn={handleSignIn} />} 
            </MenuItem>
          </MenuMenu>
        </Container>
      </Menu>

    </div>
  )
}

