import React from 'react'
import { Dropdown, DropdownItem, DropdownMenu, Image } from 'semantic-ui-react'
import { NavLink} from "react-router-dom"

export default function SignedIn({signOut}) {

    return (
        <div>
                <Image src='https://react.semantic-ui.com/images/wireframe/square-image.png' avatar spaced="right"/>
                <Dropdown pointing="top left" text='UserName'>
                    <DropdownMenu>
                        <DropdownItem as={NavLink} to="/myprofile" text="My Profile" icon="user" />
                        <DropdownItem onClick={signOut} text="Logout" icon="sign-out" />
                    </DropdownMenu>
                </Dropdown>
                
        </div>
    )
}
