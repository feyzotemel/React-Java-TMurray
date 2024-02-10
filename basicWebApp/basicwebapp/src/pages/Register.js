import React from 'react'
import {
    FormTextArea,
    FormSelect,
    FormRadio,
    FormInput,
    FormGroup,
    FormCheckbox,
    FormButton,
    Form,
  } from 'semantic-ui-react'

  const options = [
    { key: 'm', text: 'Male', value: 'male' },
    { key: 'f', text: 'Female', value: 'female' },
    { key: 'o', text: 'Other', value: 'other' },
  ]
export default function Register() {
    state = {}

  handleChange = (e, { value }) => this.setState({ value })
  const { value } = this.state

  return (
    <div>Register
 <Form>
        <FormGroup widths='equal'>
          <FormInput fluid label='First name' placeholder='First name' />
          <FormInput fluid label='Last name' placeholder='Last name' />
          <FormSelect
            fluid
            label='Gender'
            options={options}
            placeholder='Gender'
          />
        </FormGroup>
        <FormGroup inline>
          <label>Size</label>
          <FormRadio
            label='Small'
            value='sm'
            checked={value === 'sm'}
            onChange={this.handleChange}
          />
          <FormRadio
            label='Medium'
            value='md'
            checked={value === 'md'}
            onChange={this.handleChange}
          />
          <FormRadio
            label='Large'
            value='lg'
            checked={value === 'lg'}
            onChange={this.handleChange}
          />
        </FormGroup>
        <FormTextArea label='About' placeholder='Tell us more about you...' />
        <FormCheckbox label='I agree to the Terms and Conditions' />
        <FormButton>Submit</FormButton>
      </Form>



    </div>
  )
}
