import React, {Fragment, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import LoginButton from "./LoginButton";
import GreetingLabel from "./GreetingLabel";
import MyGalleryButton from "./MyGalleryButton";
import LogoutButton from "./LogoutButton";
import Button from "../UI/Buttton";

const MainPage = (props) => {

    const userName="אורח"; {/*should be changed to user login input*/}
    
    // const handleLoginClick(){
    //     if(isLoggedIn===false){
    //       setName(inputText);
    //       setLoginButtonText("התנתקות");
    //       setIsLoggedIn(true);
    //        setInputVisibility("hidden");
    //        setCreateBtnVisibility("visible");
      
    //     }
    //     else{
    //       setName("");
    //       setLoginButtonText("התחברות");
    //       setIsLoggedIn(false);
    //        setInputVisibility("visible");
    //        setCreateBtnVisibility("hidden");
      
    //     }
    //   }
    
    return (
        <Fragment>
            <Header >
                {/* <LoginButton/> */}

                <Button>התחבר</Button>

                <GreetingLabel userName={userName}/>
            </Header>
            <MainPageContent items={props.items} onBookItemClicked={props.onBookItemClicked}/>
            <Footer>
                <LogoutButton/>
                <MyGalleryButton/>
            </Footer>
        </Fragment>
    );
}
export default MainPage;