import React, {Fragment, useContext, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import AuthForm from "../Auth/AuthForm";
import AuthContext from "../../store/auth-context";
import './MainPage.css';
import '../UI/Header.css'

const MainPage = (props) => {

  const authCtx = useContext(AuthContext);

  const isLoggedIn = authCtx.isLoggedIn;
  const username = authCtx.username;

    
    const [loginFormIsShown, setLoginFormIsShown] = useState(false);

    const showLoginFormHandler = () => {
      setLoginFormIsShown(true);
    };
  
    const hideLoginFormHandler = () => {
      setLoginFormIsShown(false);
    };

    const logoutHandler = () => {
        authCtx.logout();
      };

    return (
        <div >
            {loginFormIsShown && <AuthForm onClose={hideLoginFormHandler} />}
            <Header className="header">
            <nav>
                <ul>
                 <li>{!isLoggedIn && <Button className="login-button" type="input" onClick={showLoginFormHandler}>התחבר</Button>}</li>
                 <li><label> שלום {username} </label></li>
                </ul>
            </nav>
            </Header>
            <MainPageContent items={props.items} onBookItemClicked={props.onBookItemClicked}/>
            <Footer>
            {isLoggedIn &&<Button type="button" onClick={logoutHandler}>התנתק</Button>}
           {isLoggedIn && <Button type="button" onClick={props.onGalleryClicked}>הגלריה שלי</Button>}
            </Footer>
        </div>
    );
}
export default MainPage;