import { FormField, Button, Checkbox, Form, Container, Grid, GridRow, GridColumn } from 'semantic-ui-react';
import AuthService from '../services/authService';
import React, { useState, useEffect } from 'react';
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify'

export default function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const authService = new AuthService();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log("username", username)
        console.log("password", password)

        await login(username, password);
    };
    const login = async (username, password) => {
        try {

            axios.defaults.headers.common["Authorization"] = "";
                localStorage.setItem("authData", JSON.stringify(""));
                localStorage.setItem("authUsername", "");
                localStorage.setItem("isAuthenticated", false);

            const res = await authService.getLogin(username, password);
            if (res.status === 200) {
                const resData = res.data;
                const token = `Bearer ${resData.token}`;
                console.log("res", res)
                console.log("res.data", res.data)
                console.log("res.dataToken", resData.token)

                axios.defaults.headers.common["Authorization"] = token;
                axios.defaults.headers.common["Accept"] = "*/*";
                axios.defaults.headers.common["Connection"] = "keep-alive";

                localStorage.setItem("authData", JSON.stringify(resData));
                localStorage.setItem("authUsername", resData.username);
                localStorage.setItem("isAuthenticated", true);
                toast.success("Login Success!");

                if (resData.authorities[0] === "ROLE_ADMIN") {
                    navigate('/');
                }
                else {
                    navigate('/myprofile');
                }

            }
            else{
                toast.error("Login faiied!");

            }


        } catch (error) {
            console.error("Login failed:", error);
            toast.success(`Login failed!${error}`);

        }
    };

    return (
        <div>Login
            <Container>
                <Grid>
                    <GridRow>
                        <GridColumn width={6}>
                        </GridColumn>
                        <GridColumn width={4}>
                            <Form size='small' onSubmit={handleSubmit}>
                                <FormField>
                                    <label>User Name</label>
                                    <input id="username" value={username} onChange={(e) => setUsername(e.target.value)} placeholder='User Name' />
                                </FormField>
                                <FormField>
                                    <label>Password</label>
                                    <input id="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder='Password' type="password" />

                                </FormField>
                                {/* <FormField>
                                    <Checkbox label='I agree to the Terms and Conditions' />
                                </FormField> */}
                                <Button type='submit'>Submit</Button>
                            </Form>
                        </GridColumn>
                        <GridColumn width={6}>
                        </GridColumn>
                    </GridRow>
                </Grid>
            </Container>

        </div>
    )
}
