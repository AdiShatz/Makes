import { useState, useRef } from 'react';
import Modal from '../UI/Modal';

import classes from './AuthForm.module.css';

const AuthForm = (props) => {
    const userNameInputRef = useRef();
    const PasswordInputRef = useRef();

  const [isLogin, setIsLogin] = useState(true);

  const switchAuthModeHandler = () => {
    setIsLogin((prevState) => !prevState);
  };

  return (
    <Modal onClose={props.onClose}>
<div className={classes.auth}>
      <h1 >{isLogin ? 'התחברות' : 'יצירת משתמש '}</h1>

      <form>
        <div className={classes.control}>
          <label htmlFor='userName'>שם משתמש</label>
          <input type='userName' id='userName' required />
        </div>
        <div className={classes.control}>
          <label htmlFor='password'>סיסמא</label>
          <input type='password' id='password' required />
        </div>
        <div className={classes.actions}>
          <button>{isLogin ? 'התחבר' : 'צור משתמש'}</button>
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
