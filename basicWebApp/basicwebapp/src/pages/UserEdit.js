import React, { useState, useEffect } from 'react';
import {useParams} from 'react-router'
import UserService from '../services/userService';
import RoleService from '../services/roleService';
import {
    Button,
    Card,
    Image,
  } from 'semantic-ui-react';
  export default function UserEdit() {
  let {id} = useParams()
  
  const [user, setUser] = useState({}); 
  const [roles, setRoles] = useState([]);
    let userService = new UserService();
    let roleService = new RoleService();
  useEffect(() => {

    roleService.getRoles().then(
      result => setRoles(result.data)
    )
    userService.getUserById(id).then(
      result => setUser(result.data)
    )

  },[]);  
  
  
  
  return (
    <div>
  <Card.Group>
    <Card fluid>
      <Card.Content>
        <Image
          floated='right'
          size='mini'
          src='https://react.semantic-ui.com/images/avatar/large/steve.jpg'
        />
        <Card.Header>{user.Full_Name}</Card.Header>
        <Card.Meta>{user.Email}</Card.Meta>
        <Card.Description>
          Steve wants to add you to the group <strong>best friends</strong>
        </Card.Description>
      </Card.Content>
      <Card.Content extra>
        <div className='ui two buttons'>
          <Button basic color='green'>
            Update
          </Button>
          <Button basic color='red'>
            Delete
          </Button>
        </div>
      </Card.Content>
    </Card>
    </Card.Group>

  </div>)
}
