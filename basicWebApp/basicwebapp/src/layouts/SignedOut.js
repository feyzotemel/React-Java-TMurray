import React from 'react'
import { Button } from 'semantic-ui-react'

export default function SignedOut({signIn}) {
  return (
    <div>
        <Button size='small' onClick={signIn} >Login</Button>

        <Button size='small' >Register</Button>    
    </div>
  )
}
