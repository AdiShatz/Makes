import React, {Fragment, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import GreetingLabel from "./GreetingLabel";
import Button from "../UI/Button";
import AuthForm from "../Auth/AuthForm";


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
            {loginIsShown && <AuthForm onClose={hideLoginHandler} />}
            <Header >

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