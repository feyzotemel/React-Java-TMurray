import React from 'react'
import MyProfile from '../pages/MyProfile';
import Users from '../pages/Users';
import Login from '../pages/Login';
import SideNavi from './SideNavi';
import { Grid, GridRow, GridColumn } from 'semantic-ui-react'

export default function Dashboard() {
  return (
    <div>
      <Grid>
        <GridRow>
          <GridColumn width={3}>
            <SideNavi />

          </GridColumn>
          <GridColumn width={13}>
            <Users />
            <Login />
            <MyProfile />
          </GridColumn>
        </GridRow>
      </Grid>


    </div>
  )
}
