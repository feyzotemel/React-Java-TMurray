import React from 'react'
import MyProfile from '../pages/MyProfile';
import UserEdit from '../pages/UserEdit';
import Users from '../pages/Users';
import Login from '../pages/Login';
import SideNavi from './SideNavi';
import { Grid, GridRow, GridColumn } from 'semantic-ui-react'
import { Route, Routes } from "react-router-dom"
export default function Dashboard() {
  return (
    <div>
      <Grid>
        <GridRow>
          <GridColumn width={3}>
            <SideNavi />

          </GridColumn>
          <GridColumn width={13}>
            <Routes>
              <Route exact path="/" element={<Users/>} />
              <Route exact path="/users" element={<Users/>} />
              <Route exact path="/user/:id" element={<UserEdit/>} />
              <Route exact path="/login" element={<Login />} />
              <Route exact path="/myprofile" element={<MyProfile />} />             

            </Routes>
            {/* <Users />
            <Login />
            <MyProfile /> */}
          </GridColumn>
        </GridRow>
      </Grid>


    </div>
  )
}
