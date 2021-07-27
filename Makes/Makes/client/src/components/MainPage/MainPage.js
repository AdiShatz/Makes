import React, {useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import LoginButton from "./LoginButton";
import GreetingLabel from "./GreetingLabel";
import MyGalleryButton from "./MyGalleryButton";
import LogoutButton from "./LogoutButton";

const MainPage = (props) => {

    const userName="אורח"; {/*should be changed to user login input*/}
        
    
    return (
        <div>
            <Header >
                <LoginButton/>
                <GreetingLabel userName={userName}/>
            </Header>
            <MainPageContent items={props.items} onBookItemClicked={props.onBookItemClicked}/>
            <Footer>
                <LogoutButton/>
                <MyGalleryButton/>
            </Footer>
        </div>
    );
}
export default MainPage;