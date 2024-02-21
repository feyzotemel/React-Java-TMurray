import React from 'react'
import { FormField, Button, Checkbox, Form, Container,Grid,GridRow, GridColumn} from 'semantic-ui-react'

export default function Login() {
    return (
        <div>Login
            <Container>
                <Grid>
                    <GridRow>
                        <GridColumn width={6}>
                        </GridColumn>
                        <GridColumn width={4}>
                            <Form size='small'>
                                <FormField>
                                    <label>User Name</label>
                                    <input placeholder='User Name' />
                                </FormField>
                                <FormField>
                                    <label>Password</label>
                                    <input placeholder='Password' type="password" />
                                </FormField>
                                <FormField>
                                    <Checkbox label='I agree to the Terms and Conditions' />
                                </FormField>
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
