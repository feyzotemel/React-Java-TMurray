import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router'
import UserService from '../services/userService';
import {
    Button,
    Card,
    Image,
} from 'semantic-ui-react';
import { toast } from 'react-toastify'
import { useNavigate } from "react-router-dom";



export default function UserEdit() {
    let { id } = useParams()

    const [user, setUser] = useState({});
    let userService = new UserService();
    const navigate = useNavigate();

    useEffect(() => {
       
        userService.getUserById(id).then(
            result => setUser(result.data)
        )

    }, []);

    async function deleteSelectedUser(id) {
        try {
            const result = await userService.deleteUserById(id);
            console.log("result",result);
            var isDeleted = result.data;            
            console.log("isDeleted",isDeleted);
            if (isDeleted) {
                toast.success("User Successfully Deleted!");
                navigate('/users');

            } else {
                toast.error("User failed to Delete!");
            }
        } catch (error) {
            console.error("Error deleting user:", error);
            toast.error("An error occurred while deleting user!");
        }
    }

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
                        <Card.Header>{user.fullName}</Card.Header>
                        <Card.Meta>{user.email}</Card.Meta>
                        <Card.Description>
                            Steve wants to add you to the group <strong>best friends</strong>
                        </Card.Description>
                    </Card.Content>
                    <Card.Content extra>
                        <div className='ui two buttons'>
                            <Button basic color='green'>
                                Update
                            </Button>
                            <Button basic color='red' onClick={() => deleteSelectedUser(user.Id)}>
                                Delete
                            </Button>
                        </div>
                    </Card.Content>
                </Card>
            </Card.Group>

        </div>)
}
