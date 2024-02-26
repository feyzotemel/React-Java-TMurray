import React from 'react'
import { MenuItem, Menu } from 'semantic-ui-react'
import { NavLink} from "react-router-dom"

export default function SideNavi() {
    return (
        <div>
            <Menu vertical>
                <MenuItem
                    name='home' as={NavLink} to="/" 

                />
                <MenuItem
                    name='My Profile' as={NavLink} to="/myprofile"

                />
               
            </Menu>
        </div>
    )
}