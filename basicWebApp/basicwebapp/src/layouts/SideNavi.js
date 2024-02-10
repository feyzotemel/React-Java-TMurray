import React from 'react'
import { MenuItem, Menu } from 'semantic-ui-react'

export default function SideNavi() {
    return (
        <div>
            <Menu vertical>
                <MenuItem
                    name='home'

                />
                <MenuItem
                    name='messages'

                />
                <MenuItem
                    name='friends'

                />
            </Menu>
        </div>
    )
}