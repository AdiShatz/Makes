import { useContext } from 'react';

import Modal from '../UI/Modal';
import classes from './Login.module.css';

const Login = (props) => {

  return (
    <Modal onClose={props.onClose}>
      
      <input></input>
      <label>שם</label>
      <br/>
      <input></input>
      <label>סיסמא</label>
      <br/>
      <button>התחבר</button>
    </Modal>
  );
};

export default Login;
