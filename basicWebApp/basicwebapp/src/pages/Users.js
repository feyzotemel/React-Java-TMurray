import React, { useState, useEffect } from 'react';
import { TableRow,TableHeaderCell,TableHeader,TableFooter,TableCell,TableBody,MenuItem,Icon,Menu,Table,Button} from 'semantic-ui-react';
import { NavLink} from "react-router-dom"
import UserService from '../services/userService';
import RoleService from '../services/roleService';
export default function Users() {

  const [users, setUsers] = useState([]);
  const [roles, setRoles] = useState([]);

  useEffect(() => {
    let userService = new UserService();
    let roleService = new RoleService();
    roleService.getRoles().then(
      result => setRoles(result.data)
    )
    userService.getUsers().then(
      result => setUsers(result.data)
    )
  },[]);

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
              <TableRow key={user.Id}> 
                <TableCell> 
                  <Button basic primary size='small' icon='pencil' as={NavLink} to={`/user/${user.Id}`}></Button>
                  <Button basic color='red' size='small' icon='trash' as={NavLink} to={`/deleteuser/${user.Id}`}></Button>
                </TableCell>
                <TableCell>{user.Id}</TableCell>
                <TableCell>{user.Full_Name}</TableCell>
                <TableCell>{user.Email}</TableCell>
                <TableCell>{user.Date_Birthday}</TableCell>
                <TableCell>{user.Date_Registered}</TableCell>
                <TableCell>{ roles.filter(x=> x.Id === user.RoleId)[0].Name}</TableCell>
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
