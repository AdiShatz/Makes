import React, {Fragment, useContext, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import AuthForm from "../Auth/AuthForm";
import AuthContext from "../../store/auth-context";


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
        <React.Fragment>
            {loginFormIsShown && <AuthForm onClose={hideLoginFormHandler} />}
            <Header >

                {!isLoggedIn && <Button type="input" onClick={showLoginFormHandler}>התחבר</Button>}
                <label> שלום {username} </label>
            </Header>
            <MainPageContent
            items={props.items} 
            onBookItemClicked={isLoggedIn?props.onBookItemClicked:props.onNotLoggedIn}/>
            <Footer>
            {isLoggedIn &&<Button type="button" onClick={logoutHandler}>התנתק</Button>}
           {isLoggedIn && <Button type="button" onClick={props.onGalleryClicked}>הגלריה שלי</Button>}
            </Footer>
        </React.Fragment>
    );
}
export default MainPage;