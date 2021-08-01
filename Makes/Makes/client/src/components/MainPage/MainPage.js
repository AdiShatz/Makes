import React, {Fragment, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import LoginButton from "./LoginButton";
import GreetingLabel from "./GreetingLabel";
import MyGalleryButton from "./MyGalleryButton";
import LogoutButton from "./LogoutButton";
import Button from "../UI/Button";
import Login from "../UI/Login";


const MainPage = (props) => {

    const userName="אורח"; {/*should be changed to user login input*/}
    
    const [loginIsShown, setLoginIsShown] = useState(false);

    const showLoginHandler = () => {
      setLoginIsShown(true);
    };
  
    const hideLoginHandler = () => {
      setLoginIsShown(false);
    };

    const logoutHandler = () => {
        console.log("LOGGED OUT"); // TO DELETE
      };

     const myGalleryHandler = () => {
        console.log("My Gallery"); // TO DELETE
      };
  

    return (
        <React.Fragment>
            {loginIsShown && <Login onClose={hideLoginHandler} />}
            <Header >
                {/* <LoginButton/> */}

                <Button type="input" onClick={showLoginHandler}>התחבר</Button>

                <GreetingLabel userName={userName}/>
            </Header>
            <MainPageContent items={props.items} onBookItemClicked={props.onBookItemClicked}/>
            <Footer>
            <Button type="button" onClick={logoutHandler}>התנתק</Button>
            <Button type="button" onClick={myGalleryHandler}>הגלריה שלי</Button>
            </Footer>
        </React.Fragment>
    );
}
export default MainPage;