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
                                    <label>First Name</label>
                                    <input placeholder='First Name' />
                                </FormField>
                                <FormField>
                                    <label>Last Name</label>
                                    <input placeholder='Last Name' />
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
