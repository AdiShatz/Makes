import { useState, useRef, useContext } from 'react';
import Modal from '../UI/Modal';
import AuthContext from '../../store/auth-context'
import classes from './AuthForm.module.css';

const AuthForm = (props) => {
    const emailInputRef = useRef();
    const passwordInputRef = useRef();
    const userNameInputRef = useRef("אורח");
    
    const authCtx = useContext(AuthContext);

    const [isLogin, setIsLogin] = useState(true);
    const [isLoading, setIsLoading] = useState(false);


  const switchAuthModeHandler = () => {
    setIsLogin((prevState) => !prevState);
  };

  const submitHandler = (event) =>{
      event.preventDefault();
      const enteredEmail = emailInputRef.current.value;
      const enteredPassword = passwordInputRef.current.value;
      let enteredUserName;
      if(userNameInputRef && userNameInputRef.current){
        enteredUserName= userNameInputRef.current.value;
      }
      let url;
      
      setIsLoading(true);      
        if(isLogin){
            url = "http://localhost:8080/authentication/signIn";
        }
        else{
        url = "http://localhost:8080/authentication/joinUs";
        }

        fetch(url,
        {
            method: 'POST',
            body: JSON.stringify({
                email: enteredEmail,
                password: enteredPassword,
                userName: enteredUserName
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => {
            setIsLoading(false);
            if(res.ok){
                return res.json();
            }
            else{
                return res.json().then((data)=>{
                     let errorMessage= 'מצטערים, הייתה שגיאה בהתחברות';
                     if(data && data.error && data.error.message){ 
                     errorMessage = data.error.message; 
                     }
                     throw new Error(errorMessage);
                });
            }
        })
        .then((data) => { 
          if(data.error)
          {
         alert(data.error);
          }
          else{
            if(isLogin){
              authCtx.login(data.id, data.userName);
              localStorage.setItem("userEmail", data.email);
            }
          }
        })
        .catch(err => {
        alert(err.message);
        }).then(isLogin?props.onClose:switchAuthModeHandler);
        
    };

  return (
    <Modal onClose={props.onClose}>
<div className={classes.auth}>
      <h1 >{isLogin ? 'התחברות' : 'יצירת משתמש '}</h1>

      <form onSubmit={submitHandler}>
      {!isLogin && <div className={classes.control}>
          <label htmlFor='userName'>שם</label>
          <input type='userName' id='userName' required ref={isLogin ? "אורח" : userNameInputRef}/>
        </div>}
        <div className={classes.control}>
          <label htmlFor='email'>אימייל</label>
          <input type='email' id='email' required ref={emailInputRef}/>
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
