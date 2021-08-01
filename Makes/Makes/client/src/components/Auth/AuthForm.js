import { useState, useRef } from 'react';
import Modal from '../UI/Modal';

import classes from './AuthForm.module.css';

const AuthForm = (props) => {
    const userNameInputRef = useRef();
    const passwordInputRef = useRef();

  const [isLogin, setIsLogin] = useState(true);
  const [isLoading, setIsLoading] = useState(false);


  const switchAuthModeHandler = () => {
    setIsLogin((prevState) => !prevState);
  };

  const submitHandler = (event) =>{
      const enteredUserName = userNameInputRef.current.value;
      const enteredPassword = passwordInputRef.current.value;

      setIsLoading(true);
    if(isLogin){
        // do user data verification
        console.log("User data verification");
    }
    else{
        // send the new data to backend side
        console.log("Send Post request");

        // fetch("API_URL includind API_KEY",
        // {
        //     method: 'POST',
        //     body: JSON.stringify({
        //         userName: enteredUserName,
        //         password: enteredPassword,
        //         returnsecureToken: true
        //     }),
        //     headers: {
        //         'Content-Type': 'application/json'
        //     }
        // }
        // ).then(res=>{
        //      setIsLoading(false);
        //     if(res.ok){
        //         //Do Something if needed...
        //     }
        //     else{
        //         return res.json().then((data)=>{
        //             //Show Error Modal
        //              let errorMessage= 'Authentication failed!';
        //              if(data && data.error && data.error.message){ (DEPENDWS ON BACKEND STRUCTURE)
        //              errorMessage = data.error.message; 
        //              }
        //             console.log("ERROR Accured!");
        //         });
        //     }
        // });
    }
  }

  return (
    <Modal onClose={props.onClose}>
<div className={classes.auth}>
      <h1 >{isLogin ? 'התחברות' : 'יצירת משתמש '}</h1>

      <form onSubmit={submitHandler}>
        <div className={classes.control}>
          <label htmlFor='userName'>שם משתמש</label>
          <input type='userName' id='userName' required ref={userNameInputRef}/>
        </div>
        <div className={classes.control}>
          <label htmlFor='password'>סיסמא</label>
          <input type='password' id='password' required ref={passwordInputRef}/>
        </div>
        <div className={classes.actions}>
          {!isLoading && <button>{isLogin ? 'התחבר' : 'צור משתמש'}</button>}
          {isLoading && <p>...אנא המתן</p>}
          <button
            type='button'
            className={classes.toggle}
            onClick={switchAuthModeHandler}
          >
            {isLogin ? 'צור משתמש חדש' : 'התחבר עם משתמש קיים'}
          </button>
        </div>
      </form>
      </div>
    </Modal>
  );
};

export default AuthForm;
