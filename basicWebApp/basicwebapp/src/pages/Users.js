import React, { useState, useEffect } from 'react';
import {
  TableRow,
  TableHeaderCell,
  TableHeader,
  TableFooter,
  TableCell,
  TableBody,
  MenuItem,
  Icon,
  Menu,
  Table,
} from 'semantic-ui-react';
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
            users.map(product => (
              <TableRow key={product.Id}> 
                <TableCell>{product.Id}</TableCell>
                <TableCell>{product.Id}</TableCell>
                <TableCell>{product.Full_Name}</TableCell>
                <TableCell>{product.Email}</TableCell>
                <TableCell>{product.Date_Birthday}</TableCell>
                <TableCell>{product.Date_Registered}</TableCell>
                <TableCell>{ roles.filter(x=> x.Id === product.RoleId)[0].Name}</TableCell>
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
