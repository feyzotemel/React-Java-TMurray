import React, { useState, useEffect } from 'react';
import { TableRow, TableHeaderCell, TableHeader, TableFooter, TableCell, TableBody, MenuItem, Icon, Menu, Table, Button } from 'semantic-ui-react';
import { NavLink } from "react-router-dom"
import UserService from '../services/userService';
import { useNavigate } from "react-router-dom";

export default function Users() {

  const [users, setUsers] = useState([]);
  const navigate = useNavigate();
  let isAuthenticated = localStorage.getItem("isAuthenticated");
let authData  = JSON.parse(localStorage.getItem("authData"));
  useEffect(() => {
    let userService = new UserService();

    if (isAuthenticated !== "true") {
      navigate('/login');
    } else {
      console.log("usersauthData",authData)

      let getLoginAuthority = authData.authorities[0]

      if (getLoginAuthority === "ROLE_ADMIN") {
        userService.getUsers().then(
          result => setUsers(result.data)
        )
      }
      else {
        navigate('/myprofile');
      }
    }


  }, []);

  return (
    <div>

      <Table celled>
        <TableHeader>
          <TableRow>
            <TableHeaderCell></TableHeaderCell>
            <TableHeaderCell>Id</TableHeaderCell>
            <TableHeaderCell>Full Name</TableHeaderCell>
            <TableHeaderCell>Email</TableHeaderCell>
            <TableHeaderCell>Date Birthday</TableHeaderCell>
            <TableHeaderCell>Date Registered</TableHeaderCell>
            <TableHeaderCell>Role</TableHeaderCell>
          </TableRow>
        </TableHeader>

        <TableBody>
          {
            users.map(user => (
              <TableRow key={user.id}>
                <TableCell>
                  <Button basic primary size='small' icon='pencil' as={NavLink} to={`/user/${user.id}`}></Button>
                  <Button basic color='red' size='small' icon='trash' as={NavLink} to={`/user/${user.id}`}></Button>
                </TableCell>
                <TableCell>{user.id}</TableCell>
                <TableCell>{user.fullName}</TableCell>
                <TableCell>{user.email}</TableCell>
                <TableCell>{user.dateBirthday}</TableCell>
                <TableCell>{user.dateRegistered}</TableCell>
                <TableCell>{user.authorities + ""}</TableCell>
              </TableRow>
            ))
          }

        </TableBody>

        <TableFooter>
          <TableRow>
            <TableHeaderCell colSpan='7'>
              <Menu floated='right' pagination>
                <MenuItem as='a' icon>
                  <Icon name='chevron left' />
                </MenuItem>
                <MenuItem as='a'>1</MenuItem>
                <MenuItem as='a'>2</MenuItem>
                <MenuItem as='a'>3</MenuItem>
                <MenuItem as='a'>4</MenuItem>
                <MenuItem as='a' icon>
                  <Icon name='chevron right' />
                </MenuItem>
              </Menu>
            </TableHeaderCell>
          </TableRow>
        </TableFooter>
      </Table>

    </div>
  )
}
